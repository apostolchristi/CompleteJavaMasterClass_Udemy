package com.timbuchalka;

public class Main {

    public static void main(String[] args) {
        calculateInterest(10000, 2.0);

        // using the for statement, call the calculateInterest method with
        // the amount of 10000 with an interestRate of 2,3,4,5,6,7, and 8
        // and print the results to the console window.

        for(int i=2; i<9; i++){
            System.out.println("10000 at " + i + "% interest = " + String.format("%.2f",calculateInterest(10000, i)));
        }
        System.out.println("****************************************"); //visual separator
        // How would you modify the for loop above to do the same thing as
        // shown but to start from 8% and work back to 2%

        for(int i=8; i>1; i--) {
            System.out.println("10000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000, i)));
        }

        // Create a for statement using any range of numbers
        // Determine if the number is a prime number using the isPrime method
        // if it is a prime number, print it out AND increment a count of the
        // number of prime numbers found
        // if that count is 3 exit the for loop
        // hint:  Use the break; statement to exit

        int count = 0;
        for(int i = 1; i < 9999; i++) {
            if (isPrime(i)) {
                count++;
                System.out.println("The prime number is " + i);
                if (count == 100) {
                    System.out.println("exiting for loop");
                    break;
                }
            }

        }


    }
    public static double calculateInterest(double amount, double interestRate){
         return (amount *(interestRate / 100));

    }

    public static boolean isPrime(int n){
        if (n == 1){
            return false;
        }

        for(int i = 2; i <= n/2; i++){
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
