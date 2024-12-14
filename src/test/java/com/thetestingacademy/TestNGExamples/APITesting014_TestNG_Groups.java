package com.thetestingacademy.TestNGExamples;

import org.testng.Assert;
import org.testng.annotations.Test;

public class APITesting014_TestNG_Groups {

    //we can add priority ,groupds everything
    @Test(groups = {"sanity","qa","preprod"})
    public void sanityRun(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }
    @Test(groups = {"Req","qa","preprod"})
    public void RegRun(){
        System.out.println("Reg");
        Assert.assertTrue(true);
    }
    @Test(groups = {"dev","stage"})
    public void SmokeRun(){
        System.out.println("Smoke");
        System.out.println("QA");
        Assert.assertTrue(true);
    }
    @Test(groups = {"sanity","qa","preprod"})
    public void sanityRun1(){
        System.out.println("Sanity");
        System.out.println("QA");
        Assert.assertTrue(true);
    }

    @Test(groups = {"Req","qa","preprod"})
    public void RegRun1(){
        System.out.println("Reg");
        Assert.assertTrue(true);
    }

    @Test(groups = {"dev","stage"})
    public void SmokeRun3(){
        System.out.println("Smoke");
        System.out.println("QA");
        Assert.assertTrue(true);
    }
}
