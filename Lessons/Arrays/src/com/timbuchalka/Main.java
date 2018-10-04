package com.timbuchalka;

import java.util.Scanner;

public class Main {


    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myIntegers = getIntegers(5); // we are defining an array called myIntegers and the actual value of the array is being passed back from that method. we have a method, that allows us automaticlly to type in 5 numbers and then return them in a form of an array
        for (int i=0; i<myIntegers.length; i++) {
            System.out.println("Element " + i + " ,typed value was " + myIntegers[i]);
        }
        System.out.println("The average is "+ getAverage(myIntegers)); // message for getaverage method
    }

    public  static int[] getIntegers (int number) {    // int[] - means that we return an array
        System.out.println("Enter " + number + " integer values \r");
        int[] values = new int[number]; //define our new array and asign how many elemnts we need by our method parameter

        for (int i=0; i<values.length; i++) {
            values[i] = scanner.nextInt(); //automaticly accept int from console, and then return an integer
        }
    return values;
    }

    public static double getAverage (int[] array) {
        int sum = 0;
        for (int i=0; i<array.length; i++) {
            sum += array[i];
        }

        return (double) sum / (double)array.length; //divding total sum of all the values in the array by the actual length
    }
}
