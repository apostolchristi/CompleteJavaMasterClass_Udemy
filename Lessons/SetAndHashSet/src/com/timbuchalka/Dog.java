package com.timbuchalka;

public class Dog {
    private final String name;

    public Dog(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public final boolean equals(Object obj) {
        if(this == obj) { //testing if this object is being compaerd with himself, and if that is the case and this is the same obj in memory
            //it will return true using a == so if that's the case we will
            return true;
        }
        //that is the case we determined that if the strings in the classes are the same and is the dog class that were actually comparing that's
        //the case we get the strings or we use the string equal to actually check test whether the strings is the same if you get this far down
        //and we know that they weren't the same so we are going to return false.
        if(obj instanceof Dog) {
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);

        }
        return false;
    }
}
