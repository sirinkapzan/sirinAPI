package com.sirin.ders07;

import com.sirin.testBase.DummyTestBase;
import com.sirin.testData.DummyTestData;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

import static io.restassured.RestAssured.*;

public class PostRequest01 extends DummyTestBase {
    /*
    http://dummy.restapiexample.com/api/v1/create url ine, Request Body olarak
{
 "name":"SRN",
 "salary":"1000",
 "age":"18",
  }
gönderildiğinde,Status kodun 200 olduğunu ve dönen response body nin ,
{
    "status": "success",
    "data": {
        "name": "SRN",
        "salary": "1000",
        "age": "18",
        "id": 9218
    },
    "message": "Successfully! Record has been added."
}

olduğunu test edin
    */

    @Test
    public void test01() {

        spec.pathParams("first", "v1", "second", "create");

        DummyTestData dummyObje = new DummyTestData();

        HashMap<String, String> requestBody = dummyObje.setUpRequestBody();

        HashMap<String, Object> expectedData = dummyObje.setUpExpectedData();



        Response response = given().
                spec(spec).
                auth().basic("admin","password123").
                body(requestBody).
                accept(ContentType.JSON).
                when().post("/{first}/{second}");

        response.prettyPrint();


        //De-Serialization
        HashMap<String, Object> actualData =response.as(HashMap.class);

        Assert.assertEquals(expectedData.get("statusCode"),response.statusCode());
        Assert.assertEquals(expectedData.get("status"),actualData.get("status"));
        Assert.assertEquals(expectedData.get("message"),actualData.get("message"));

        //JsonPath

        JsonPath jsonPath = response.jsonPath();

        Assert.assertEquals(expectedData.get("status"),jsonPath.getString("status"));
        Assert.assertEquals(expectedData.get("message"),jsonPath.getString("message"));







    }
}
























