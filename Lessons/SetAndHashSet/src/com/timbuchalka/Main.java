package com.timbuchalka;
/*
- will be possible to add a moon set in main and add the moons to it as they are created, you can actually easily generate the union
of the set of each planets moons so on set theory a union of two or more sets is a set containing all the elements of the sets, so because
sets don't contain dublicates each element in a union will only appear once even if it was present in more than one of the sets if that makes sense.
To generate a set union we can use the addAll() method of a set so that by looping through the all planets and calling there getSattellites() method
 we can generate a set of moons even though we dind't actually create one when initializing the data that is sort of a cool feature of sets.

 - Java documentation does warn you that if you're using your own objects as either a key in a map or as an element in the Set, that you should
 override the equals() and hashCode() methods.

 - How come a Set contain duplicates?
 The reason is the two java object do not compare qeual so the se is happy to accept both of them for that reason, and if we use them
 as a keys in a map, same thing will happen as well and we will have two entries in a map so is why the equals method has to be overwritten

 - When storing object in a hashed collections such as HashSets or HashMap, think if the collection is having a number of buckets to store the objects.
 The hash code determines which bucket and objects gonna go into. Now there is a requirement that any objects that are equal should always had the
 same hash code and ultimately so that they will end up in the same bucket but the opposite is not required, so two objects that are equal do not have
 to have different hash codes.

 So when we add an object it's hash Code tells the collection which bucket it should go into. Now they may already be objects in that bucket so
 each is compared to the new object to make sure that it's not already in there. Now because the comparasion is performed using the equals method
 the collection will only know if it's already there if it's looking in the right bucket so the hash code must be the same and equals returns true.
 Now use for equals returning true if the collection is checking the wrong bucket that is if the hash code for the new object is not the same as
 an object that is that it's equal too.

 If we don't iterate over the collection trying to find that new object so that we can remove it we may well get to the old objects 6 first
 and not the new ones, so our code will check if the object we just pulled from the collection is the same as the one we want to remove and of course equals
 will return true, so we remove the object from the collection but actually remove the original not the duplicate. So we probably wouldn't
 iterate ovet the collection we already have a reference to the object we anted to remove, but you can see that it's quite easy or hopefully
 it is for you to see the potential for error in this chenario so there has to be a strict relationship between hasCode and equals.
  So two objects compare equal then they must have the same hash code.

  Summary: If 2 objects compare equal they must have the same hash code that's really the bottom line
 */

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {

    private static Map<HeavenlyBody.Key, HeavenlyBody> solarSystem = new HashMap<>();  //creating a Map in which we will store String = key and HeavenlyBody = Value\
    private static Set<HeavenlyBody> planets = new HashSet<>();

    public static void main(String[] args) {

        //Creating the HeavenlyBody objects and adding into the solar system map and by creating the moons after of the planet we can also
        //add the to planets set of moons
        HeavenlyBody temp = new Planet("Mercury", 88);
        solarSystem.put(temp.getKey(), temp); //ading to HashMap object that was instantiated and in Key = name of Object which is Mercury, Value = HeavenlyBody Object
        planets.add(temp); // adding to HashSet this new Object

        temp = new Planet("Venus", 225);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Earth", 365);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        HeavenlyBody tempMoon = new Moon("Moon", 27);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon);  //because we got earth up there on line 23, we wana add this moon to earh as opposed to adding it as a planet because of course it's a moom

        temp = new Planet("Mars", 687);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Deimos", 1.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        tempMoon = new Moon("Phobos", 0.3);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Mars

        temp = new Planet("Jupiter", 4332);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        tempMoon = new Moon("Io", 1.8);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Europa", 3.5);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Ganymede", 7.1);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        tempMoon = new Moon("Callisto", 16.7);
        solarSystem.put(tempMoon.getKey(), tempMoon);
        temp.addSatellite(tempMoon); // temp is still Jupiter

        temp = new Planet("Saturn", 10759);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Uranus", 30660);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Neptune", 165);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        temp = new Planet("Pluto", 248);
        solarSystem.put(temp.getKey(), temp);
        planets.add(temp);

        //Gives to us a list(HashSet) of planets
        System.out.println("Planets");
        for(HeavenlyBody planet : planets) {
            System.out.println("\t" + planet.getKey());
        }

        //Displaying a list of moons
        HeavenlyBody body = solarSystem.get(HeavenlyBody.makeKey("Mars", HeavenlyBody.BodyTypes.PLANET)); // grabing the planet jupiter from Map
        System.out.println("Moons of " + body.getKey());
        for (HeavenlyBody jupiterMoon : body.getSatellites()) //returns a list of moons for that particular object
            System.out.println("\t" + jupiterMoon.getKey());

        //we're creating a set union with that addAll method. The reason that works is that sets don't contain duplicates and each element
        //in a union will only appear once event if it was present in more than one the sets
        Set<HeavenlyBody> moons = new HashSet<>();
        for(HeavenlyBody planet : planets) {
            moons.addAll(planet.getSatellites());
        }
        System.out.println("All Moons");
        for(HeavenlyBody moon: moons ) {
            System.out.println("\t" + moon.getKey());
        }

        HeavenlyBody pluto = new DwarfPlanet("Pluto", 842);
        planets.add(pluto);

        for(HeavenlyBody planet : planets) {
            System.out.println(planet);
//            System.out.println(planet.getKey() + ": " + planet.getOrbitalPeriod());
        }

        HeavenlyBody earth1 = new Planet("Earth", 365);
        HeavenlyBody earth2 = new Planet("Earth", 365);
        System.out.println(earth1.equals(earth2));
        System.out.println(earth2.equals(earth1));
        System.out.println(earth1.equals(pluto));
        System.out.println(pluto.equals(earth1));

        solarSystem.put(pluto.getKey(), pluto);
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.PLANET)));
        System.out.println(solarSystem.get(HeavenlyBody.makeKey("Pluto", HeavenlyBody.BodyTypes.DWARF_PLANET)));

        System.out.println(); //that is space ;)
        System.out.println("The solar system contains: ");
        for (HeavenlyBody heavenlyBody: solarSystem.values()) {
            System.out.println(heavenlyBody);
        }

    }
}
