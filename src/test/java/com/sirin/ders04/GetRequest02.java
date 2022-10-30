package com.sirin.ders04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
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

    @Test
    public void test02() {


        /*
    https://restful-booker.herokuapp.com/booking/1001 url'ine
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response'un
    status kodunun 418 oldugunu
    ve Response body'sinin "Not Found" icerdigini
    ve Response body'sinin "API" icermedigini test edin
         */

        String url = "https://restful-booker.herokuapp.com/booking/1001";
        Response response = given().accept(ContentType.JSON).when().get(url);

        response.prettyPrint();
        System.out.println(response.getStatusCode());
        response.then().assertThat().statusCode(418);
        Assert.assertTrue(response.asString().contains("I'm a teapot"));
        Assert.assertFalse(response.asString().contains("API"));


    }

}
