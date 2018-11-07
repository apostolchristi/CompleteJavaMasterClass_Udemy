package com.company;

public class MyLinkedList implements NodeList {

    private ListItem root = null;   //that's gonna be our basic, our head record or our root record

    public MyLinkedList(ListItem root) {
        this.root = root;
    }

    @Override
    public ListItem getRoot() {
        return this.root;
    }

    @Override
    public boolean addItem(ListItem newItem) {
        if (this.root == null) {
            // The list was empty, so this item becomes the head of the list
            this.root = newItem;
            return true;
        }
        ListItem currentItem = this.root;
        //So while we've still got the ability to actually link through our items, cuz we're gonna be going through and comparing then one by one
        //And going through to the next and the next, so on. If we reach a null, that basically means that there's no more entries to actually go through
        //in the list
        while (currentItem != null) {
            int comparison = (currentItem.compareTo(newItem));
            if (comparison < 0) {
                //newItem is greater, move right if possible
                if (currentItem.next() != null) {
                    currentItem = currentItem.next();
                } else {
                    //there is no next, so insert at end of list
                    currentItem.setNext(newItem).setPrevious((currentItem));
                    return true;
                }
            } else if (comparison > 0) {
                //newItem is less, insert before
                if (currentItem.previous() != null) {
                    currentItem.previous().setNext(newItem).setPrevious(currentItem.previous());
                    newItem.setNext(currentItem).setPrevious(newItem);
                } else {
                    //the node with a previous is the root
                    //We are setting newItem.next to point what is currently the root record. And that's because we're inserting ourselves
                    //we're becoming the root, so we need to point to what was the root, so we need another gate in traverse. It actualy goes
                    //to that entry, and then obiously, the sear root we're setting the set previous to point back to the newItem, because it's now not
                    //going to be the root anymore, it's gonna be seort of the second item, and needs to have a previous link to the new record that we're
                    //adding, the new item. And last thingm we're setting the this.root, which is our head, the head of the list to become this new item.
                    newItem.setNext(this.root).setPrevious(newItem);
                    this.root = newItem;
                    ;
                }
                return true;
            } else {
                //We've already tested and then they-re equal
                System.out.println(newItem.getValue() + " is already present, not added.");
                return false;
            }
        }
        return false;
    }

    @Override
    public boolean removeItem(ListItem item) {
        if (item != null) {
            System.out.println("Deleting item " + item.getValue());
        }

        ListItem currentItem = this.root;
        while (currentItem != null) {
            int comparison = currentItem.compareTo(item);
            if (comparison == 0) {
                //found the item to delete
                if (currentItem == this.root) {
                    this.root = currentItem.next();
                    currentItem.previous().setNext(currentItem.next());
                    if (currentItem.next() != null) {
                        currentItem.next().setPrevious(currentItem.previous());
                    }
                }
                return true;
            } else if (comparison < 0) {
                currentItem = currentItem.next();
            } else {//comparision > 0
                //we are at an item greater than the one to be deleted
                //so the item is not in the list
                return false;
            }
        }
        //we have reached the end of the list
        //without finding the item to delete
        return false;
    }

    @Override
    public void traverse(ListItem root) {
        if (root == null) {
            System.out.println("The list is empty");
        } else {
            while (root != null) {
                System.out.println(root.getValue());
                root = root.next();
            }
        }

    }


}
