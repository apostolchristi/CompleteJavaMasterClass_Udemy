package com.timbuchalka;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();


    //adding new element(item) to array list
    public void addGroceryItem(String item){ //we gona call this method with an item that's stored in string that we wanna save to the arraylist.
        groceryList.add(item); //.add is a method that is part of ArrayList class. It automatically adds the item into the array list.
    }

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    //print out elements by going through the all items in the array list to retrieve them
    public void printGroceryList() {
        System.out.println("You have " + groceryList.size() + " Items in your grocery list"); //.size - will return how many elements i've currently stored in this arrayList
        for(int i=0; i<groceryList.size(); i++){
            System.out.println(i+1 + ". " + groceryList.get(i)); //.get - access a particular element
        }
    }

    //an overloaded method
    public  void modifyGroceryItem(String curentItem, String newItem) {
        int position = findItem(curentItem);
        if(position >= 0){
            modifyGoreceyItem(position, newItem);
        }
    }

    //how to modify elements in the arrayList or how to replace an item
    void modifyGoreceyItem(int position, String newItem){
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + (position+1) + " has been modified");
    }

    public void removeGroceryItem(String item) {
        int position = findItem(item);
        if (position >= 0) {
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem(int position) {
//        String theItem = groceryList.get(position); //output the item and tell people what item has actually been modified. At that position i'm returning into a String
        groceryList.remove(position); //.remove - remove items for us automatically from position that we transfered into string
    }

    private int findItem(String searchItem) {
//        boolean exists = groceryList.contains(searchItem);//.contains - method that check if specific item exists then it will provide true
//        int position = groceryList.indexOf(searchItem); //.indexOf - search the array list and it finds the item that you've passed, and return the index
//        if(position >=0) {
            return groceryList.indexOf(searchItem);
        }

        public boolean onFile(String searchItem) {
        int position = findItem(searchItem);
        if(position >= 0) {
            return true;
        }
        return false;
        }
}
