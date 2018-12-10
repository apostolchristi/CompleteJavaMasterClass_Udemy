package com.timbuchalka.todolist;

import com.timbuchalka.todolist.datamodel.TodoData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainwindow.fxml"));
        primaryStage.setTitle("Todo List");
        primaryStage.setScene(new Scene(root, 900 , 500));
        primaryStage.show();
    }



    public static void main(String[] args) {
        launch(args);
    }

    /* Want to try and store our items. We need to run this once and we are going to store the items that are hard coded in our controller.
    We're going to run this once closed down the program which will then invoke the stop() method in main.java and we go to write the data out.
    So that our data is now in a text file which ultimately we can start accessing in future.*/
    @Override
    public void stop() throws Exception {
        try {
            TodoData.getInstance().storeTodoItems(); //getInstance() = that get our Singelton instance. storeTodoItems() = that is going to save the data to the textfile

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void init() throws Exception {
        try {
            TodoData.getInstance().loadTodoItems(); //getInstance() = that get our Singelton instance. loadTodoItems() = that is going to load the data from the textfile

        }catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
