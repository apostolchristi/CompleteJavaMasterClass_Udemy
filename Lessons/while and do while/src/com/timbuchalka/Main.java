package com.timbuchalka;

public class Main {

    public static void main(String[] args) {
        isEvenNumber(12);

//        int count = 6;
//        while(count !=6){
//            System.out.println("Count values is " + count);
//            count++;
//        }
//
//        for (int i = 6; i < 7; i++){
//            System.out.println("Count values is " + i);
//        }
//
//        count = 6;
//        do{
//            System.out.println("Count values is " + count);
//            count++;
//            if(count > 100) {
//                break;
//            }
//
//        }while(count != 6);

            int number = 4;
            int finishNumber = 20;
            int count = 0;

            while(number <= finishNumber) {
                number++;
                if(!isEvenNumber(number)){
                    continue;
                }
                System.out.println("Even number " + number);


                count++;
                if(count >= 5){
                    break;
                }
            }
        System.out.println("Event numbers found " +  count);


        // Modify the while code above
        // Make it also record the total number of even numbers it has found
        // and break once 5 are found
        // and at the end, display the total number of even numbers found

    }


    // Create a method called isEvenNumber that takes a parameter of type int
    // Its purpose is to determine if the argument passed to the method is
    // an even number or not.
    // return true if an even number, otherwise return false;

    public static boolean isEvenNumber(int even) {

        if(even % 2 != 0){
//            System.out.println("False"+even);
            return false;
        }
//        System.out.println(even);
        return true;
    }


}
