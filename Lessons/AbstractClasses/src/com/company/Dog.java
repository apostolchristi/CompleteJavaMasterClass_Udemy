package com.company;


public class Dog extends Animal {

    public Dog(String name) {
        super(name); // cals the constructor that's actually in the animal class as well

    }

    @Override
    public void eat() {
        System.out.println(getName()+ " is eating");

    }

    @Override
    public void breathe() {
        System.out.println("Breathe in, breathe out, repeat");

    }
}
