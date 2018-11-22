package com.timbuchalka;

/*
The symmetric difference is the elements that appear in on set or the other but not both, so it can ther fore be defined as the union minus the
intersection and that will essentially gives the green and blue words in our examples.
By knowing how to get the union and intersection we can get the symmetric difference by removing the intersection from the union that makes
 */

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {

    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for(int i=1; i<=100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }
        System.out.println("there are " + squares.size() + " squares and " + cubes.size() + " cubes");

        //Transforms squares into the union of squares and cubes(The union of two sets containing all of the elements contained in either set) - Bulk Operations
        Set<Integer> union = new HashSet<>(squares); //parameter is going to add the fiest 100 elements from the square set, using that in the constructor
        union.addAll(cubes);
        System.out.println("Union contains " + union.size() + " elements.");

        //Transform squares into the intersection of squares and cubes(The interection of two sets is the set containing only the elements common to both sets)
        Set<Integer> intesrection = new HashSet<>(squares);
        intesrection.retainAll(cubes);
        System.out.println("Intersection contains " + intesrection.size() + " elements");
        for(int i : intesrection) { //for each to go through each element in the hashSet
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of " + Math.cbrt(i)); //Math.sqrt and Math.cbrt = Math class using method to calculate what we need
        }

        Set<String> words = new HashSet<>();
        String sentence = " one dat in the year of the fox";
        String [] arrayWords = sentence.split(" "); //can get each word that's in a string and as a separate netry in our string array
        words.addAll(Arrays.asList(arrayWords));//transform array in a list by using Array.asList

        for(String s : words) { //going through each item in the set and print it
            System.out.println(s);
        }

//=====================================================================
        //symmetric (contains common words in the middle)
        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();

        String[] natureWords = {"all", "nature", "is", "unknown", "to", "thee"};
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = {"to", "err", "is", "human", "to", "forgive", "divine"};
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("nature - divine: ");
        Set<String> diff1 = new HashSet<>(nature);
        diff1.removeAll(divine);
        printSet(diff1);

        System.out.println("divine - nature:");
        Set<String> diff2 = new HashSet<>(divine);
        diff2.removeAll(nature);
        printSet(diff2);

//=====================================================================

        //Removing intersections from unions to make it assymmetric
        Set<String> unionTest = new HashSet<>(nature);
        unionTest.addAll(divine);
        Set<String> intersectionTest = new HashSet<>(nature);
        intersectionTest.retainAll(divine);

        System.out.println("Symetric difference");
        unionTest.removeAll(intersectionTest);

//=====================================================================

        //containsAll is used to test if one set is a super set of another. This one's actually non-destructive so its only testing membership
        //and doesn't actually modify the sets just literally returns a true or false as appropriate depending on  you answer
        if(nature.containsAll(divine)) {
            System.out.println("divine is a subset of nature");
        }

        if(nature.containsAll(intersectionTest)) {
            System.out.println("intersection is a subset of nature");
        }

        if(divine.containsAll(intersectionTest)) {
            System.out.println("intersection is a subset of divine");
        }

    }

    private static void printSet(Set<String> set) {
        System.out.println("\t");
        for(String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}
