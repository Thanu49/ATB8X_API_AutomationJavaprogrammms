package com.thetestingacademy.TestNGExamples;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class APITesting017_TestNG_parameters {
    @Parameters("Browser")
    @Test
    void demo(String value){//we are getting value from xml.no need to create another class create another xml is enough
        System.out.println("Browser is "+value);
        //open the browser and select dadada

        if (value.equalsIgnoreCase("chrome")){
            System.out.println("start my Testing in chrome");
        }

        if (value.equalsIgnoreCase("firefox")){
            System.out.println("start my Testing in firefox");
        }
    }

}
