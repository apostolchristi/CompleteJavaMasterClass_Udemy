package com.timbuchalka;

public class SIBTest {

    public static final String owner;

    //SIBTest static initialization block called
    static {
        owner = "tim";
        System.out.println("SIBTest static initialization block called");
    }

    //SIB constructor called
    public SIBTest() {
        System.out.println("SIB constructor called");
    }

    static {
        System.out.println("2nd initialization block called");
    }

    public void someMethod() {
        System.out.println("someMethod called");
    }
}
