package com.timbuchalka;

import java.util.ArrayList;

public class Account {

    private String name;
    private int balance = 0;
    private ArrayList<Integer> transactions;

    public Account(String name) {
        this.name = name;
        this.transactions = new ArrayList<Integer>();
    }

    public int getBalance() {
        return balance;
    }

    public void deposit(int amount) {
        if( amount > 0 ) {
            transactions.add(amount);
            this.balance += amount;
            System.out.println(amount + " deposited. Balance now is " + this.balance);
        } else {
            System.out.println("You can't deposit negative sums");
        }
    }

    public void withdrow(int amount) {
        int withrdowal = -amount;
        if(withrdowal < 0) { //check if is less than 0 which means we can withdraw
            transactions.add(withrdowal); //add to transactions this withdrown
            this.balance += withrdowal;//updating balance
            System.out.println(amount + " withdrwan. Balance now is " + this.balance);
        } else {
            System.out.println("Cannot withdraw negative sums");

        }
    }

    public void calculateBalance() {
        this.balance = 0;
        for(int i : this.transactions) {
            this.balance += i;
        }
        System.out.println("Calculated balance is " + this.balance);
    }
}
