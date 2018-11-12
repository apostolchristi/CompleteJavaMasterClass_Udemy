package com.timbuchalka;

import java.util.Scanner;

public class X {

    private int x;

    public X(Scanner x) {
        System.out.println("Please Enter the Number");
        this.x = x.nextInt();// Scanner will be initiated by constructor and this line of x.nextInt is asking me to insert an int number in console.
    }

  public void x() {
        for(int x = 1; x<13; x++) {
            System.out.println(x + " times " + this.x + " equals " + x * this.x);
        }
    }

    public void y() {
        for( int x=1; x<13; x++) {
            System.out.println(x + " times " + this.x + " equals " + x*this.x);
        }
    }
}
