package com.sirin.ders08;

import com.sirin.testBase.JsonPlaceHolderTestBase;
import com.sirin.testData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class PatchRequest01 extends JsonPlaceHolderTestBase {

    /*
https://jsonplaceholder.typicode.com/todos/198 URL ine aşağıdaki body gönderdiğimde
{

  "title": "API calismaliyim"

 }
Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
{
"userId": 10,
"title": "API calismaliyim"
"completed": true,
"id": 198
}
 */
    @Test
    public void test01() {

        //url
        spec.pathParams("first", "todos", "second", 198);

        // expected ve request data olustur

        JsonPlaceHolderTestData testData = new JsonPlaceHolderTestData();
        JSONObject requestData = testData.setUpPatchRequestData();
        JSONObject expectedData = testData.setUpPatchExpectedData();

        //System.out.println(requestData);
        //System.out.println(expectedData);

        // request gonder

        Response response =
                given().contentType(ContentType.JSON).spec(spec).auth().basic("admin", "password123").
                        body(requestData.toString()).
                        when().patch("/{first}/{second}");

        response.prettyPrint();

        // De-Serialization

        HashMap<String, Object> actualData = response.as(HashMap.class);

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.getInt("userId"), actualData.get("userId"));
        assertEquals(expectedData.getBoolean("completed"), actualData.get("completed"));
        assertEquals(expectedData.getString("title"), actualData.get("title"));
        assertEquals(expectedData.getInt("id"), actualData.get("id"));


    }

}

































