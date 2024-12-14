package com.thetestingacademy.TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting020_TestNG_Invocationcount {
    @Test
    public void test01(){
        Assert.assertTrue(true);
    }

    @Test(invocationCount = 3)//it will skip
    public void test02(){
        Assert.assertTrue(true);
    }

    @Test
    public void test03(){
        Assert.assertTrue(true);
    }
}
