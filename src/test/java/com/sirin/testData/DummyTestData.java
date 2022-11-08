package com.sirin.testData;

import java.util.HashMap;

public class DummyTestData {

    public HashMap<String, String> setUpRequestBody() {

        HashMap<String, String> requestBody = new HashMap<>();
        requestBody.put("name", "SRN");
        requestBody.put("salary", "1000");
        requestBody.put("age", "18");

        return requestBody;

    }

    public HashMap<String, Object> setUpExpectedData() {

        HashMap<String, Object> data = new HashMap<>();

        data.put("name", "SRN");
        data.put("salary", "1000");
        data.put("age", "18");

        HashMap<String, Object> expectedData = new HashMap<>();

        expectedData.put("statusCode", 200);
        expectedData.put("status", "success");
        expectedData.put("data", data);
        expectedData.put("message", "Successfully! Record has been added.");

        return expectedData;
    }
}
