package com.sirin.ders04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest02 {
    /*
    https://restful-booker.herokuapp.com/booking url'ine
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response'un
    status kodunun 200
    content type'inin "application/json" oldugunu test edin
     */

    @Test
    public void test01() {

        String url = "https://restful-booker.herokuapp.com/booking";

        Response response = given().accept(ContentType.JSON).when().get(url);
        response.then().assertThat().statusCode(200).contentType(ContentType.JSON);
    }
}
