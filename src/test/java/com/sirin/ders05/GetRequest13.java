package com.sirin.ders05;

import com.sirin.testBase.DummyTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static io.restassured.RestAssured.*;

public class GetRequest13 extends DummyTestBase {
     /*
    http://dummy.restapiexample.com/api/v1/employees
url ine bir istek gönderildiğinde,
status kodun 200,
gelen body de,
5. çalışanın isminin "Airi Satou" olduğunu ,
6. çalışanın maaşının "372000" olduğunu ,
Toplam 24 tane çalışan olduğunu,
"Rhona Davidson" ın employee lerden biri olduğunu
"21", "23", "61" yaşlarında employeeler olduğunu test edin
     */

    @Test
    public void test01() {
        spec.pathParams("first","v1","second","employees");

        Response response = given().accept(ContentType.JSON).spec(spec).when().get("/{first}/{second}");

        response.prettyPrint();

        JsonPath jsonPath = response.jsonPath();

        assertEquals(200,response.getStatusCode());
        assertEquals("Airi Satou",jsonPath.getString("data.employee_name[4]"));
        assertEquals(372000,jsonPath.getInt("data.employee_salary[5]"));
        assertEquals(24,jsonPath.getList("data.id").size());
        assertTrue(jsonPath.getString("data").contains("Rhona Davidson"));

        List<Integer> ages = Arrays.asList(21,23,61);

        assertTrue(jsonPath.getList("data.employee_age").containsAll(ages));

    }
}















