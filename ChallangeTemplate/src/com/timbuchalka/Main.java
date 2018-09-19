package com.timbuchalka;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        getLargestPrime(21);



    }

    public static int getLargestPrime(int number){

        if (number <= 1){
            System.out.println("Invalid Value");
            return -1;
        }
        for(int i=2; i<number; i++){
            System.out.println("Stept 1: " + number + " and " + i);

            if(number%i == 0){
                System.out.println("Step 2: " + number + " and " + i);

                number /= i;
                System.out.println("Step 3: " + number + " and " + i);

                i--;
                System.out.println("Stept 4: "+ number + " and " + i);

            }
        }
        System.out.println("The prime number is " + number);
        return 1; //number is prime now
    }
}

//    public static boolean canPack (int bigCount, int smallCount, int goal){
//
//        int b = bigCount*5;
//        int s = smallCount*1;
//        int sum = b + s;
//
//        if((b > goal) && (s < b)){
//            System.out.println("False : because bigCount is " + b + " but sum is " + goal);
//            return false;
//        }
//
//        if ((bigCount == -1) && (smallCount == -1) && (goal == -1)){
//            System.out.println("False : Negative Number");
//            return false;
//
//        }
//
//        if  (sum >= goal){
//            System.out.println("True : because sum is " + sum + " but goal is " + goal);
//            return true;
//        }
//
//
//
//        System.out.println("False");
//        return true;
//        }
//    }


//    public static int swapDigitPairs(int number) {
//        int result = 0;
//        int place = 1;
//        while (number > 9) {
//            result += place * 10 * (number % 10);
//            number /= 10;
//            result += place * (number % 10);
//            number /= 10;
//            place *= 100;
//        }
//        System.out.println(result + place * number);
////        return result + place * number;
//    }

//    public static int numbersToWords(int number){
//
//        if (number < -1){
//            System.out.println("Invalid Value");
//            return -1;
//        }
//
//            int sum = 0;
//        for(int f = 1; f < number; f++){
//            if (number%f == 0){
//                sum += f;
//                System.out.println(+f);
//            }
//
//        }
//        System.out.println(sum);
//        return number;
//    }

//    public static boolean hasSharedDigit (int num1, int num2, int num3){
//
//        if ((num1 < 10 || num1 > 1000) ||(num2 < 10 || num2 > 1000) || (num3 < 10 || num3 > 1000)) {
//            System.out.println("False");
//            return false;
//        }
//        int r = num1%10;
//        int s = num2%10;
//        int x = num3%10;
//
//        System.out.println(num1 % 10 == num2 % 10 || num1 % 10 == num3 % 10 || num2 % 10 == num1 % 10 || num2 % 10 == num3 % 10 || num3 % 10 == num1 % 10
//                || num3 % 10 == num2 % 10);
//        return num1 % 10 == num2 % 10 || num1 % 10 == num3 % 10 || num2 % 10 == num1 % 10 || num2 % 10 == num3 % 10 || num3 % 10 == num1 % 10
//                || num3 % 10 == num2 % 10;
//
//    }

