package com.timbuchalka;

public class BankAccount {
    // Create a new class for a bank account
    // Create fields for the account number, balance, customer name, email and phone number.
    //
    // Create getters and setters for each field
    // Create two additional methods
    // 1. To allow the customer to deposit funds (this should increment the balance field).
    // 2. To allow the customer to withdraw funds. This should deduct from the balance field,
    // but not allow the withdrawal to complete if their are insufficient funds.
    // You will want to create various code in the Main class (the one created by IntelliJ) to
    // confirm your code is working.
    // Add some System.out.println's in the two methods above as well.

    private String number;
    private double balance;
    private String custumerName;
    private String email;
    private String phoneNumber;

    public BankAccount (){ //this how looks default constructor. It doesn't have parameters
        //'this' is calling onother constrcutor within a constructor.
        //By this we say: if you trying to create an object from this class and u dont get me any parameters, these are the parameters
        //that i'm gona to use when creating this object
        this("57687", 2.50, "Default name", "Default Addres", "Default Phone");
        System.out.println("We initialized default constructor");
    }

    public BankAccount (String number, double balance, String custumerName, String email, String phoneNumber){ // overloaded constructor with different parameters
        System.out.println("Account constructor with parameters called");
        //setting the fields values in the constructor
        this.number = number;
        this.balance = balance;
        this.custumerName = custumerName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public BankAccount (String custumerName, String email, String phoneNumber){
        this("9999999", 100.55, custumerName, email, phoneNumber);

    }



    public void deposit (double depositAmount){
        this.balance += depositAmount;
        System.out.println("Deposit of " + depositAmount + "$ made. New balance is "+ this.balance);
    }

    public void withdraw(double withdrawAmount){
        if(this.balance - withdrawAmount < 0){
            System.out.println("Your balance is "+this.balance + "$. Imposible to withdraw");
        } else{
            this.balance -= withdrawAmount;
            System.out.println("withdrowl of "+withdrawAmount+" processed. Remaining balance = "+this.balance);
        }
    }



    //setters
    public void setNumber(String number){
        this.number = number;
    }

    public void setBalance(double balance){
        this.balance = balance;

    }

    public void setCustumerName(String custumerName){
        this.custumerName = custumerName;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }


    //getters
    public String getNumber(){
        return this.number;
    }

    public double getBalance(){
        return this.balance;
    }

    public String getCustumerName(){
        return this.custumerName;
    }

    public String getEmail(){
        return this.email;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }
}
