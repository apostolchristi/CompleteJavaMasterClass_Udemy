package com.company;

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
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here

        Player tim = new Player("Tim", 10, 15);
        System.out.println(tim.toString());
        saveObject(tim);

        tim.setHitPoints(8);
        System.out.println(tim);

        tim.setWeapon("Stormbringer");
        saveObject(tim);
//        loadObject(tim);
        System.out.println(tim);


        ISaveable werewolf = new Monster("Werewolf", 20, 40); //by declaring an Interface we can instantiate a new object Class that we need
        System.out.println("Strength = " + ((Monster)werewolf).getStrength()); //((Monster)werewolf).getStrength() - in this case (Monster) is a cast and by that we are saying that we're impementing the interface but is still actually Monster class
        saveObject(werewolf);
    }



    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }

    public static void saveObject(ISaveable objectToSave) {//parsing as a parameter Isaveable interface. By doing that we can actually use any object that is using this interface, that has implemented this interface
        for(int i=0; i<objectToSave.wrrite().size(); i++) {//we are cycling through all the entries using the .write(method from Player class), and it's going through each object because it's using .write which returns the entire list if u will
            System.out.println("Saving " + objectToSave.wrrite().get(i) + " storage device");
        }
    }

    public static void loadObject(ISaveable objectToLoad) {
        ArrayList<String> values = readValues();//the readValues enables you to simulate getting that data from somewhere, but in this case we're just going to top that data in
        objectToLoad.read(values);//so it's looking for the .read method, so we've got the data which we've typed, and we're going back into the Player object is gonna then call the read method and extract the necessary data out and basically save it in the object values for each of those entries of the name the weapon...
    }









}
