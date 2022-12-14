package com.sirin.ders09;

import com.sirin.testBase.RestfulTestBase;
import com.sirin.pojos.BookingDatesPojo;
import com.sirin.pojos.BookingPojo;
import com.sirin.pojos.BookingResponsePojo;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo02 extends RestfulTestBase {
    /*
    https://restful-booker.herokuapp.com/booking
    request body {
                   "firstname": "Selim",
                   "lastname": "Ak",
                   "totalprice": 15000,
                   "depositpaid": true,
                   "bookingdates": {
                       "checkin": "2020-09-09",
                       "checkout": "2020-09-21"
                    }
                 }

   Status code is 200
    response body
    {
                      "bookingid": 11,
                      "booking": {
                          "firstname": "Selim",
                          "lastname": "Ak",
                          "totalprice": 15000,
                          "depositpaid": true,
                          "bookingdates": {
                              "checkin": "2020-09-09",
                              "checkout": "2020-09-21"
                          }
                      }
                   }
     */


    @Test
    public void test(){

        spec.pathParam("first","booking");

        BookingDatesPojo bookingdates=new BookingDatesPojo("2020-09-09","2020-09-21");
        System.out.println(bookingdates);

        BookingPojo bookingPojo=
                new BookingPojo("Sirin","K.",15000,true,bookingdates);
        System.out.println(bookingPojo);

        Response response=given().
                contentType(ContentType.JSON).
                spec(spec).
                auth().
                basic("admin","password123").
                body(bookingPojo).
                when().
                post("/{first}");

        response.prettyPrint();

        BookingResponsePojo actualData=response.as(BookingResponsePojo.class);

        Assert.assertEquals(200,response.getStatusCode());
        Assert.assertEquals(bookingPojo.getFirstname(),actualData.getBooking().getFirstname());
        Assert.assertEquals(bookingPojo.getLastname(),actualData.getBooking().getLastname());
        Assert.assertEquals(bookingPojo.getTotalprice(),actualData.getBooking().getTotalprice());
        Assert.assertEquals(bookingPojo.isDepositpaid(),actualData.getBooking().isDepositpaid());
        Assert.assertEquals(bookingPojo.getBookingdates().getCheckin(),
                actualData.getBooking().getBookingdates().getCheckin());

        Assert.assertEquals(bookingPojo.getBookingdates().getCheckout(),
                actualData.getBooking().getBookingdates().getCheckout());













    }



}

