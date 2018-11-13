package com.timbuchalka;

public class Password {

    private static final int key = 748576362; // declaring a static final variable
    private final int encryptedPassword;

    public Password(int password) {
        this.encryptedPassword = encryptDecrypt(password); // when class will be initialized the constructor will ask for this method
    }

    private int encryptDecrypt(int password) {
        return password ^ key; // using an "^" XOR
    }

    //Storing password
    public final void storePassword() {
        System.out.println("Saving password as " + this.encryptedPassword);
    }

    //Validation
    public boolean letMeIn(int password) {
        if(encryptDecrypt(password) == this.encryptedPassword) {
            System.out.println("Welcome");
            return true;
        } else {
            System.out.println("You cannot come in");
            return false;
        }
    }
}
