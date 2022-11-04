package com.sirin.ders06;

import com.sirin.testBase.ReqresTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest17 extends ReqresTestBase {
    /*
               Given
                      https://reqres.in/api/unknown/
               When
                    I send GET Request to the URL
               Then

                    1)Status code is 200
                    2)Print all "pantone_values"
                    3)Print all ids greater than 3 on the console
                      Assert that there are 3 ids greater than 3
                    4)Print all names whose ids are less than 3 on the console
                      Assert that the number of names whose ids are less than 3 is 2
    */

    @Test
    public void test01() {
        spec.pathParams("first","api",
                "second","unknown");
        Response response = given().accept(ContentType.JSON).spec(spec).
                when().get("{first}/{second}");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        List<Integer> idList = jsonPath.getList("data.findAll{it.id>3}.id");
        System.out.println(idList);

        Assert.assertEquals(3,idList.size());

        List<Integer> nameList = jsonPath.getList("data.findAll{it.id<3}.name");
        System.out.println(nameList);

        Assert.assertEquals(2,nameList.size());

        System.out.println(jsonPath.getList("data.pantone_value"));











    }
}
