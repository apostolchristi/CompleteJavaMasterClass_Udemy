package com.timbuchalka;

public class Main {

    public static void main(String[] args) {

        ITelephone timsPhone;
        timsPhone = new DeskPhone(1234567);

        timsPhone.callPhone(123456);
        timsPhone.powerOn();
        timsPhone.answer();

        timsPhone = new MobilePhone(2456789);
//        timsPhone.powerOn();
        timsPhone.callPhone(256445);
        timsPhone.answer();
    }
}
