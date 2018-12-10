package com.timbuchalka.todolist.datamodel;

/*
        Why we did this TodoData
This code will load and store TodoItems in a flat file and will start with storing the items and then we will run our application so that
 it will save the hard coded items and you recall that the application class which our main class extends has a stop method that we can
 override and this will be a logical place to store our data. However the controller will need the data to populate the ListView and it
 already has ready access to the ListViews contents when we want to store them. So for experience sake and because we doing this quick
 and dirty way, we can get back to the UI coding.
 What we'll do is add a singleton class that both our main class and the controller can access.
 In a nutshell will use a singleton that we want there to be only one instace of a class created over the entire run of the application.
 Because of this the singleton class creates the on instace of itself.
 It has a private constructor to ensure that no other class can create an instance.
 There's more toward than that, but the important thing for us is that the singleton usually contains a static method that
 allows any class to get the single instace and call its methods.

The application class which our main class extends from, has a stopped() method that we can override and that would be a good logical place
to store our data. However the controller will need the data to populate the ListView and it also has ready access to the ListViews contents
which when we want to store them. So for experience sake and because we are doing this in a quick and dirty way, so we can get back to our user
interface coding.

 */

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;

public class TodoData {

    private static TodoData instance = new TodoData(); //instantiating our Singleton class
    private static String filename = "TodoListItems.txt"; //we will be stored our data

    private ObservableList<TodoItem> todoItems; //here we will store our items
    private DateTimeFormatter formatter; //for manipulating the date

    public static TodoData getInstance() { //public method to return our instance of our class
        return instance;
    }

    private TodoData () { //by setting constructor to be private, it prevent anyone from being able to instatiate a new version of this class
        formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
    }

    //method that retuns our TodoItem = Getter
    public ObservableList<TodoItem> getTodoItems() {
        return todoItems;
    }

    public void addTodoItem(TodoItem item) {
        todoItems.add(item);
    }

//    // We only need that so the controller could store the hardcoded items
//    public void setTodoItems(List<TodoItem> todoItems) {
//        this.todoItems = todoItems;
//    }


    //method that retrives and will be used to load our TodoItems from the file and I'm gonna write this code using the old try finally syntax
    public void loadTodoItems() throws IOException {
/* FXCollections.observableArrayList = we were setting up our TodoListView in controller, and this is about setAll() command were we're setting our
TodoItems, if we go in there and have a look, you could see that talks about the observable list and adding all elements. So we need to have an
array in a format with that used the observable ArrayList so that's why we've created in our TodoData a similar thing. So we use a
FXCollection.obserableArrayList to create that from scratch and then we append our to do items from there and in addition we've used a
couple of things that look a little bit different.
 We've used path and files and when we're importing that it was java.nio, you can see nio.file.files and then .path.paths etc... and what
 they are is an alternative way to access data that is more recent addition to the Java language, so we are using that just to be a little
 bit different to what we saw in the files or the input or output section. */
        todoItems = FXCollections.observableArrayList(); // FXCollections enables us to have an ArrayList in that format
        Path path = Paths.get(filename); //specifing path to the files to load
        BufferedReader br = Files.newBufferedReader(path); //we are pointing to the location where the file is Read

        String input; //is going to contain the data for each line

        try{
            //we've got three pieces of information: the sortDescription, details nad the datestring, we formated the date
            while((input = br.readLine()) != null) { //create the loop that goes through and retrieves the dat
                String[] itemPieces = input.split("\t");   // the data will use a string array for that so
                String shortDescription = itemPieces[0]; // first element ofS a array // left hand side
                String details = itemPieces[1]; // u get information on the right hand side
                String dateString= itemPieces[2]; //
                LocalDate date = LocalDate.parse(dateString, formatter);//conver the date to the format that we can read it
                TodoItem todoItem = new TodoItem(shortDescription, details, date); //creating the TodoItem
                todoItems.add(todoItem);//we built up an array list of our items
            }
        } finally {
            if(br != null) //making sure we've got a valid object
                br.close();
        }
    }

    //
    public void storeTodoItems() throws IOException { //

        Path path = Paths.get(filename); //specifing path to the files
        BufferedWriter bw = Files.newBufferedWriter(path); //we are pointing to a location where the files will be Writen
        try {
            Iterator<TodoItem> iter = todoItems.iterator();//we are going to iterate trough the list of to do items, and save them one entry at a time to the text file
            while(iter.hasNext()) { //so it builds up an interator that we can cylce through record by record, entry by entry, from our list of to do items and retrive one at a time. Testing to see whther there's another entry in the iterator we can use and if their is this code is going to be executed so we'll
                TodoItem item = iter.next(); // grabing the next entry out of the iterator
                bw.write(String.format("%s\t%s\t%s\t", //\t = type caracter
                        item.getShortDescription(),
                        item.getDetails(),
                        item.getDeadline().format(formatter)));
                bw.newLine();// ads new line to the text file
            }

        }finally {
            if(bw != null) { // testing if we got a valid object
                bw.close();
            }

        }

    }

    /*
                                                        Conclusion

    Looking back at the code we've got the loadTodoItems that read the TodoItems from a file so the store items method writes data the
    TodoItems to a file, and we use the tab delimiter to delimit each to do items value.

    The setTodoItems  on line 62 is temporary, we only needed when we run the application then closed it to save the hard coded items.

    - Because this is a singleton whenever any part ou our application wants to access the data, it has to call to do data.getinstance.getTodoItems
because of course we set our constructor to be a private one meaning you can instantiate a new object from this class by any other means essentially.
     */

    public void deleteTodoItem(TodoItem item) {
        todoItems.remove(item);
    }

}
