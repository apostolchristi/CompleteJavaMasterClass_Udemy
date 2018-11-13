package com.timbuchalka;

public class SomeClass {
    private static int classCounter = 0; // initializing it without constructor
    public final int instanceNumber;
    private final String name;

    public SomeClass(String name) {
        this.name = name;
        classCounter++;
        this.instanceNumber = classCounter;
        System.out.println(name + " created, instace is " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}
