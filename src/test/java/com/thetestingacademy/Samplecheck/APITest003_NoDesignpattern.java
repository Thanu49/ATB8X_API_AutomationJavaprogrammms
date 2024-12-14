package com.thetestingacademy.Samplecheck;

public class APITest003_NoDesignpattern {
    public void step1(){
    System.out.println("Step 1");
}

public void step2() {
    System.out.println("Step 2");
}

public void step3(String name) {
    System.out.println(name);
}
    public static void main(String[] args) {
        APITest003_NoDesignpattern np=new APITest003_NoDesignpattern();
        np.step1();
        np.step2();
        np.step3("pramod");

        //np.step1().step2().step3("pramod"); not possible

    }
}
