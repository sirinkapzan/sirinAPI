package com.sirin.ders06;

import com.sirin.testBase.ReqresTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.junit.Assert.*;

import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest16 extends ReqresTestBase {


    //        Given
    //          https://reqres.in/api/unknown/3
    //        When
    //            User send a GET request to the URL
    //        Then
    //            HTTP Status Code should be 200
    //        And
    //            Response content type is "application/json"
    //        And
    //            Response body should be like;(Soft Assertion)
    //        {
    //        "data": {
    //            "id": 3,
    //            "name": "true red",
    //            "year": 2002,
    //            "color": "#BF1932",
    //            "pantone_value": "19-1664"
    //        },
    //        "support": {
    //            "url": "https://reqres.in/#support-heading",
    //            "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    //        }
    // }


    @Test
    public void test01() {
        spec.pathParams("first", "api",
                "second", "unknown",
                "third", 3);

        Response response = given().accept(ContentType.JSON).spec(spec).
                when().get("{first}/{second}/{third}");

        JsonPath jsonPath = response.jsonPath();

        assertEquals(200, response.getStatusCode());
        assertEquals("application/json; charset=utf-8", response.getContentType());
        assertEquals(3, jsonPath.getInt("data.id"));
        assertEquals("true red", jsonPath.getString("data.name"));
        assertEquals(2002, jsonPath.getInt("data.year"));
        assertEquals("#BF1932", jsonPath.getString("data.color"));
        assertEquals("19-1664", jsonPath.getString("data.pantone_value"));
        assertEquals("https://reqres.in/#support-heading", jsonPath.getString("support.url"));
        assertEquals("To keep ReqRes free, contributions towards server costs are appreciated!", jsonPath.getString("support.text"));


    }
}

























