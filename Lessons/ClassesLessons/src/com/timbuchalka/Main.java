package com.timbuchalka;

public class Main {

    public static void main(String[] args) {

        Car porche = new Car(); // by this we initializing Car (new) class and we are doing an instance of Car by new Car
        Car holden = new Car();
        porche.setModel("Carrera");
        System.out.println("Model is "+porche.getModel());
    }
}
