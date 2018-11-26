package sample;
/* */

/*
            Overview
 - JavaFax was designed with the MVC or Model-View-Controller, pattern in mind. In a nutshell, this pattern keeps the code that handles an applicatipn's
data separate form the UI code\

- Because of this, when we're using th MVC pattern, we wouldn't mix the code that deals with the UI and code that manipulates the application
data in the same class. The controller is sort of the middleman between the UI and the data.

- When working with JavaFX, the model corresponds to the application's data model, the view is the FXML, and the controller is the code that
determines what happens when a user interacts with the UI. Essentially the controller handles events, which we'll cover in a later lesson.
 */

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/*
        Line code 35
Application comes from javafx.application. Application must have a class that extends this application class and this class will be entry
point for the application.

The application class manages the lifecycle of a JavaFX. The methods in the application class that we really care most
about are the init method, start method and a stop method. When we run the application, application.launch will be called from the main method.
This method launcehs the JavaFX application and doesn't return until the application has exited.
- When a JavaFX application is launched the init method
run first. In the application class, this method is empty so unless we override it, it won't do anything.
- The start method runs right after the init method. We have to override this class because start is an abstract method in the application class.
- When the application finishes which usually happens because the users closed the applications main window, the stop method runs just like
the init method. This method is empty in the application class so unless we override it, it won't do anything.
 */
public class Main extends Application {

    @Override
    /*
     Line code 47:
    "Stage" parameter is a top-level JavaFX container that extends the window class, so essentialy it's a main window. The JavaFX runtime constructs
    the initial stage and passes it into the start method. We can't create other stages, but most applications will only  have one top-level
    window. To many windows can lead to a bad UX.

    In this version of JavaFX, Dialogues are presented within a stage but we don't explicitly create the stage. We use the dialog class which
    wraps the dialogue into a stage forest.
     */
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml")); //That loads the UI from the FXML file, and all the UI bojects defined in the file are constructed.
        primaryStage.setTitle("Hello World"); /* We set the title of the stage. Since the window class is the parent of the stage,
        this essentially means that the window title will be set to in this case "Hello World"*/
        primaryStage.setScene(new Scene(root, 300, 275)); /* We're setting the stage as Scene. Each stage requires a scene and
        backing each scene is a scene  graph a tree which each node correspnds to a UI control or an area of the scene.
            When we load at the FXML we assing it to a variable of type parent with the name root. The parent class descends directly from the node
        class which is in taking this from the Java.the base class for scene graph nodes. Nodes that descend from parent can
        have children in the scene graph.
            Now for the Hellow World application top-level and in fact only node is the GridPane. So the GridPane node will be the root of the scene graph
        and that's what was returned from the FXMLLoader on line 50.
            When we construct the scene we have to pass in the root of the scene graph that will back the scene which we do here. We are also
            setting the width and height of the scene which in turn will become the width and height of the main window.*/
        primaryStage.show();
    }


    /*
    At this point we've instantiated all the UI bojects associated with our scene and we've set the stage so we're ready now to show the
    UI and we do this by calling the show method on our stage and we're doing that  on line 62.
        From the code on the FXML file we know that when we run the  application we should see an empty with a title Hello World.
        The stage cast provides all the window decorations such as close, resize and the minimize button.
    */
    public static void main(String[] args) {
        launch(args);
    }
}
