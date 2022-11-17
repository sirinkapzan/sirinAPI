package com.sirin.ders07;

import com.sirin.testBase.JsonPlaceHolderTestBase;
import com.sirin.testData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class PostRequest03 extends JsonPlaceHolderTestBase {
        /*
    https://jsonplaceholder.typicode.com/todos URL ine aşağıdaki body gönderildiğinde,
     {
     "userId": 55,
     "title": "Tidy your room",
     "completed": false
   }
Dönen response un Status kodunun 201 ve response body nin aşağıdaki gibi olduğunu test edin
   {
     "userId": 55,
     "title": "Tidy your room",
     "completed": false,
     "id": …
    }
     */

    @Test
    public void test01() {

        spec.pathParam("first", "todos");

        JsonPlaceHolderTestData testObject = new JsonPlaceHolderTestData();

        JSONObject expectedRequest = testObject.setUpPostData();

        System.out.println(expectedRequest);

        Response response = given().
                contentType(ContentType.JSON).
                spec(spec).
                auth().basic("admin", "password123").
                body(expectedRequest.toString()).
                when().
                post("/{first}");

        response.prettyPrint();

        //Matchers

        response.
                then().
                assertThat().
                statusCode(expectedRequest.getInt("statusCode")).
                body("completed", equalTo(expectedRequest.getBoolean("completed")),
                        "title", equalTo(expectedRequest.getString("title")),
                        "userId", equalTo(expectedRequest.getInt("userId")));

        //JSON

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(expectedRequest.getInt("statusCode"),response.getStatusCode());
        Assert.assertEquals(expectedRequest.getBoolean("completed"),jsonPath.getBoolean("completed"));
        Assert.assertEquals(expectedRequest.getString("title"),jsonPath.getString("title"));
        Assert.assertEquals(expectedRequest.getInt("userId"),jsonPath.getInt("userId"));

        //De-Serialization

        HashMap<String, Object> actualResponse = response.as(HashMap.class);

        Assert.assertEquals(expectedRequest.getInt("userId"),actualResponse.get("userId"));
        Assert.assertEquals(expectedRequest.getBoolean("completed"),actualResponse.get("completed"));
        Assert.assertEquals(expectedRequest.getString("title"),actualResponse.get("title"));


    }
}















































