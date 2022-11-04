package com.sirin.ders05;

import com.sirin.testBase.JsonPlaceHolderTestBase;
import com.sirin.testData.JsonPlaceHolderTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;

public class GetRequest14TestData extends JsonPlaceHolderTestBase {

    @Test
    public void test01() {

        spec.pathParams("first", "todos",
                "second", 2);

        JsonPlaceHolderTestData expectedObje = new JsonPlaceHolderTestData();
        HashMap<String, Object> expectedData = expectedObje.setUpTestData();
        System.out.println(expectedData);

        Response response = given().accept(ContentType.JSON).spec(spec).
                when().get("{first}/{second}");
        response.prettyPrint();


        //1. Yontem

        response.then().assertThat().
                statusCode((Integer) expectedData.get("statusCode")).
                headers("via", equalTo(expectedData.get("via")),
                        "Server", equalTo(expectedData.get("Server"))).
                body("title", equalTo(expectedData.get("title")));

        //2. Yontem
        JsonPath jsonPath = response.jsonPath();
        assertEquals(expectedData.get("statusCode"), response.getStatusCode());
        assertEquals(expectedData.get("userId"), jsonPath.getString("UserId"));
        assertEquals(expectedData.get("title"), jsonPath.getString("title"));
        assertEquals(expectedData.get("via"), response.getHeader("via"));
        assertEquals(expectedData.get("Server"), response.getHeader("Server"));

        // 3. Yontem

        HashMap<String, Object> actualData = response.as(HashMap.class);

        assertEquals(expectedData.get("userId"),actualData.get("userId"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("title"),actualData.get("title"));
        assertEquals(expectedData.get("completed"),actualData.get("completed"));



    }
}






















