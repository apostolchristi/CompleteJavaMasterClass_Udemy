package com.timbuchalka;

public class Car {

    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String colour;

    public void setModel(String model) { //alowing the method to update the "String model"
        this.model = model; // by "this.model we update "private String model" with parameter "model" from  setModel method, using a method, instead of using it directly
    }

    public String getModel(){
        return this.model; //we've got a method that can be called else where to return what the current model is.
    }
}
