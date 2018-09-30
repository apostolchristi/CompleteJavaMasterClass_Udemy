package com.timbuchalka;

public class Bed {

    private String model;
    private String color;
    private int amount;

    public Bed(){
        this("Anger B42", "Grey", 1);
        System.out.println("Empty Constructor Called");
    }

    public Bed(String model, String color, int amount) {
        this.model = model;
        this.color = color;
        this.amount = amount;
    }

    public void transformBed(boolean sleep){
        if (sleep) {
            System.out.println("transformBed called(): Transform it and go to sleep");
        } else {
            System.out.println("tranfromBed called(): Transform it and go to work");
        }

    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getAmount() {
        return amount;
    }
}
