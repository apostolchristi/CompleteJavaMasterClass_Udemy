package com.timbuchalka;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] myIntArray = getIntegers(5);
        int[] sorted = sortIntegers(myIntArray);
        printArray(sorted);

    }

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
//        int[] sortedArray = new int[array.length]; //we created an array that is exactly the same size as the array that has been passed to us.
//        for (int i=0; i<array.length; i++) {
//            sortedArray[i] = array[i]; //thats creating a copy of the contents that are in the array that's passed to us into our new array
//        }
        int [] sortedArray = Arrays.copyOf(array, array.length); // same as previous commented lines

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


