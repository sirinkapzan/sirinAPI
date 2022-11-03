package com.sirin.ders06;

import com.sirin.testBase.DummyTestBase;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest15 extends DummyTestBase {

     /*
        http://dummy.restapiexample.com/api/v1/employees
        url ine bir istek gönderildiğinde
        Dönen response un
        Status kodunun 200,
1)10’dan büyük tüm id’leri ekrana yazdırın ve
  10’dan büyük 14 id olduğunu,
2)30’dan küçük tüm yaşları ekrana yazdırın ve
  bu yaşların içerisinde en büyük yaşın 23 olduğunu
3)Maası 350000 den büyük olan tüm employee name’leri ekrana yazdırın ve
  bunların içerisinde “Charde Marshall” olduğunu test edin
     */

    @Test
    public void test01() {

        spec.pathParams("first", "v1",
                "second", "employees");

        Response response = given().accept(ContentType.JSON).spec(spec).
                when().get("{first}/{second}");
        response.prettyPrint();
        JsonPath jsonPath = response.jsonPath();


        List<Integer> idList= jsonPath.getList("data.findAll{it.id>10}.id");
        System.out.println(idList);

        Assert.assertEquals(14,idList.size());

        List<Integer> ageList = jsonPath.getList("data.findAll{it.employee_age<30}.employee_age");
        System.out.println(ageList);

        Collections.sort(ageList);

        Assert.assertEquals(23,(int)ageList.get(ageList.size()-1));

        List<String> salaryList = jsonPath.getList("data.findAll{it.employee_salary>350000}.employee_name");
        System.out.println(salaryList);

        Assert.assertTrue(salaryList.contains("Charde Marshall"));


    }
}




























