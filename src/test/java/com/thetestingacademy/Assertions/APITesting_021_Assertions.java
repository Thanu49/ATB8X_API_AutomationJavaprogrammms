package com.thetestingacademy.Assertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class APITesting_021_Assertions {


    //Assertins means->expected result==Actual result

    //3 types of assertion
    //1-TestNG Assertions
    @Test
    public void test_hardassertExample(){
        System.out.println("start of the program");
        Assert.assertTrue(false);
        System.out.println("end of the program");
    }

    @Test
    public void test_soft_assertExample(){
        SoftAssert softAssert=new SoftAssert();
        System.out.println("start of the program");
        softAssert.assertTrue(false);     //if it fails also next line will be executes
        System.out.println("Iwill be executed");
    }
    //2-validating response
    //3-AsserJ(3rd party)
}
