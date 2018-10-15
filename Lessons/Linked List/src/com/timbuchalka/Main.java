package com.timbuchalka;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Custumer custumer = new Custumer("Tim", 54.96);
        Custumer anotherCustumer;
        anotherCustumer = custumer;
        anotherCustumer.setBalance(12.18);
        System.out.println("Balance for Custumer " +custumer.getName() + " is " + custumer.getBalance());


        ArrayList<Integer> intList = new ArrayList<Integer>();
        intList.add(1);
        intList.add(3);
        intList.add(4);

        for (int i=0; i<intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));
        }

        intList.add(1, 2); // on index 1 asign number 2
        for (int i=0; i<intList.size(); i++) {
            System.out.println(i + ": " + intList.get(i));

        }
    }
}
