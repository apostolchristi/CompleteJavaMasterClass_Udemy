package com.timbuchalka.todolist;

import com.timbuchalka.todolist.datamodel.TodoData;
import com.timbuchalka.todolist.datamodel.TodoItem;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.util.Callback;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;

/*
Controller also handles the interaction between the user interface and the data model
 */
public class Controller {
    private List<TodoItem> todoItems;

    @FXML //- event handler for the code
    private ListView<TodoItem> todoListView; //by adding generic<TodoItem> we specify which type we are using

    @FXML
    private TextArea itemDetailsTextArea;

    @FXML
    private Label deadlineLable; // Label

    /* After assigning id to mainBorerPane we can ask the boarderPane for the reference to its parent and we can do that by calling getScene
    which will return a scene from the border pane and then will call scenes getWindow() method and set the result as the owner of the dialogue. */
    @FXML
    private BorderPane mainBorderPane;

    @FXML
    private ContextMenu listContextMenu;

    @FXML
    private ToggleButton filterToogleButton;

    private FilteredList<TodoItem> filteredList;

    private Predicate<TodoItem> wantAllItems;
    private Predicate<TodoItem> wantTodaysItems;




    public void initialize() {
        /*
        Since we wana select the first item everytime we run, we could just set the detailsTextArea directly in the controllers initialize method
        by calling something along the lines of item details text.settext and in passing in the details for the first to do item. But
        thinking about it they'll be other times we want to change the selection pragmatically, for example when the user adds a new TodoItem to
        the list, we want to select it, so the first details are displayed, so therefore a better solution would be to listen for selection changes regardles
        of how thet take place, pragmatically or through user input. So instead of assigning an event handel to the onMouseClick property,
        we will run our event handler whenever the selected item property of the selection model changes, so we have to set our event handling code
        rather than the fxml will do this in the controllers initialization method, and will do that before we select the first time.

        So it's overwritten a method called "changed" and if u recall back from the lecture on events and event handling, you will recall these
        events handlers are also known as event listeners because an application will listen for an event and when that event is raised the Associated
        event handler will run. So our event handler will be an instace of the change listnerer class. So in our code we are using an anonymous
        class for the event handler and we are overriding the change method as you can see.

        Olso we've now written a generic event handler that handles any time the value changes so it's now going to pick up either way either clicking
        on a mouse or pragmatically
         */
        listContextMenu = new ContextMenu(); //initializing it when the initialize method is executed
        MenuItem deleteMenuItem = new MenuItem("Delete"); //creating the delete menu item, that's going to be part of this context menu and associated an event handler
        deleteMenuItem.setOnAction(new EventHandler<ActionEvent>() { // event handler that is going to be processed when we exit when the right click happens
            @Override
            public void handle(ActionEvent event) {
                TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                deleteItem(item);
            }
        });

        listContextMenu.getItems().addAll(deleteMenuItem); // add to delete item menu item iteslelf to our context menu and we do that by calling get items in our context menu and we add the delete item using the add all method


        todoListView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<TodoItem>() {
            @Override
            public void changed(ObservableValue<? extends TodoItem> observable, TodoItem oldValue, TodoItem newValue) {
                if (newValue != null) {
                    TodoItem item = todoListView.getSelectionModel().getSelectedItem();
                    itemDetailsTextArea.setText(item.getDetails());
                    DateTimeFormatter df = DateTimeFormatter.ofPattern("MMMM d, yyyy"); //formating our date
                    deadlineLable.setText(df.format(item.getDeadline()));
                }
            }
        });

        //Initializing Predicate in initializing method for our Controller
        wantAllItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return true;
            }
        };

        //Initializing Predicate in initializing method for our Controller
        wantTodaysItems = new Predicate<TodoItem>() {
            @Override
            public boolean test(TodoItem item) {
                return (item.getDeadline().equals(LocalDate.now()));
            }
        };

        /* The filteredList will call the test method for every item in the list that has been passed to do it*/
        filteredList = new FilteredList<TodoItem>(TodoData.getInstance().getTodoItems(), wantAllItems);

        //Compare our SortedList<TodoItems> and sorting them by deadline (Date)
        SortedList<TodoItem> sortedList = new SortedList<TodoItem>(filteredList,
                new Comparator<TodoItem>() {
                    @Override //we pass the to-do items to be compared as the parameter o1 and o2. So this has to return a negative value if
                    //object o1 is considered to be less than o2. So it must return 0 if the 2 objects are considered to be equal and then it
                    //must also return a positive value if  object o1 is considered to be grater than o2.
                    public int compare(TodoItem o1, TodoItem o2) { //o1 nad o2 our TodoItem drop objects and we want to compare their deadline values
                        return o1.getDeadline().compareTo(o2.getDeadline());
                    }
                });


