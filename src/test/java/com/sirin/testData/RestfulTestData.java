package com.sirin.testData;

import java.util.HashMap;

public class RestfulTestData {
    //                     {
    //                         "firstname": "Sally",
    //                         "lastname": "Jackson",
    //                         "totalprice": 876,
    //                         "depositpaid": false,
    //                         "bookingdates": {
    //                             "checkin": "2016-06-04",
    //                             "checkout": "2017-10-07"
    //                         }
    //                     }
    public HashMap<String, Object> setUpTestAndRequestBase() {
        HashMap<String, Object> bookingdates = new HashMap<>();
        bookingdates.put("checkin", "2016-06-04");
        bookingdates.put("checkout", "2017-10-07");
        HashMap<String, Object> expectedData = new HashMap<>();
        expectedData.put("firstname", "Sally");
        expectedData.put("lastname", "Jackson");
        expectedData.put("totalprice", 876);
        expectedData.put("depositpaid", false);
        expectedData.put("bookingdates", bookingdates);
        return expectedData;
    }
}
