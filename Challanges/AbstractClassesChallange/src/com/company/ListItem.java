package com.company;
/*
- we declared our variables protected because we need to be albe to acces them from our concrete sublcass.
- We could left the acces modifier off, which would have meant that the member variables are packaged private. so in other words, subclasses in the
same package would be albe to access them, but not subclasses in other packages, as that's why we've made it protected.
 */

public abstract class ListItem {
    //We are creating instances of this ListItem class inside class, and also,
    // each list item object can hold a link to the previous and next items in the list that we're actually gonna be ultimately be saving.
    protected ListItem rightLink = null;
    protected ListItem leftLink = null;

    protected Object value;

    // Classes that inherits from ListItem will need a constructor that sets the value. So it really makes sense in that case because it needs to
    //be done each time to put the constructor in this ListItem abstract class.
    public ListItem(Object value) {
        this.value = value;
    }

    //next returns a reference to the nest ListItem in the list
    abstract ListItem next();    //We'll turn to list items
    // we're parssing the parameter listItems sets the reference to the next item to refer to in the parameter
    abstract ListItem setNext(ListItem item);   // save the item

    //sets the reference to the previous item in the list
    abstract ListItem previous();   //which returns the previous entry
    abstract ListItem setPrevious(ListItem item);   //se that previous link as well to the previous list item.

    // compares an object to the item. Whatever has been passed through the parameter and returend zero with or equal, and also retuns a number if the
    //item parameter hsould sort before the object, which will be negative. Otherwise it is gonna return a positive number.
    abstract int compareTo(ListItem item);  // we can compare and see whtehr or an object is the same based, not just a simple comparasion but actually a rather in depth one

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
