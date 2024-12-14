package com.thetestingacademy.Integration;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

public class APITesting011_Testcaseintegration {
    //create token
    //create  a booking
    //perform a put request
    //verify that put is success by get request
    //delete the ID
    //verify it doesn't exist get request

    RequestSpecification request;
    Response response;
    ValidatableResponse validate_response;

    String token;
    String booking_id;

    public String get_token(){
        String payload="{\n" +
                "    \"username\" : \"admin\",\n" +
                "    \"password\" : \"password123\"\n" +
                "}";

        request= RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com");
        request.basePath("/auth");
        request.contentType(ContentType.JSON);
        request.body(payload);

        response=request.when().post();

        validate_response=response.then().log().all();
        validate_response.statusCode(200);

        token=response.jsonPath().getString("token");
        System.out.println(token);

        assertThat(token).isNotEmpty().isNotNull();
        return token;

    }

    public String get_booking_id(){

        String payload = " {\n" +
                "        \"firstname\": \"Jim\",\n" +
                "        \"lastname\": \"Brown\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }";
        request.baseUri("https://restful-booker.herokuapp.com/");
        request.basePath("booking/");
        request.contentType(ContentType.JSON);
        request.body(payload);

        response=request.when().post();

        validate_response=response.then().log().all();
        validate_response.statusCode(200);

        booking_id = response.jsonPath().getString("bookingid");
        System.out.println(booking_id);
        return booking_id;
    }

    @Test(priority = 1)
    public  void test_update_PUT(){
        String token=get_token();
        String booking_id=get_booking_id();
        System.out.println(token);
        System.out.println(booking_id);

        String payloadPUT = " {\n" +
                "        \"firstname\": \"Thanu\",\n" +
                "        \"lastname\": \"Brown\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }";
        request.baseUri("https://restful-booker.herokuapp.com/");
        request.basePath("booking/"+booking_id);
        request.contentType(ContentType.JSON);
        request.cookie("token",token);
        request.body(payloadPUT);

        response=request.when().put();

        validate_response=response.then().log().all();
        validate_response.statusCode(200);

    }

    @Test(priority = 2,dependsOnMethods = "test_update_PUT")
    public void test_update_request_get(){
        request =RestAssured.given();

        request.baseUri("https://restful-booker.herokuapp.com/");
        request.basePath("booking/"+booking_id);
        response=request.get();
        response.then().log().all().statusCode(200);

        String firstname=response.jsonPath().getString("firstname");
        //System.out.println(first_name);
        //To check both are equal or not
        Assert.assertEquals(firstname,"Thanu");

    }

    @Test(priority = 3)
    public void test_delete_booking(){
        String token =get_token();
        request=RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com/");
        request.basePath("booking/"+booking_id);
        request.contentType(ContentType.JSON);
        request.cookie("token",token);

        response=request.when().delete();

        validate_response=response.then().log().all();
        validate_response.statusCode(201); // #TODO #1 -Delete BUG

    }

    @Test
    public void test_after_delete_request_get(){
        System.out.println(booking_id);
        request=RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com/");
        request.basePath("booking/"+booking_id);
        response=request.get();
        response.then().log().all().statusCode(404);

    }


}
