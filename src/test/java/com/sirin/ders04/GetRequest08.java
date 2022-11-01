package com.sirin.ders04;

import com.sirin.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest08 extends JsonPlaceHolderTestBase {

    /*
    https://jsonplaceholder.typicode.com/todos/123 url'ine
    accept type'i "application/json" olan GET request'i yolladigimda
    gelen response’un
    status kodunun 200
    ve content type'inin "application/json"
    ve Headers'daki "Server" in "cloudflare"
    ve response body'deki "userId"'nin 7
    ve "title" in "esse et quis iste est earum aut impedit"
    ve "completed" bolumunun false oldugunu test edin
    */

    @Test
    public void test01(){
        String url = "https://jsonplaceholder.typicode.com/todos/123";

        spec.pathParams("first","todos","second",123);

        Response response = given().spec(spec).when().get("/{first}/{second}");

        response.prettyPrint();

        response.then().header("Server",equalTo("coludfare"));

    }
}
