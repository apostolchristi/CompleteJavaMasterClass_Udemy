package com.timbuchalka;


// Create a program using arrays that sorts a list of integers in descending order.
// Descending order is highest value to lowest.
// In other words if the array had the values in it 106, 26, 81, 5, 15 your program should
// ultimately have an array with 106,81,26, 15, 5 in it.
// Set up the program so that the numbers to sort are read in from the keyboard.
// Implement the following methods - getIntegers, printArray, and sortIntegers
// getIntegers returns an array of entered integers from keyboard
// printArray prints out the contents of the array
// and sortIntegers should sort the array and return a new array containing the sorted numbers
// you will have to figure out how to copy the array elements from the passed array into a new
// array and sort them and return the new sorted array.

import java.util.Scanner;

public class ArrayChalange {

    private static Scanner scanner = new Scanner(System.in);




    int[] myIntArray = getIntegers(5);


    public static int[] getIntegers(int capacity) {
        System.out.println("Enter " + capacity + " integer values \r");
        int[] array = new int[capacity];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        return array;
    }

    public static void printArray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println("Element " + i + " ,typed value was " + array[i]);
        }
    }

    public static int[] sortIntegers(int[] array) {
        int[] sortedArray = new int[array.length]; //we created an array that is exactly the same size as the array that has been passed to us.
        for (int i=0; i<array.length; i++) {
            sortedArray[i] = array[i]; //thats creating a copy of the contents that are in the array that's passed to us into our new array
        }
        boolean flag = true;
        int temp;
        while(flag) { // we exectue at least once because it is set to true
            flag = false; // we set to false to continue code bellow until it gets back to true in the bottom
            for (int i=0; i<sortedArray.length-1; i++){//our ending element is always one less than total array because of i+1 in on line 52
                if (sortedArray[i] < sortedArray[i+1]) {//if the sortedArray on element 0 is less than sortedArray at the next element in number, in our case we started from 0 but next is 1
                    temp = sortedArray[i]; //store the current value of sortedArray in to the temporarily variable temp
                    sortedArray[i] =sortedArray[i+1]; // we move value from sortedArray[i+1] into the sortedArray[i] or swaping them
                    sortedArray[i+1] = temp;
                    flag = true;

                }

            }
        }

        return sortedArray;

    }
}

