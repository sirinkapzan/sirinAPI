package com.sirin.ders04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest06 {
/*
   Given
       https://reqres.in/api/users/2
   When
       User send GET Request to the URL
   Then
       HTTP Status Code should be 200
   And
       Response format should be "application/json"
   And
       "email" is "janet.weaver@reqres.in",
   And
       "first_name" is "Janet"
   And
       "last_name" is "Weaver"
   And
       "text" is "To keep ReqRes free, contributions towards server costs are appreciated!"
*/
    //{
    //    "data": {
    //        "id": 2,
    //        "email": "janet.weaver@reqres.in",
    //        "first_name": "Janet",
    //        "last_name": "Weaver",
    //        "avatar": "https://reqres.in/img/faces/2-image.jpg"
    //    },
    //    "support": {
    //        "url": "https://reqres.in/#support-heading",
    //        "text": "To keep ReqRes free, contributions towards server costs are appreciated!"
    //    }
    //}

    @Test
    public void test01() {
        String url = "https://reqres.in/api/users/2";

        Response response = given().when().get(url);

        response.prettyPrint();

        response.then().statusCode(200).contentType(ContentType.JSON).
                body("data.first_name", equalTo("Janet"),
                        "data.last_name",equalTo("Weaver"),
                        "support.text",equalTo("To keep ReqRes free, contributions towards server costs are appreciated!"),
                        "data.id",equalTo(2),
                        "data.email",equalTo("janet.weaver@reqres.in"));
    }
}
