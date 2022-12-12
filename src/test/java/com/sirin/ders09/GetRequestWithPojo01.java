package com.sirin.ders09;

import com.sirin.pojos.DataPojo;
import com.sirin.pojos.DummyPojo;
import com.sirin.testBase.DummyTestBase;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

@JsonIgnoreProperties
public class GetRequestWithPojo01 extends DummyTestBase {
        /*
GET Request to the URL http://dummy.restapiexample.com/api/v1/employee/1
                            Status code is 200
                                 {
                                  "status": "success",
                                  "data": {
                                      "id": 1,
                                      "employee_name": "Tiger Nixon",
                                      "employee_salary": 320800,
                                      "employee_age": 61,
                                      "profile_image": ""
                                  },
                                  "message": "Successfully! Record has been fetched."
                                 }

 */

    @Test
    public void test() {

        spec.pathParams("first", "v1", "second", "employee", "third", 1);

        DataPojo dataPojo = new DataPojo(1, "Tiger Nixon", 320800, 61, "");

        DummyPojo expectedData = new DummyPojo("success", dataPojo, "Successfully! Record has been fetched.");

        Response response = given().contentType(ContentType.JSON).spec(spec).when().get("/{first}/{second}/{third}");

        response.prettyPrint();

        DummyPojo actualData = response.as(DummyPojo.class);

        System.out.println(actualData);

        Assert.assertEquals(expectedData.getData().getemployee_age(),actualData.getData().getemployee_age());
        Assert.assertEquals(expectedData.getData().getemployee_name(),actualData.getData().getemployee_name());
        Assert.assertEquals(expectedData.getData().getemployee_salary(),actualData.getData().getemployee_salary());
        Assert.assertEquals(expectedData.getData().getId(),actualData.getData().getId());
        Assert.assertEquals(expectedData.getData().getprofile_image(),actualData.getData().getprofile_image());
        Assert.assertEquals(expectedData.getStatus(),actualData.getStatus());
        Assert.assertEquals(expectedData.getMessage(),actualData.getMessage());
        Assert.assertEquals(200,response.getStatusCode());



    }
}
