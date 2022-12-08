package com.sirin.ders09;

import com.sirin.pojos.TodosPojo;
import com.sirin.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class PostRequestWithPojo01 extends JsonPlaceHolderTestBase {
        /*
    https://jsonplaceholder.typicode.com/todos url ‘ine bir request gönderildiğinde
 Request body{
 "userId": 21,
 "id": 201,
 "title": "Tidy your room",
 "completed": false
}
 Status kodun 201,response body ‘nin ise

{
 "userId": 21,
 "id": 201,
 "title": "Tidy your room",
 "completed": false
 }
     */

    @Test
    public void test() {
        spec.pathParam("first","todos");

        TodosPojo requestExpected = new TodosPojo(21,201,"Tidy your room",false);

        System.out.println(requestExpected);

        Response response =
                given()
                        .contentType(ContentType.JSON).spec(spec).auth().basic("admin","password123")
                        .body(requestExpected)
                        .when().post("/{first}");

        response.prettyPrint();

        //De-Serialization

        TodosPojo actualData = response.as(TodosPojo.class);

        assertEquals(201,response.getStatusCode());
        assertEquals(requestExpected.getUserId(),actualData.getUserId());
        assertEquals(requestExpected.getId(),actualData.getId());
        assertEquals(requestExpected.getTitle(),actualData.getTitle());
        assertEquals(requestExpected.isCompleted(),actualData.isCompleted());
    }
}
