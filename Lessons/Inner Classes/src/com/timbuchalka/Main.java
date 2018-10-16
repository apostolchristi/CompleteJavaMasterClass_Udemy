package com.timbuchalka;

import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static Button btnprint = new Button("Print");


    public static void main(String[] args) {
	// write your code here
//        GearBox mcLaren = new GearBox(6);
//        GearBox.Gear  first = mcLaren.new Gear(1, 12.3 ); //Instantiate a new object of a Inner CLass Gear
////        GearBox.Gear second = new GearBox.Gear(2, 15.4 ); //this is not correct
////        GearBox.Gear third = new mcLaren.Gear(3, 17.8); //this is not correct
//        System.out.println(first.driveSpeed(1000));

//        //local class
//        class ClickListener implements Button.OnCLickListener {
//            public ClickListener(){
//                System.out.println("I've been atached");
//            }
//
//            @Override
//            public void onClick(String title) {
//                System.out.println(title + " was clicked ");
//            }
//        }
//
//        btnprint.setOnClickLister(new ClickListener());
        btnprint.setOnClickLister(new Button.OnCLickListener() {
            @Override
            public void onClick(String title) {
                System.out.println(title + " was cliked");
            }
        });
    }

    private static void listen() {
        boolean quit = false;
        while(!quit) {
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    btnprint.onClick();
            }
        }
    }
}
