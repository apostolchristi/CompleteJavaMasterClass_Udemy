package com.timbuchalka;
import java.util.Scanner;

public class Main {
/* -Read the numbers from the console entered by the user and print the minimum and maximum number the user has entered.
-Before the user enters the number, print the message ÅgEnter number:Åh
-If the user enters an invalid number, break out of the loop and print the minimum and maximum number.

Hint:
-Use an endless while loop.

Bonus:
-Create a project with the name MinAndMaxInputChallenge.*/
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int min = 2147483647; // Set min to maximum value of int  because when user will be able to enter a number that is greater or equal to the minimum int
        int max = -2147483648; //Set max to minimum value of int
//        boolean first = true; //this boolean(flag) is for getting first introduced number and last maximum

        while(true) {

            System.out.println("Enter number");
            boolean isAnInt = scanner.hasNextInt();

            if(isAnInt) {
                int number = scanner.nextInt();

//                if(first) {
//                    first = false;
//                    min = number;
//                    max = number;
//                }

                if(number > max){
                    max = number;
                }

                if (number < min){
                    min = number;
                }


            } else {
                break;
            }

            scanner.nextLine(); // handle end of line (enter key)
        }

        System.out.println("min  = " + min + ", max = "+max);
        scanner.close();

    }

}



