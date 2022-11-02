package com.sirin.ders05;

import com.sirin.testBase.Restful02TestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRequest11 extends Restful02TestBase {
    /*
    https://restful-booker.herokuapp.com/booking/56 url’ine bir request yolladigimda
    HTTP Status Code’unun 200
    ve response content type’inin “application/JSON” oldugunu
    ve response body’sinin asagidaki gibi oldugunu test edin
 {
    "firstname": "Dane",
    "lastname": "Dominguez",
    "totalprice": 111,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2018-01-01",
        "checkout": "2019-01-01"
    },
    "additionalneeds": "Breakfast"
}
*/

    @Test
    public void test01() {

        spec.pathParams("first","booking","second",52);

        Response response =
                given().
                spec(spec).
                accept(ContentType.JSON).
                when().
                get("/{first}/{second}");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        assertEquals("Dane",jsonPath.getString("firstname"));
        assertEquals("Dominguez",jsonPath.getString("lastname"));
        assertEquals(111,jsonPath.getInt("totalprice"));
        assertEquals("2018-01-01",jsonPath.getString("bookingdates.checkin"));
        assertEquals(true,jsonPath.getBoolean("depositpaid"));
        assertEquals("2019-01-01",jsonPath.getString("bookingdates.checkout"));
        assertEquals(200,response.getStatusCode());




    }
}
