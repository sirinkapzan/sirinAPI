package com.sirin.ders10;

import com.sirin.testBase.RestfulTestBase;
import com.sirin.utilities.JsonUtil;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequestWithObjectMapper02 extends RestfulTestBase {

        /*
    GetRequestWithObjectMapper02:
https://restful-booker.herokuapp.com/booking/2 url’ine bir get request gönderildiğinde,
 status kodun 200 ve response body’nin
{
"firstname": "Susan",
"lastname": "Smith",
"totalprice": 401,
"depositpaid": true,
"bookingdates":
                  {
                      "checkin": "2015-12-16",
                      "checkout": "2017-03-17"
                  },

"additionalneeds": "Breakfast"
}

Olduğunu Object Mapper kullanarak test edin

{
"firstname":"Eric",
"lastname":"Jones",
"totalprice":580,
"depositpaid":true,
"bookingdates":
               {
                  "checkin":"2016-05-25",
                  "checkout":"2020-04-03"
                },
"additionalneeds":"Breakfast"
}
     */

    @Test
    public void test() {

        spec.pathParams("firstParam", "booking", "secondParam", 1);

        String jsonExpectedBody = "{\n" +
                "    \"firstname\": \"Jim\",\n" +
                "    \"lastname\": \"Wilson\",\n" +
                "    \"totalprice\": 552,\n" +
                "    \"depositpaid\": true,\n" +
                "    \"bookingdates\": {\n" +
                "        \"checkin\": \"2019-08-26\",\n" +
                "        \"checkout\": \"2020-04-16\"\n" +
                "    },\n" +
                "    \"additionalneeds\": \"Breakfast\"\n" +
                "}";

        Map<String, Object> expectedData = JsonUtil.convertJsonToJava(jsonExpectedBody, Map.class);

        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("/{firstParam}/{secondParam}");
        response.prettyPrint();


        Map<String, Object> actualData = JsonUtil.convertJsonToJava(response.asString(), Map.class);

        System.out.println(expectedData);
        System.out.println(actualData);

        Assert.assertEquals(expectedData.get("firstname"),actualData.get("firstname"));
        Assert.assertEquals(expectedData.get("lastname"),actualData.get("lastname"));
        Assert.assertEquals(expectedData.get("totalprice"),actualData.get("totalprice"));
        Assert.assertEquals(expectedData.get("depositpaid"),actualData.get("depositpaid"));
        Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkin"),((Map)actualData.get("bookingdates")).get("checkin"));
        Assert.assertEquals(((Map)expectedData.get("bookingdates")).get("checkout"),((Map)actualData.get("bookingdates")).get("checkout"));


    }

}
