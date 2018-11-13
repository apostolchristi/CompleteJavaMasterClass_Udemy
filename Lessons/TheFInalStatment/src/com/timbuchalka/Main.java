package com.timbuchalka;

public class Main {

    public static void main(String[] args) {
	// write your code here
        SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass thre = new SomeClass("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(thre.getInstanceNumber());

        System.out.println(Math.PI);

        int pw = 674312;
        Password password = new ExtendedPassword(pw);
        password.storePassword();

        password.letMeIn(1);
        password.letMeIn(54232131);
        password.letMeIn(2323);
        password.letMeIn(11);
        password.letMeIn(-1);
        password.letMeIn(674312);

        System.out.println("Main method called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is " + SIBTest.owner);
    }
}
