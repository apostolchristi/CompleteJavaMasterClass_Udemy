package com.timbuchalka.todolist.datamodel;

import java.time.LocalDate;

/*
Each todoItems got a short description that will show in the list view so we need an instance variable of type string and in addition we are
gonna allow the user to enter more details about to do item, and that will also be a string and lastly we will also use a local date field that
will store the due date or deadline for the to do item as well, so let;s do that
 */
public class TodoItem {

    private String shortDescription;
    private String details;
    private LocalDate deadline;

    public TodoItem(String shortDescription, String details, LocalDate deadline) {
        this.shortDescription = shortDescription;
        this.details = details;
        this.deadline = deadline;
    }

    public String getShortDescription() {
        return shortDescription;
    }

    public void setShortDescription(String shortDescription) {
        this.shortDescription = shortDescription;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

//    @Override
//    public String toString() {
//        return shortDescription;
//    }
}
