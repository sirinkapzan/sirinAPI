package com.sirin.ders05;

import com.sirin.testBase.JsonPlaceHolderTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.hamcrest.Matcher;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class GetRequest14 extends JsonPlaceHolderTestBase {
        /*
https://jsonplaceholder.typicode.com/todos/2 url ‘ine istek gönderildiğinde,
 Dönen response un
 Status kodunun 200, dönen body de,
 "completed": değerinin false
"title”: değerinin “quis ut nam facilis et officia qui”
"userId" sinin 1 ve
header değerlerinden
 "Via" değerinin “1.1 vegur” ve
 "Server" değerinin “cloudflare” olduğunu test edin…

    url oluştur
    --expected data
    request gönder
   -- actual data
    assertion

     */

    @Test
    public void test01() {

        spec.pathParams("first", "todos",
                "second", 2);

        Response response = given().accept(ContentType.JSON).spec(spec).
                when().get("{first}/{second}");

        HashMap<String, Object> expectedData = new HashMap<>();

        expectedData.put("statusCode", 200);
        expectedData.put("via", "1.1 vegur");
        expectedData.put("Server", "cloudflare");
        expectedData.put("title", "quis ut nam facilis et officia qui");
        expectedData.put("completed", false);
        expectedData.put("UserId", 1);
        System.out.println(expectedData);
        System.out.println("************");
        response.prettyPrint();

        //1. Yontem

        response.then().assertThat().
                statusCode((Integer) expectedData.get("statusCode")).
                headers("via", equalTo(expectedData.get("via")),
                        "Server", equalTo(expectedData.get("Server"))).
                body("title", equalTo(expectedData.get("title")));

        //2. Yontem
        JsonPath jsonPath = response.jsonPath();
        assertEquals(expectedData.get("statusCode"),response.getStatusCode());
        assertEquals(expectedData.get("userId"),jsonPath.getString("UserId"));
        assertEquals(expectedData.get("title"),jsonPath.getString("title"));
        assertEquals(expectedData.get("via"),response.getHeader("via"));
        assertEquals(expectedData.get("Server"),response.getHeader("Server"));


    }
}































