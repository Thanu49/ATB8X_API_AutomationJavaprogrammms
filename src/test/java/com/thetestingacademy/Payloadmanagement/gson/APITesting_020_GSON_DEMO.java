package com.thetestingacademy.Payloadmanagement.gson;

import com.google.gson.Gson;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static org.assertj.core.api.Assertions.*;



public class APITesting_020_GSON_DEMO {
    RequestSpecification request;
    ValidatableResponse validate_response;

    @Test
    public void testpositive(){

        //step1 -POST
        //URL ->Base URI + base path
        //Header
        //Body
        //AUTH -NO

        //Step 2
        //prepare the payload (Object -->json string)
        //send the request

        //Step 3
        //validate response(JSON string ->object)
        //firstname
        //statuscode
        //time response

        Booking booking=new Booking();
        booking.setFirstname("pramod");
        booking.setLastname("Dutta");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingDates=new Bookingdates();
        bookingDates.setCheckin("2024-02-01");
        bookingDates.setCheckout("2024-03-01");
        booking.setBookingdates(bookingDates);
        booking.setAdditionalneeds("breakfast");

        System.out.println(booking);
        //converting object ->string  serialisation
        Gson gson =new Gson();
        String jsonstringbooking =gson.toJson(booking);
        System.out.println(jsonstringbooking);

        request= RestAssured.given();
        request.baseUri("https://restful-booker.herokuapp.com/");
        request.basePath("booking");
        request.contentType(ContentType.JSON);
        request.body(jsonstringbooking).log().all();

        Response response =request.when().post();

        String jsonResponsestring=response.asString();

        validate_response=response.then().log().all();
        validate_response.statusCode(200);


        //extract(),jsonpath().getstring() ->response is small
        //response ->complex json -Huge json

        //String  - object de serialisation

        //To do serialisation another classs you need to create response class

        BookingResponse bookingResponse=gson.fromJson(jsonResponsestring,BookingResponse.class);
        assertThat(bookingResponse.getBooking()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("pramod");






    }

}
