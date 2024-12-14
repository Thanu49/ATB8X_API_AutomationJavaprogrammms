package com.thetestingacademy.TestNGExamples;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class APITesting012_TestNG {
    @BeforeTest
    public void getToken(){
        System.out.println("token");
    }
    @BeforeTest
    public void getbookingid(){
        System.out.println("bookinid");
    }
    @Test
    public void test_PUT(){
        System.out.println("put");
    }

    @AfterTest
    public void closeallthetest(){
        System.out.println("close");
    }
}

//flow
//Beforetest->beforeclass->beforemethod->test->Aftertest->afterclass->aftermethod->aftersuite
