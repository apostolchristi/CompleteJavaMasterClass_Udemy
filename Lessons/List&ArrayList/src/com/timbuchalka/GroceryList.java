package com.timbuchalka;

import java.util.ArrayList;

public class GroceryList {

    private ArrayList<String> groceryList = new ArrayList<String>(); // this is a ArrayList(this is a Class and can hold objects) and we initiate it with new keyword. Also it has his own construcions ();

    public ArrayList<String> getGroceryList() {
        return groceryList;
    }

    public void addGroceryList(String item){
        groceryList.add(item);//automatically adds the item into the array list

    }

    public void printGroceryList() {
        System.out.println("you have " + groceryList.size()+ " items in your groceryList"); //.size return how many elements are stored in the curent arraylist
        for (int i=0; i<groceryList.size(); i++) {
            System.out.println((i+1) + " . " + groceryList.get(i));//that will output all the elements that are currently stored in the array list

        }
    }
/*
We created an overload method. it's trying to find an item and it's returning the number based on "Returning groceryList.indexOf
 */
    public void modifyGroceryItem(String curentItem, String newItem) {
        int position = findItem(curentItem);
        if(position >=0) {
            modifyGroceryItem(position,newItem);
        }
    }

    private void modifyGroceryItem(int position, String newItem) {
        groceryList.set(position, newItem); // that effectively replace that item in that position
        System.out.println("Grocery item " + (position+1) + " has benn modified.");

    }

    public void removeGroceryItem (String item) {
        int position = findItem(item);
        if(position >=0) {
            removeGroceryItem(position);
        }
    }

    private void removeGroceryItem (int position) {
        groceryList.remove(position);
    }

    private int findItem(String searchItem) {
        return groceryList.indexOf(searchItem);//return a number corespoding to the index position in our ArrayList for the searched item
    }

    public boolean onFile(String searchItem) {

        int position = findItem(searchItem);
        if (position >=0) {
            return true;
        }
        return false;
    }
}
