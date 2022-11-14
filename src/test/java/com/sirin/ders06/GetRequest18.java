package com.sirin.ders06;

import com.sirin.testBase.RestfulTestBase;
import com.sirin.testData.RestfulTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.*;

public class GetRequest18 extends RestfulTestBase {
            /*
    https://restful-booker.herokuapp.com/booking/1 url ine bir istek gönderildiğinde
 dönen response body nin
{
 "firstname": "Eric",
 "lastname": "Smith",
 "totalprice": 555,
 "depositpaid": false,
 "bookingdates": {
 "checkin": "2016-09-09",
 "checkout": "2017-09-21"
 }
 } gibi olduğunu test edin
     */

    @Test
    public void test01() {

        //Url
        spec.pathParams("first", "booking",
                "second", 2);
        Response response = given().spec(spec).contentType(ContentType.JSON).
                when().get("/{first}/{second}");

        //expected data
        RestfulTestData restful02TestData = new RestfulTestData();
        HashMap<String, Object> expectedData = restful02TestData.setUpTestBase();
        System.out.println(expectedData);

        //actual data
        HashMap<String, Object> actualData = response.as(HashMap.class);
        System.out.println(actualData);

        //assertion
        assertEquals(
                expectedData.get("firstname"),
                actualData.get("firstname"));
        assertEquals(
                expectedData.get("lastname"),
                actualData.get("lastname"));
        assertEquals(
                expectedData.get("totalprice"),
                actualData.get("totalprice"));
        assertEquals(
                expectedData.get("depositpaid"),
                actualData.get("depositpaid"));
        assertEquals(
                ((HashMap)(expectedData.get("bookingdates"))).get("checkin"),
                ((HashMap)(actualData.get("bookingdates"))).get("checkin"));
        assertEquals(
                ((HashMap)(expectedData.get("bookingdates"))).get("checkout"),
                ((HashMap)(actualData.get("bookingdates"))).get("checkout"));
    }
}


































