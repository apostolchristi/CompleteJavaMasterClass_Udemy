package com.timbuchalka;
/*
- Should you allow you classes to be sub classed? if so how do you treat comparasions between the subclass and its base class?
so if the subclass would resonably only add methods that do not alter the way that equal should work. Then allow sub classing but Mark
your equals and hashCode method as final. Now if a sub classes il likely to be different object, then used the method we use in heavenlt body to
make comparasions between the subclass and its base class return false if needed these would really fit then prevent sub classing and force
clients to use composition instead. 

 */

public class DogMain {
    public static void main(String[] args) {
        /*
        Labrador is and instance of dog, but dog though is not an instace of Labrador so the second test returns false
         */
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover));//testing rover against rover2
        System.out.println(rover.equals(rover2));//testing rover2 against rover
    }
}
