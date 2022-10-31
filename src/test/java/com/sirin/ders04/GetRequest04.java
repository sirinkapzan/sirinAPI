package com.sirin.ders04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.*;

import static org.junit.Assert.*;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest04 {
    /*
     Given
         https://reqres.in/api/users/23
     When
         User send a GET Request to the url
     Then
         HTTP Status code should be 404
     And
         Status Line should be HTTP/1.1 404 Not Found
     And
         Server is "cloudflare"
     And
         Response body should be empty
  */

    @Test
    public void test01() {
        String url = "https://reqres.in/api/users/23";

        Response response = given().when().get(url);

        assertEquals(2, response.asString().replaceAll("\\s", "").length());
        assertEquals(response.getHeader("server"), "cloudflare");

    }
}