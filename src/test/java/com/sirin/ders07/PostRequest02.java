package com.sirin.ders07;

import com.sirin.testBase.RestfulTestBase;
import com.sirin.testData.RestfulTestData;
import org.junit.Test;

public class PostRequest02 extends RestfulTestBase {
  /*
    https://restful-booker.herokuapp.com/booking
    { "firstname": "Selim",
               "lastname": "Ak",
               "totalprice": 11111,
               "depositpaid": true,
               "bookingdates": {
                   "checkin": "2020-09-09",
                   "checkout": "2020-09-21"
                }
 }
 gönderildiğinde, Status kodun 200 olduğunu ve dönen response body nin ,
 "booking": {
         "firstname": " Selim ",
         "lastname": " Ak ",
         "totalprice":  11111,
         "depositpaid": true,
         "bookingdates": {
             "checkin": "2020-09-01",
              "checkout": " 2020-09-21”
         },
        }
olduğunu test edin
     */

    @Test
    public void test01() {
        //url
        spec.pathParam("first","booking");

        //requestBody
        //expectedData

        RestfulTestData testData = new RestfulTestData();





    }
}
