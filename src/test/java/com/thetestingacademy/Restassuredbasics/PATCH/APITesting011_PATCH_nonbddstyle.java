package com.thetestingacademy.Restassuredbasics.PATCH;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting011_PATCH_nonbddstyle {

    @Description
    @Test
    public void test_patch_request(){
        String token ="c2c3116abe95860";
        String bookingid ="2516";
        String payload="{\n" +
                "        \"firstname\": \"Jim\",\n" +
                "        \"lastname\": \"Brown\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }"  ;

        RequestSpecification request = RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com/");
        request.basePath("booking/"+bookingid);
        request.contentType(ContentType.JSON);
        request.cookie("token",token);
        //request.auth().preemptive().basic("admin","password123");
        request.body(payload).log().all();

        Response response =request.when().patch();

        ValidatableResponse validation=response.then().log().all();
        validation.statusCode(200);

    }

}