//        todoListView.setItems(TodoData.getInstance().getTodoItems()); //Populating our ListView with items that we  added in ArrayList
        todoListView.setItems(sortedList); // Setting our Items in to a order list(By Date)

        todoListView.getSelectionModel().setSelectionMode(SelectionMode.SINGLE); //set the ListView selection mode to single selection. We can select only one item at a time

        todoListView.getSelectionModel().selectFirst(); //selectFirst - is a method which is selecting very first item in the TodoList

        /* Created callback method for us automatically and all we really need to is to update it, so we need to add some code in here.*/
        todoListView.setCellFactory(new Callback<ListView<TodoItem>, ListCell<TodoItem>>() {
            @Override
            public ListCell<TodoItem> call(ListView<TodoItem> param) {
                ListCell<TodoItem> cell = new ListCell<TodoItem>() {
                    /* In the code we've set to cellfactory by calling the listviews setCellfactory() method and we pass an anonymous class that
                    implements the callback interface. Now this interface is part of the JavaFX API and the interface itself has got 2 type parameters.
                    The first parameter is the type of argument provided by the call() method and that's a single method within the interface. In our case
                    we are passing it the ListView controller as you can see on the screen.
                    The second parameters is the types that its gonna be returned from the call method in our case an instance of the class list cell is
                    gonna be returned, you can see we returning that cell on line 93. We also used generics to be more specific about what type
                    of objects the ListView cell will contain hence the use of TodoItem which you've seen on line 78 - 79. We've also used an
                    anonymous class to create our list cell instaces and we are overriding the update items as you can see in the listCell class
                    and that methods can run whenever the ListView wants to paint a single cell. So our call method is gonna return the cell instance that
                    we created and the list view will used that instance to paint the cell. As a result this allows us to paint every cell based on the
                    TodoItem that it contained.*/
                    @Override
                    protected void updateItem(TodoItem item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setText(null);
                        } else {
                            setText(item.getShortDescription());
                            if (item.getDeadline().isBefore(LocalDate.now().plusDays(1))) { // testing for now is to see whether there's a date a deadline and that date is before the current to today+1 so it has to be earlier than tomorrow
                                setTextFill(Color.RED);
                            } else if (item.getDeadline().equals(LocalDate.now().plusDays(1))) {
                                setTextFill(Color.BROWN);
                            }
                        }

                    }
                };

                cell.emptyProperty().addListener( //using anonymus function or lambda expression
                        (obs, wasEmpty, isNowEmpty) -> {
                            if (isNowEmpty) {
                                cell.setContextMenu(null); //turn it off
                            } else {
                                cell.setContextMenu(listContextMenu);
                            }
                        });

                return cell;
            }
        });


    }

    @FXML
    public void showNewItemDialog() {
        /* We want this dialogue to be modul and what that means is that while the dialoguie is visible the users won't be able to interact
        with any other part of the applications UI. In other words they won't be able to interact with dialogue while its open if they click
        on the main window to give it focus, nothing will happen so they will have to dismiss the dialogue by clicking the ok or cancel button or
        by clicking the close button in the upper right hand corner of the dialogue before they can ultimately interact with the main window again.
        And by default when we created dialoguie using this dialogue class, the dialogue will be modul so it's not something you need to
        change by the default and most of the times you will want a dialogue box to be modul. So what we want to do is we want to assign and
        ID to the border pane in the main window FXML so that we can access it
         */
        Dialog<ButtonType> dialog = new Dialog<>();
        dialog.initOwner(mainBorderPane.getScene().getWindow());
        dialog.setTitle("Add New Todo Item");
        dialog.setHeaderText("Use this dialog to create a new todo item");
        FXMLLoader fxmlLoader = new FXMLLoader();
        fxmlLoader.setLocation(getClass().getResource("todoItemDialog.fxml"));

        //the load method can throw an IOException so we need to catch that so put that code in
        try {
            dialog.getDialogPane().setContent(fxmlLoader.load());

        } catch (IOException e) {
            System.out.println("Couldn't load the dialog");
            e.printStackTrace();
            return;
        }

        dialog.getDialogPane().getButtonTypes().add(ButtonType.OK);
        dialog.getDialogPane().getButtonTypes().add(ButtonType.CANCEL);

        Optional<ButtonType> result = dialog.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            DialogController controller = fxmlLoader.getController();
            TodoItem newItem = controller.processResults();
//            todoListView.getItems().setAll(TodoData.getInstance().getTodoItems()); //replace the contents with whatever is comming back from our data, the singleton the list of all our TodoItems
            todoListView.getSelectionModel().select(newItem);
        }
    }

    /* Delete items with Delete keyword*/
    @FXML
    public void handleKeyPressed(KeyEvent keyEvent) {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if(selectedItem != null) {
            if(keyEvent.getCode().equals(KeyCode.DELETE)) { //If they have pressed it so we have determine that we got a valid selected item
                deleteItem(selectedItem); //and they have pressed the delte key we confirm that
            }
        }
    }



    /* In terms of functionality when the user selects an item TodoItem in the List we want to show its details in that text area that we
    just added to our interface so we went ahead with the mouse click, so we gonna do is add our handleClickListView event handler to the
    controller the we could have more than one control in a window that wants to handle mouse clicks, so we are going include something in
    the method name that identifies which control this event handlers is for */
    @FXML
    public void handleClickListView() {
        /* How do we get the selected item? Well JavaFx control displays many items are backed by a selectionmodel and that's a class that
        tracks which item is selected in the controller. So we have to get the selected item for the SelectionModel, so to do that we call
        getSelectionMode which we started using on line 47, but then we call getSelectedItem to retrieve the current item or the selected
        item from the model so we will start up by just doing just that. */
        TodoItem item = todoListView.getSelectionModel().getSelectedItem();//need to get to getSelectedItem and that is going to return the todoItem object that is at that position in the ListView
        itemDetailsTextArea.setText(item.getDetails());
        deadlineLable.setText(item.getDeadline().toString());
//        System.out.println("The selected item is " + item); // is showing in console which item was choose
        /* Now that we have done that we want to change the mouse click handling so that instead of writing to the console we are gonna
        add the details and the deadline to the text area and in the handleClick live view method.
        We'll add the details to a StringBuilder apped 4 new lines to give some space between it and the deadline and then append the string
        due to show sort of date due and of course the deadline. */
//        StringBuilder sb = new StringBuilder(item.getDetails());//StringBuilder objects are like String objects, except that they can be modified. Internally, these objects are treated like variable-length arrays that contain a sequence of characters. At any point, the length and content of the sequence can be changed through method invocations.
//        sb.append("\n\n\n\n"); // making 4 lines of space
//        sb.append("Due: "); //adding text Due which will be in line with our deadline
//        sb.append(item.getDeadline().toString()); //append to the line our Deadline thru String representation of the Date
//        itemDetailsTextArea.setText(sb.toString());// adding to our TextArea everything that we appended to our sb

    }


    public void deleteItem(TodoItem item) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION); //will pop ap an alert that will ask the user for confirmation

        alert.setTitle("Delete Todo Item");
        alert.setHeaderText("Delete item " + item.getShortDescription());
        alert.setContentText("Are you sure? Press OK to confirm, or Cancel to Back Out");

        Optional<ButtonType> result = alert.showAndWait();

        if ((result.isPresent() && (result.get() == ButtonType.OK))) {
            TodoData.getInstance().deleteTodoItem(item);

        }

    }

    @FXML
    public void handleFilterButton() {
        TodoItem selectedItem = todoListView.getSelectionModel().getSelectedItem();
        if(filterToogleButton.isSelected()) {
            filteredList.setPredicate(wantTodaysItems);
            if(filteredList.isEmpty()) {
                itemDetailsTextArea.clear();
                deadlineLable.setText("");
            } else if (filteredList.contains(selectedItem)) {
                todoListView.getSelectionModel().select(selectedItem);
            } else {
                todoListView.getSelectionModel().selectFirst();
            }
        } else {
            filteredList.setPredicate(wantAllItems);
            todoListView.getSelectionModel().select(selectedItem); //that in the case showing all our items or turning the filter off in other words
        }
    }

    @FXML
    public void handleExit() {
        Platform.exit();
    }


}
