package com.timbuchalka;

import com.sun.org.apache.bcel.internal.generic.LADD;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {

        Map<String, String> languages = new HashMap<>();
        if(languages.containsKey("Java")) {
            System.out.println("Java already exists");
        } else {
            languages.put("Java", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
            System.out.println("Java added successfully ");
        }
        languages.put("Python", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        languages.put("Algol", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.");
        System.out.println(languages.put("BASICS", "Lorem Ipsum is simply dummy text of the printing and typesetting industry."));
        System.out.println(languages.put("Lisp", "Therein lies madness"));

        if(languages.containsKey("Java")) {
            System.out.println("Java is already in the map");
        } else {
            languages.put("Java", "this course is about Java");
        }

        System.out.println("=========================================================================================================");

//        languages.remove("Lisp");
        if(languages.remove("Algol", "Lorem Ipsum is simply dummy text of the printing and typesetting industry.")) {
            System.out.println("Algo removed");
        } else {
            System.out.println("Algo not removed, ket/value pair not found");
        }

        if(languages.replace("Lisp", "Therein lies madness", "a functional programming language with imperative featues")){
            System.out.println("Lisp replaced");
        } else {
            System.out.println("Lisp was not replaced");
        }

//        System.out.println(languages.replace("Scala", "this will not be added"));

        //To print out all our keys and values we can put
        for(String key : languages.keySet()) { // is similar to for(int i=0; i<argument.length; i++);
            System.out.println(key + " : " + languages.get(key)); //thats gona loop through the map and return all the values
        }


    }
}
