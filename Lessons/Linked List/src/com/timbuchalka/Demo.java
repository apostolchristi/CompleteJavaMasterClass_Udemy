package com.timbuchalka;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {

    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<String>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit,"Sidney");
        addInOrder(placesToVisit,"Melbure");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit,"Canbera");
        addInOrder(placesToVisit,"Adelaide");
        addInOrder(placesToVisit,"Darwin ");
        printList(placesToVisit);

        addInOrder(placesToVisit,"Alice Spring");
        addInOrder(placesToVisit,"Darwin ");
        printList(placesToVisit);

        visit(placesToVisit );



    }

    private static void printList(LinkedList<String> linkedList){
        Iterator<String> i = linkedList.iterator();//iterator is a method from Iterator<>, and we are doing here equivalent to a for loop
        while(i.hasNext()){//hasnext = if at least in this linkedlist is one more record, statment will be true, its equivalent to i++
            System.out.println("Now visiting " + i.next());
        }
        System.out.println("===================");
    }

    /*
    this method is going through and sorting our capital cities
     */
    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();

        while(stringListIterator.hasNext()){//going thru all the records;
            int comparasion  = stringListIterator.next().compareTo(newCity);//.next = get to the first entry
            if(comparasion ==0) {
                //equal, do not add;

                System.out.println(newCity + " is already included as a destination");
                return false; //it wasnt succeseful added
            } else if (comparasion >0) {
                //new city should appear before this one
                //Brisbane -> Adelaide
                stringListIterator.previous();//go Back to the privious entry, the privious match or previous record
                stringListIterator.add(newCity);
                return true;
            } else if (comparasion<0) {
                //move on next city
            }
        }
        stringListIterator.add(newCity);//new item go to the end of the list
        return true; //makes the method valid
    }

    private static void visit(LinkedList cities){
        Scanner scanner = new Scanner(System.in);

        boolean quit = false;
        boolean goingforward = true;
        ListIterator<String> listIterator = cities.listIterator();

        if(cities.isEmpty()) {
            System.out.println("No cities in the itenerary");
            return;
        } else {
            System.out.println("Now visiting " +  listIterator.next());
            printMenu();
        }

        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holiday (vacation) over");
                    break;
                case 1:
//we are doing aditional check to make sure that we actually can go, that there is ability to go next, and then actually go to the next entry again, so that we can actually continue where we left of.
                    if(!goingforward){
                        if(listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingforward = true;
                    }
                    if(listIterator.hasNext()) {
                        System.out.println("Now Visiting " + listIterator.next());
                        break;
                    }else {
                        System.out.println("Reached the end of the line");
                        goingforward = false; //we reach the end of the list so is no way to go forward
                    }
                    break;
                case 2:
//if the user selected to go forward and if we count it not going forward, we check to see whether there's an entry we can go forward to
                    if(goingforward) {
                        if(listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingforward = false;
                    }
                    if(listIterator.hasPrevious()){
                        System.out.println("Now Visiting " + listIterator.previous());
                    }else {
                        System.out.println("We are at the start of the list");
                        goingforward = true; //thats the only one direction where we can go now,cuz we reached the first entry, so we automatically changed the direction
                    }
                    break;

                case 3:
                    printMenu();
                    break;

                }
            }
        }

        private static void printMenu(){
            System.out.println("Avilable actions:\npress");
            System.out.println("0 - to quit\n" +
                                "1 - Go to next city\n"+
                                "2 - Go to previous city\n"+
                                "3 - Print menu options\n");


        }

    }

