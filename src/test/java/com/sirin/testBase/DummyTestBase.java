package com.sirin.testBase;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyTestBase {
    protected RequestSpecification spec;
    @Before
    public void setUp(){
        spec = new RequestSpecBuilder().setBaseUri("http://dummy.restapiexample.com/api").build();
    }
}
