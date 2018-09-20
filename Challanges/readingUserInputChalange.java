package com.timbuchalka;
import java.util.Scanner;

public class Main {

    /* -Read 10 numbers from the console entered by the user and print the sum of those numbers.
-Create a Scanner like we did in the previous video.
-Use the hasNextInt() method from the scanner to check if the user has entered an int value.
-If hasNextInt() returns false, print the message ÅgInvalid NumberÅh. Continue reading until you have read 10 numbers.
-Use the nextInt() method to get the number and add it to the sum.
-Before the user enters each number, print the message ÅgEnter number #x:Åh where x represents the count, i.e. 1, 2, 3, 4, etc.
-For example, the first message printed to the user would be ÅgEnter number #1:Åh, the next ÅgEnter number #2: Åh, and so on.

Hint:
-Use a while loop.
-Use a counter variable for counting valid numbers.
-Close the scanner after you donÅft need it anymore.
-Create a project with the name ReadingUserInputChallenge.*/

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 10 numbers that u would like to know sum of them.");
        System.out.println("Time to input nr. 1");

        boolean hasNextInt = scanner.hasNextInt();
        if(hasNextInt){

            int count = 1;
            int sum = 0;

            // this while loop offer me 10 times to introduce new int from new line
            while (count < 11){

            int number = scanner.nextInt();// way of introducing number
                System.out.println("You entered number " +number+ ". Is time to introduce nr." + count);

            count++; //repeat action 10 times
            sum += number; // calculating summ of introduced numbers
            System.out.println("Step 2:  " +sum+ " and " + count); // for my understanding what's going around
            }

            System.out.println("Sum of all introduced numbers are " + sum);

        }else{
            System.out.println("Invalid Number");
        }
        scanner.nextLine();//one more line

        scanner.close();

    }

}
