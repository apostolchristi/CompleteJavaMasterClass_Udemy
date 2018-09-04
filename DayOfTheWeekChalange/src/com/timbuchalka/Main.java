package com.timbuchalka;

public class Main {

    public static void main(String[] args) {
	printDayOfTheWeek(2);
	printDayOfTheWeek(10);
    }

    public static void printDayOfTheWeek(int day){

        switch(day){
            case 1:
                System.out.println("Monday");
                break;

            case 2:
                System.out.println("Tuesday");
                break;

            case 3:
                System.out.println("Three");
                break;

            case 4:
                System.out.println("Four");
                break;

            case 5:
                System.out.println("Five");
                break;

            case 6:
                System.out.println("SIx");
                break;

            case 7:
                System.out.println("SEVEN");
                break;

            case 8:
                System.out.println("EIGHT");
                break;

            case 9:
                System.out.println("Nine");
                break;

                default:
                    System.out.println("Invalid Day");
                    break;
        }
    }
}
