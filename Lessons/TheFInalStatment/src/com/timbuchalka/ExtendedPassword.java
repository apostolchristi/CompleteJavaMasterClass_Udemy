package com.timbuchalka;

public class ExtendedPassword extends Password {

    private int decryptedPassword;

    public ExtendedPassword(int password) {
        super(password);
        this.decryptedPassword = password; // Noting password and not the encrypted one
    }

//    @Override
//    public void storePassword() {
//        System.out.println("Saving password as " + this.decryptedPassword); //
//    }
}
