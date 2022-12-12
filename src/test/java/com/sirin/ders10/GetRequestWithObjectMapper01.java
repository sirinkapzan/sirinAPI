package com.sirin.ders10;

import com.sirin.testBase.JsonPlaceHolderTestBase;
import com.sirin.utilities.JsonUtil;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

import org.junit.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestWithObjectMapper01 extends JsonPlaceHolderTestBase {

        /*
    GetRequestWithObjectMapper01:
 https://jsonplaceholder.typicode.com/todos/198 url’ine bir get request gönderildiğinde,
Dönen response ‘un status kodunun 200 ve body kısmının
 {
 "userId": 10,
 "id": 198,
 "title": "quis eius est sint explicabo",
 "completed": true
 }

Olduğunu Object Mapper kullanarak test edin
     */

    @Test
    public void test() {

        spec.pathParams("firstParam", "todos", "secondParam", 198);

        String jsonExpectedBody = " {\n" +
                " \"userId\": 10,\n" +
                " \"id\": 198,\n" +
                " \"title\": \"quis eius est sint explicabo\",\n" +
                " \"completed\": true\n" +
                " }";

        Map<String, Object> expectedData = JsonUtil.convertJsonToJava(jsonExpectedBody, Map.class);
        System.out.println(expectedData);

        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("/{firstParam}/{secondParam}");

        response.prettyPrint();

        //1-hemCrestMatchers
        response.then().assertThat().contentType(ContentType.JSON);
        response.then().assertThat().statusCode(200);
        response.then().assertThat().body("userId", equalTo(10));
        response.then().assertThat().body("id", equalTo(198));
        response.then().assertThat().body("title", equalTo("quis eius est sint explicabo"));
        response.then().assertThat().body("completed", equalTo(true));

        //


        Map<String, Object> actualData = JsonUtil.convertJsonToJava(response.asString(), Map.class);

        assertEquals(expectedData.get("userId"), actualData.get("userId"));
        assertEquals(expectedData.get("id"), actualData.get("id"));
        assertEquals(expectedData.get("title"), actualData.get("title"));
        assertEquals(expectedData.get("completed"), actualData.get("completed"));


    }


}
