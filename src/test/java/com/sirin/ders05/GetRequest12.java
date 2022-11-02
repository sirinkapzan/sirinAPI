package com.sirin.ders05;

import com.sirin.testBase.DummyTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest12 extends DummyTestBase {
    /*
    http://dummy.restapiexample.com/api/v1/employees url’inde bulunan
   1) Butun calisanlarin isimlerini consola yazdıralim
   2) 3. calisan kisinin ismini konsola yazdıralim
   3) Ilk 5 calisanin adini konsola yazdiralim
   4) En son calisanin adini konsola yazdiralim
    */

    @Test
    public void test01() {
        spec.pathParams("first","v1",
                "second","employees");

        Response response = given().spec(spec).accept(ContentType.JSON).when().get("/{first}/{second}");

        JsonPath jsonPath = response.jsonPath();

        //response.prettyPrint();

        System.out.println(jsonPath.getList("data.employee_name"));
        //System.out.println(jsonPath.getString("data.employee_name"));
        System.out.println(jsonPath.getString("data[2].employee_name"));
        System.out.println(jsonPath.getList("data[0,1,2,3,4].employee_name"));//ilk bes
        System.out.println(jsonPath.getString("data[-1].employee_name"));



    }
}




























