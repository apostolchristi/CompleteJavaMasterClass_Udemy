package com.timbuchalka;

//In this calss we gonna store the name of the items fro sale with a price and the quantity in stock, also override equals and hash Code and
//in adition we will also impement comparable so the stock items can be used in a sorted collections.
public class StockItem implements Comparable<StockItem> {

    private final String name;
    private double price;
    private int quantityStuck = 0; // can be initialized latter

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStuck = 0; // or here(but you wouldn't  normally do both)
    }

    public StockItem(String name, double price, int quantityStuck) {
        this.name = name;
        this.price = price;
        this.quantityStuck = quantityStuck;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStuck;
    }

    //Adding a msall validation that will make sure that price is greater than 0 before u try and save it
    public void setPrice(double price) {
        if(price > 0.0) {
            this.price = price;
        }
    }

    //basic validation
    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStuck + quantity;
        if(newQuantity >= 0) {
            this.quantityStuck = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if(obj == this) { //doing test to see whether we actually testing against the same object in memory
            return true; //return true because is the same object
        }
        if((obj == null) || (obj.getClass() !=this.getClass() )) {
            return false; //return false because we can't compare, so obivously equals we know that they aren't equal for that reason either
            //there's a null because this can't be null because we are actually in the object running the code so we know that it's not null
            //so if we are comparing to null we are going to get a different value and it's a different class
        }
        String objName = ((StockItem) obj).getName(); //we are comparing the name of our current object we're running in versus the object
        //that's been passed to this method, and then we are going to return a standard string.equals
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering stuckItem.compareTo");
        if(this == o) {
            return 0; // they are equal
        }
        if( o != null) {
            return this.name.compareTo(o.getName()); //we are using in build functionality for a string in using that as a way to compare
            //the stock item and the test
        }

        throw new NullPointerException();
    }

    @Override
    public String toString() {
        return this.name  + " : price " + this.price;
    }
}
