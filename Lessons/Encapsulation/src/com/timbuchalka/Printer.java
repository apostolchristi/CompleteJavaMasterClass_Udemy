package com.timbuchalka;


// It should have fields for the toner Level, number of pages printed, and
// also whether its a duplex printer (capable of printing on both sides of the paper).
// Add methods to fill up the toner (up to a maximum of 100%), another method to
// simulate printing a page (which should increase the number of pages printed).
// Decide on the scope, whether to use constructors, and anything else you think is needed.
public class Printer {

    private int tonerLevel;
    private int numberOfPagesPrinted;
    private boolean duplex;

    public Printer(int tonerLevel, int numberOfPagesPrinted, boolean duplex) {
        this.tonerLevel = tonerLevel;
        this.numberOfPagesPrinted = numberOfPagesPrinted = 0;
        this.duplex = duplex;
    }

    public void fiilTheToner(int tonerLevel) {
        this.tonerLevel = tonerLevel;
        if(tonerLevel <= 10) {
            System.out.println("Toner level is " + tonerLevel + " %, please refil it");
        } else if (tonerLevel >= 100) {
            System.out.println("Toner level is " + tonerLevel + " %. Nice job");
        }
    }

    public void printing (int pages) {
        this.numberOfPagesPrinted += pages;
        System.out.println("You want to print " + pages + " pages. In total printed pages are " + this.numberOfPagesPrinted );
    }

    public int getTonerLevel() {
        return tonerLevel;
    }

    public int getNumberOfPagesPrinted() {
        return numberOfPagesPrinted;
    }

    public boolean isDuplex() {
        return duplex;
    }
}
