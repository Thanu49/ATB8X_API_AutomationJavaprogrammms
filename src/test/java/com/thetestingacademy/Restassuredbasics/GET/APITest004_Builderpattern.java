package com.thetestingacademy.Restassuredbasics.GET;

public class APITest004_Builderpattern {
    //Change return type of each method as class type(name)
    //"this always points to current/calling object. Returning the same to have same reference
    public APITest004_Builderpattern step1(){
        System.out.println("step 1 is started");
        System.out.println("step 1 is done");
        return this;
    }
    public APITest004_Builderpattern step2(){
        System.out.println("step 2 is started");
        System.out.println("step 2 is done");
        return this;
    }
    public APITest004_Builderpattern step3(String name){
        System.out.println("step 3 is started");
        System.out.println("step 3 is done" + name);
        return this;

    }
    public static void main(String[] args){
        APITest004_Builderpattern bp=new APITest004_Builderpattern();
        bp.step1().step2().step3("pramod");

    }

}
