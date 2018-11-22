package com.timbuchalka;
/*
 A nested enum is automatically static so it's possible to refer to the enum values without creating an instance of a heavenly body object
 */

import java.util.HashSet;
import java.util.Set;

public abstract class HeavenlyBody {
    private final Key key;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    //we defined a type with bodyvalues which u see. When we change the constructor we can make sure thatit only accepts a valid boy dype
    public enum BodyTypes {//Advantage of using enum here is that we get an error at compile time if body type isn't valid so if someone tries to sort
        STAR,              //of pass an invalid type their we are going to get an error
        PLANET,
        DWARF_PLANET,
        MOON,
        COMET,
        ASTEROID
    }

    public HeavenlyBody(String name, double orbitalPeriod, BodyTypes bodyType) {
        this.key = new Key(name, bodyType);
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }


    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Key getKey() {
        return key;
    }

    //0.1 - We want to pass a parameter which will be a HeavenlyBody and will cal it moon and we wanna added it to effectively to the has set
    //0.2 - Changed name of method and now can be added as a satellite of the other of any other planets, and if we want to restrict planets
    //only have moons orbiting them, we can override the addSatellite method in the planet sub class
    public boolean addSatellite(HeavenlyBody moon) {
            return this.satellites.add(moon); //adds the specified element to this set if it is not already present
    }

    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites); //we are creating a new HashSet of the current contetns of our satellite, which again means that
        //the code that is calling this object doesn't have acces to our original HashSet.
    }


    /*
    It checks to see if it's been compared to iteslf, so if it's checking for itself it's going to return true because we discussed how from
    an object's point of view equals just returns true if the object you're comparing is the same object in memory. Next it does a simialr test to the
     instanceof tests. In order to make sure that sub classes do not compare equal what we doing is we check the actual class of the object being
     compared against the class of the object the method is in. Now if we try to get the get class method of null, we get a null pointer exception
     so that's why we have to have a test first, to test null first. Null will fail the instance of checks so an explicit test for null is
     required when using instant of.
     And obviously so that we know what's going on we printing out the result, but we won't leave that in the
     final code but it's also useful to see when our equals method is called as well as explaing what the test is doing. And finally because we've
     just comparing names we establish that's going to be our criteria for an equals match in the heavenly body given that the string class already has
     an equals method we can cast the object we comparing to a heavenly body and then use a string equals method to compare its name against the na
     name of the current object which has of course is this.name. So we know this class is safe and won't throw an exception because we've
     already checked for null and also ensure that object is a heavenly body as well on that same line.
     */

    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {   //first of all we're going to do that first check to see wether we're dealing with the same object
            return true; // that is the case then really we don't need to do any more processing so we return true
        }
        if (obj instanceof HeavenlyBody) {  // confirms that we recived the right type of class
            HeavenlyBody theObject = (HeavenlyBody) obj; //creating a new object casting it correctly because we know that type
            return this.key.equals(theObject.getKey());
        }
        return false; //we know that there's been either the name is different or the bodyType is different

    }

    public static Key makeKey(String name, BodyTypes bodyType) {
        return new Key(name, bodyType);
    }

    @Override
    public final int hashCode() {
        return this.key.hashCode();
//       return this.name.hashCode() + 57 + this.bodyType.hashCode(); // this.bodType.hasCode() gives as unick hascode
        //the hascode in this case that we're calling is the has code method from the String class.
        //number guarantees that we've got a number a non-zero number that's been  returend for each of our hashes. So again we're using the code that
        //comes back from a string but we're adding 57 to that as well so it's a non-zero number because has code from the string source code is returing
        //its won hash code and we're adding the number 57 to that
    }

    //Makes printing out the heavenlybodies easier. That displays the body type and orbital period as well as the name
    @Override
    public String toString() {
        return this.key.name + ": " + this.key.bodyType + ", " + this.orbitalPeriod;
    }



    public static final class Key {
        private String name;
        private BodyTypes bodyType;

        private Key(String name, BodyTypes bodyType) { //this private constructors works because it is innerclass
            this.name = name;
            this.bodyType = bodyType;
        }

        public String getName() {
            return name;
        }

        public BodyTypes getBodyType() {
            return bodyType;
        }

        @Override
        public int hashCode() {
            return this.name.hashCode() + 57 + this.bodyType.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            Key key = (Key) obj;
            if(this.name.equals(key.getName())) { // check if name matches, then
                return (this.bodyType == key.getBodyType()); // we also do a search and return the result of comparing this.bodytype to key.getbodytype
            }
            return false;
        }

        @Override
        public String toString() {
            return this.name + ": " + this.bodyType;
        }
    }
}
