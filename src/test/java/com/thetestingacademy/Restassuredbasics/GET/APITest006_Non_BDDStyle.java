package com.thetestingacademy.Restassuredbasics.GET;

import io.qameta.allure.Description;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

public class APITest006_Non_BDDStyle {
    static RequestSpecification r = RestAssured.given();

    @Description("TC1 - NonBDDStyleGet - positive testcase")
    @Test
    public void test_Non_BDDStyleGet_Positive() {

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/560066");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);

    }

    @Description("TC2 - NonBDDStyleGet - negetive testcase")
    @Test
    public void test_Non_BDDStyleGet_negetive() {

        r.baseUri("https://api.zippopotam.us");
        r.basePath("/IN/-1");
        r.when().log().all().get();
        r.then().log().all().statusCode(200);

    }
}
