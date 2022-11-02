package com.sirin.ders05;

import com.sirin.testBase.Restful01TestBase;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.*;

public class GetRequest10 extends Restful01TestBase {

    @Test
    public void test01() {
        /*
    Given
        https://restful-booker.herokuapp.com/booking?firstname=Almedin&lastname=Alikadic
    When
        User sends get request to the URL
    Then
        Status code is 200
    And
        Among the data there should be someone whose firstname is "Almedin" and lastname is "Alikadic"
        */

        spec.pathParam("first","booking").queryParams("firstname","Almedin","lastname","Alikadic");

        Response response = given().spec(spec).when().get("/{first}");
        response.prettyPrint();

        assertTrue(response.asString().contains("hosted"));

    }
}
