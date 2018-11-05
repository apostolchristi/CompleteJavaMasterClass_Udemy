package com.timbuchalka;

/*
    -Write a method called reverse() with an int array as a parameter.

-The method should not return any value. In other words, the method is allowed to modify the array parameter.

-In main() test the reverse() method and print the array both reversed and non-reversed.

-To reverse the array, you have to swap the elements, so that the first element is swapped with the last element and so on.

-For example, if the array is {1, 2, 3, 4, 5}, then the reversed array is {5, 4, 3, 2, 1}.


Tip:
	-Create a new console project with the name ÅeReverseArrayChallengeÅf
     */

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
	// write your code here
        int[] array = {1, 5, 3, 7, 11, 9, 15};
        System.out.println("Array  = " + Arrays.toString(array));
        reverse(array);
        System.out.println("Reversed array = " + Arrays.toString(array));
    }

    private static void reverse(int[] array) {
        int maxIndex = array.length-1; // maximum index that we can use
        int halfLength = array.length /2; //half way point of the array
        for (int i=0; i<halfLength; i++){
            int temp = array[i]; //for swaping 2 elements we need to create a temporary int element
            array[i] = array[maxIndex-i];
            array[maxIndex-i] = temp;
        }
    }
}
