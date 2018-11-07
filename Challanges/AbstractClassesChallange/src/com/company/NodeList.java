package com.company;

/*
- Any data structure that we create must have a starting node, we know about that, and that's what we're putting in the ListItem, the getRoot
in the case of the LinkListm this is often called the head of the list but using the term root is also used a lot and actually applies to binary search trees
if u researched on thatm you've probably noticed that.
-
 */
public interface NodeList {
    ListItem getRoot();
    boolean addItem(ListItem item);
    boolean removeItem(ListItem item);
    void traverse(ListItem root);




}
