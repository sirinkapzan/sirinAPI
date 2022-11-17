package com.sirin.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

import static io.restassured.RestAssured.given;

public class JsonPlaceHolderTestBase {

    protected RequestSpecification spec;

    @Before
    public void setUp() {
        spec = new RequestSpecBuilder().
                setBaseUri("https://jsonplaceholder.typicode.com").
                build();

    }

}
