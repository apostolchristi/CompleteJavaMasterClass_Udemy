package com.timbuchalka;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in); //Scanner allow us to read user import
        //new = Instance of scanner or we creating a new object of type scanner, because we use primitive types

        System.out.println("Enter your birth: ");

        boolean hasNextInt = scanner.hasNextInt(); // By this line we solve problem with characters that can be introduced in int parameter
        if(hasNextInt){ // As long if hasNextInt is not true, code bellow couldnts work

            int yearOfBirth = scanner.nextInt();
            scanner.nextLine(); // handle next line character (enter key)

            System.out.println("Enter your name : ");
            String name = scanner.nextLine();//nextLine is a method that permit to read a line from the console

            int age = 2018 - yearOfBirth; // calculate how old the person is, by his self introduction of years
            if (age >= 0 && age <=100){
                System.out.println("Your name is: " + name + ", and you are " + age + " years old");
            }else {
                System.out.println("Invalid Year of Birth");
            }

        }else {
            System.out.println("Unable to parse year of birth");
        }

        scanner.close();// is recomanded to close scaner after we used it to release underlying memory that scanner was using internally


        // Whenever we read a number from the scanner being an int or double or float or smth else... nad by pressing enter, we end the line.
        //Its recomanded after calling an Int or other similar type, to call .nextLine without assigning to a variable for solving enter issue.
    }
}
