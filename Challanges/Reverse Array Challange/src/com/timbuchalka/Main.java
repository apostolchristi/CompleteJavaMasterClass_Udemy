package com.timbuchalka;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /*
    -Write a method called reverse() with an int array as a parameter.

-The method should not return any value. In other words, the method is allowed to modify the array parameter.

-In main() test the reverse() method and print the array both reversed and non-reversed.

-To reverse the array, you have to swap the elements, so that the first element is swapped with the last element and so on.

-For example, if the array is {1, 2, 3, 4, 5}, then the reversed array is {5, 4, 3, 2, 1}.


Tip:
	-Create a new console project with the name ÅeReverseArrayChallengeÅf
     */

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        int[] array = {1,5,3,7,11,9,15};
        System.out.println("Array = " + Arrays.toString(array));

        reverse(array);

        System.out.println("Reversed array  = " + Arrays.toString(array));

    }

    private static void reverse(int[] array) {

        int maxIndex = array.length - 1; // wil reperesent the maximum index
        int halfLength = array.length / 2; // represents half of the aray length
        for (int i=0; i<halfLength; i++) {
            int temp = array[i]; // saved in temp variable the index that was in i
            array[i] = array[maxIndex-i]; //we moved element from index max take i to index i
            array[maxIndex-i] = temp;
        }

    }
}
