package com.sirin.ders04;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;


public class GetRequest01 {

   /*
https://restful-booker.herokuapp.com/booking/3 adresine bir request gonderildiginde
donecek cevap(response) icin
HTTP status kodunun 200
Content Type’in Json
Ve Status Line’in HTTP/1.1 200 OK
Oldugunu test edin
   */

    @Test
    public void test01() {

        //1- api testi yaparken ilk olarak url(endpoint) belirlenmeli
        //2- beklenen sonuç(expected result) oluşturulur.
        //3-  request gönder
        //4-actual result oluştur
        //5-doğrulama yap(assertion)

        String url = "https://restful-booker.herokuapp.com/booking";
        Response response = given().accept(ContentType.JSON).when().get(url);
        response.
                then().
                assertThat().
                statusCode(200).
                contentType(ContentType.JSON).
                statusLine("HTTP/1.1 200 OK");

    }



}
