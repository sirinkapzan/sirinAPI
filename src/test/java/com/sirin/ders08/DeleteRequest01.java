package com.sirin.ders08;

import com.sirin.testBase.DummyTestBase;
import com.sirin.testData.DummyTestData;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matcher;


import static org.hamcrest.Matchers.*;
import org.json.JSONObject;

import static org.junit.Assert.*;

import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;

public class DeleteRequest01 extends DummyTestBase {
        /*
    http://dummy.restapiexample.com/api/v1/delete/2 bir DELETE request gönderdiğimde

 Dönen response un status kodunun 200 ve body kısmının aşağıdaki gibi olduğunu test edin
 {
 "status": "success",
 "data": "2",
 "message": "Successfully! Record has been deleted"
 }
     */

    @Test
    public void test01() {

        //url
        spec.pathParams("first", "v1", "second", "delete", "third", 2);

        //expectedData olustur
        DummyTestData testData = new DummyTestData();
        JSONObject expectedData = testData.setUpDeleteExpectedData();

        //request gonder
        Response response =
                given().contentType(ContentType.JSON).spec(spec).auth().basic("admin", "password123").
                        when().delete("/{first}/{second}/{third}");

        //De-Serialization
        HashMap<String, Object> actualData = response.as(HashMap.class);

        //Assertion

        assertEquals(200, response.getStatusCode());
        assertEquals(expectedData.getString("status"), actualData.get("status"));
        assertEquals(expectedData.getString("data"), actualData.get("data"));
        assertEquals(expectedData.getString("message"), actualData.get("message"));

        // Matchers
        response.then().assertThat().statusCode(200).body(
                "status", equalTo(expectedData.getString("status")),
                "data", equalTo( expectedData.getString("data")),
                "message", equalTo(expectedData.getString("message")));
    }

}





























