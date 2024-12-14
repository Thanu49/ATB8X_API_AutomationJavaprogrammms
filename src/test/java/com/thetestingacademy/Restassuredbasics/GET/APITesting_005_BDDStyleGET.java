package com.thetestingacademy.Restassuredbasics.GET;

import io.restassured.RestAssured;
import org.testng.annotations.Test;

public class APITesting_005_BDDStyleGET {
    //Get request https://api.zippopotam.us/IN/560066

    @Test
    public void Test_Get_Res_Positive(){
        String pin_code ="560066";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pin_code)
                .when().log().all().get()
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void Test_Get_Res_Negative(){
        String pin_code ="-1";
        RestAssured
                .given()
                .baseUri("https://api.zippopotam.us")
                .basePath("/IN/"+pin_code)
                .when().log().all().get()
                .then()
                .log().all()
                .statusCode(200);
    }
}
