package com.thetestingacademy.Payloadmanagement;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class APITesting_016_payloadmap {
    RequestSpecification request;
    ValidatableResponse validate_response;

    @Test
    public void testPOSTReq(){

//        "{\n" +
//                "        \"firstname\": \"Jim\",\n" +
//                "        \"lastname\": \"Brown\",\n" +
//                "        \"totalprice\": 111,\n" +
//                "        \"depositpaid\": true,\n" +
//                "        \"bookingdates\": {\n" +
//                "            \"checkin\": \"2018-01-01\",\n" +
//                "            \"checkout\": \"2019-01-01\"\n" +
//                "        },\n" +
//                "        \"additionalneeds\": \"Breakfast\"\n" +
//                "    }"  ;
//

            //convert JSON -->HashMap
        Map<String,Object> jsonbodyusingmap =new LinkedHashMap();
        jsonbodyusingmap.put("firstname","Jim");
        jsonbodyusingmap.put("lastname","Brown");
        jsonbodyusingmap.put("totalprice",111);
        jsonbodyusingmap.put("depositpaid",true);

        Map<String ,Object> bookingdatesmap=new LinkedHashMap();
        bookingdatesmap.put("checkin","2018-01-01");
        bookingdatesmap.put("checkout","2019-01-01");

        jsonbodyusingmap.put("bookingdates",bookingdatesmap);
        jsonbodyusingmap.put("additionalneeds","Breakfast");

        System.out.println(jsonbodyusingmap);
        request= RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com/");
        request.basePath("booking");
        request.contentType(ContentType.JSON);
        request.body(jsonbodyusingmap).log().all();

        Response response =request.when().post();

        //Integer booking_id = response.jsonPath().getString("bookingid");

        Integer booking_id = response.then().extract().path("bookingid");
        System.out.println(booking_id);


        validate_response=response.then().log().all();
        validate_response.statusCode(200);


    }

        //Map -->JSON you can convert using 3rd party library called GSon/Jacson






    }

