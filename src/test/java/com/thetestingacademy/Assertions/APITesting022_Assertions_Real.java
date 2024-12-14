package com.thetestingacademy.Assertions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;


public class APITesting022_Assertions_Real {

    //POST -Create ->verify the response
    @Test
    public void test_post() {
        String payload_post = "{\n" +
                "        \"firstname\": \"thanu\",\n" +
                "        \"lastname\": \"shree\",\n" +
                "        \"totalprice\": 111,\n" +
                "        \"depositpaid\": true,\n" +
                "        \"bookingdates\": {\n" +
                "            \"checkin\": \"2018-01-01\",\n" +
                "            \"checkout\": \"2019-01-01\"\n" +
                "        },\n" +
                "        \"additionalneeds\": \"Breakfast\"\n" +
                "    }";

        RequestSpecification request = RestAssured.given();


        request.baseUri("https://restful-booker.herokuapp.com/");
        request.basePath("booking");
        request.contentType(ContentType.JSON);
        request.body(payload_post).log().all();

        Response response =request.when().post();

        ValidatableResponse validation=response.then().log().all();
        validation.statusCode(200);

        //validatable Response - Interface -Hamcrest - RestAssured

        //RestAssured Default -hamcrest
        //import org.hamcrest.Matchers;

        validation.body("booking.firstname",Matchers.equalTo("thanu"));
        validation.body("booking.lastname",Matchers.equalTo("shree"));
        validation.body("bookingid",Matchers.notNullValue());

        //TestNG Assertions
        //softassert vs HardAssert-this means that if any assertion fails,
        //the remaining statements in the test method will not executed

        Integer bookingID=response.then().extract().path("bookingid");
        String firstname=response.then().extract().path("booking.firstname");
        String lastname=response.then().extract().path("booking.lastname");
        Assert.assertNotNull(bookingID);
        Assert.assertEquals(firstname,"thanu");
        Assert.assertEquals(lastname,"shree");

        //AssertJ(3rd libreary tool assertion)

        assertThat(bookingID).isNotNull().isPositive().isNotZero();
        assertThat(firstname).isEqualTo("thanu").isNotNull().isNotBlank().isNotEmpty();





    }
}
