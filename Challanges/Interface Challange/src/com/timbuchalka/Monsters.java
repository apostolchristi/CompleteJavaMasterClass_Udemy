package com.timbuchalka;
// Create a simple interface that allows an object to be saved to some sort of storage medium.
// The exact type of medium is not known to the interface (nor to the classes that implement it).
// The interface will just specify 2 methods, one to return an ArrayList of values to be saved
// and the other to populate the object's fields from an ArrayList.
//
// Create some sample classes that implement your saveable interface (we've used the idea of a game,
// with Players and Monsters, but you can create any type of classes that you want).
//
// Override the toString() method for each of your classes so that they can be easily printed to enable
// the program to be tested easier.
//
// In Main, write a method that takes an object that implements the interface as a parameter and
// "saves" the values.
// We haven't covered I/O yet, so your method should just print the values to the screen.
// Also in Main, write a method that restores the values to a saveable object.
// Again, we are not going to use Java file I/O; instead use the readValues() method below to
// simulate getting values from a file – this allows you to type as many values as your class
// requires, and returns an ArrayList.

import java.util.ArrayList;
import java.util.List;

public class Monsters implements ISaveable {

    private String name;
    private int hitPoints;
    private int strength;

    public Monsters(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
    }

    public String getName() {
        return name;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    @Override
    public String toString() {
        return "Monsters{" +
                "name='" + name + '\'' +
                ", hitPoints=" + hitPoints +
                ", strength=" + strength +
                '}';
    }



    @Override
    public List<String> write() {
        ArrayList<String> values = new ArrayList<String>();
        values.add(0,this.name);
        values.add(1,"" + this.hitPoints);
        values.add (2, "" + this.strength);
        return values;
    }

    @Override
    public void read(List<String> savedValues) {
    if(savedValues != null && savedValues.size() > 0) {
        this.name = savedValues.get(0);
        this.hitPoints = Integer.parseInt(savedValues.get(1));
        this.strength = Integer.parseInt(savedValues.get(2));

    }
}
}
