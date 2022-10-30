package com.sirin.ders05;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.MatcherAssert;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest03 {

     /*
    https://restful-booker.herokuapp.com/booking/7 url'ine
accept type'i "application/json" olan GET request'i yolladigimda
gelen response'un
status kodunun 418
ve content type'inin "text/plain; charset=utf-8"

{
    "firstname": "Jim",
    "lastname": "Brown",
    "totalprice": 842,
    "depositpaid": true,
    "bookingdates": {
        "checkin": "2017-12-27",
        "checkout": "2021-11-10"
    }
}


ve firstname'in "Mary"
ve lastname'in "Jones"
ve checkin date'in 2018-10-07"
ve checkout date'in 2020-09-30 oldugunu test edin
     */

    @Test
    public void test01() {
        String url = "https://petstore.swagger.io/v2/pet/12" +
                "";
        Response response = given().
                accept(ContentType.JSON).
                when().get(url);
        response.prettyPrint();
        System.out.println(response.getStatusCode());
        System.out.println(response.getContentType());

//        response
//                .then()
//                .body("category.name",Matchers.equalTo("Cat"))
//                .body("name", Matchers.equalTo("markiz"))
//                .body("tags[0].name", Matchers.equalTo("string"));
//
        response.
                then().
                statusCode(200).
                contentType(ContentType.JSON).
                body("category.name",equalTo("Dogs"),
                        "name", equalTo("markiz"),
                        "tags[0].name",equalTo("string"));
    }
}
