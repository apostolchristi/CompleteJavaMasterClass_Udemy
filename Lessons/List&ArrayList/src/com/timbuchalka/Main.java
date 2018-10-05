package com.timbuchalka;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList = new GroceryList();

    public static void main(String[] args) {

        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    proccesArrayList();
                    break;
                case 7:
                    quit = true;
                    break;
            }
        }


    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t 0 - To print chose options. ");
        System.out.println("\t 1 - To print the list of grocery items. ");
        System.out.println("\t 2 - To add the item to the list. ");
        System.out.println("\t 3 - To modify an item in the list. ");
        System.out.println("\t 4 - To remove an item from the list. ");
        System.out.println("\t 5 - To search for the item in the list. ");
        System.out.println("\t 6 - To quit the application. ");

    }

    public static void addItem() {
        System.out.print("Please enter the grocery item: ");
        groceryList.addGroceryList(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.print("Curent item name: ");
        String itemNo = scanner.nextLine();
        System.out.println("Enter replacement item: ");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(itemNo, newItem);
    }

    public static void removeItem() {
        System.out.print("Enter item name: ");
        String itemNo = scanner.nextLine();
        groceryList.removeGroceryItem(itemNo);
    }

    public static void searchForItem() {
        System.out.print("Item to search for: ");
        String searchItem = scanner.nextLine();
        if (groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in our grocery list,");
        } else {
            System.out.println(searchItem + " is not in the shopping list.");
        }
    }

    /*
    Takes the contents that are in grocerylist the .getGroceryList, which if you recall is just returning our array list, our grocerylist arraylist,
    and that's why we added a getter. Thats one way of adding the entire contents to the new array.
     */
    public static void proccesArrayList() {
        ArrayList<String> newArray = new ArrayList<String>();
        newArray.addAll(groceryList.getGroceryList());

        ArrayList<String> nextArray = new ArrayList<String>(groceryList.getGroceryList());//same like previous statments but faster and shorter

        //this statment is for converting from arraylist to simple array
        String[] myarray = new String[groceryList.getGroceryList().size()];//we initialize it to the corect size fisrt
        myarray = groceryList.getGroceryList().toArray(myarray);//that's returning in a registered strings in this case, because it knows it's the get grocery
        //list converting to an array and that returning an array of whatever elements are
    }

}
