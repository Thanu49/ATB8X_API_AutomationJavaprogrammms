package com.thetestingacademy.Payloadmanagement.difficultway;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITesting_018_payload_POJO_difficult {
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

        //POJO -> JSON

        Booking booking=new Booking();
        booking.setFirstname("pramod");
        booking.setLastname("Dutta");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        BookingDates bookingDates=new BookingDates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-03-01");
        booking.setBookingDates(bookingDates);
        booking.setAdditionalneeds("breakfast");



        request = RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com/");
        request.basePath("booking");
        request.contentType(ContentType.JSON);
        request.body(booking).log().all();

        Response response =request.when().post();

        //Integer booking_id = response.jsonPath().getString("bookingid");

        Integer booking_id = response.then().extract().path("bookingid");
        System.out.println(booking_id);


        validate_response=response.then().log().all();
        validate_response.statusCode(200);


    }
}
