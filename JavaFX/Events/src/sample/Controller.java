package sample;
/*
getSource() - get the object which is doing that - in our case it will show what
 */

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;


public class Controller {

    @FXML
    private TextField nameField;
    @FXML
    private Button helloButton;
    @FXML
    private Button byeButton;
    @FXML
    private CheckBox ourCheckBox;
    @FXML
    private Label ourLabel;




    @FXML
    public void initialize() { //On initialization our button will be disabled
       helloButton.setDisable(false);
       byeButton.setDisable(false);
    }

    @FXML
    public void onButtonClick(ActionEvent e){ //(ActionEvent e) - use it for multi event handling and by this we will know which control was pressed
        if(e.getSource().equals(helloButton)) {
            System.out.println("Hello, " + nameField.getText());
        } else if(e.getSource().equals(byeButton)) {
            System.out.println("Bye, " + nameField.getText());
        }

        //This process is going to actually do the work of setting up and running this code in the background. its no
        //longer gonna be runnin on a UI thread, its gonna create another process virtually, another program, another instance of
        //something running in the background on your computer to do whatever processing we want, and in this case the only
        //processing we do want is to run that thread.sleep
        Runnable task = new Runnable() {
            @Override
            public void run() {
                try {
                    String s = Platform.isFxApplicationThread() ? "UI thread" : "Background Thread";
                    System.out.println("I'm going to sleep on the: " + s);
                    Thread.sleep(10000); //puting the user interface, UI thread to sleep for 10 seconds
                    //2.
                    //3
                    Platform.runLater(new Runnable() { //it's gonna force the runnable objects to run on the UI thread
                        @Override
                        public void run() {
                            String s = Platform.isFxApplicationThread() ? "UI thread" : "Background Thread";
                            System.out.println("I'm updateing the label on the: " + s);
                            ourLabel.setText("We did somthing!"); //1.

                        }
                    });

                    /* 2. - We want to obtain our label when the thread wakes up, so we are gonna set the text to our label right after thread.sleep
                    returns, so the code is gonna sit there and not do anything and when it's finished after the ten seconds then we want to update
                    our label so we can see that its actually update so */

                     /* 1. - at the moment we've now got our runnable task we've sort of declared what needs
                    to happen we've said that it's going to be sit their and pause for 10 seconds after 10 seconds it's gonna update our
                    label on the screen but what we haven't done yet is invoked it because what we need to do is actually stat it so it actually
                     start the process just like declaring a variable, declaring it is one step but using it's another one so we need to
                     actually start using it. So to actually stat this we need to come over here underneath the declaration we type  */

                     /* 3. - What we are doing here: we're actually pausing still for 10 seconds, but after that we are basically invoking the
                     command so that the actual label is gonna be updatet on the UI thread so we don't get any exceptio. So its a
                     little bit more code but essentially that's the way the JavaFX developers want us to actually update things.

                      */
                } catch (InterruptedException event) {
                    //we dont care about this
                }
            }
        };
        //that's the code to start that now so not only have we defined we've now put the code in to actually run it. So
        //we're gonna run this and we should be able to see that it will run and our UI should still be responsive and after
        //10 second have elapsed we should be able to see it automatically update the screen.
        new Thread(task).start();


        if(ourCheckBox.isSelected()) { //condition for clear the TextField
            nameField.clear();
            helloButton.setDisable(true); //disabling buttons
            byeButton.setDisable(true);
        }
    }

    /*
    We call the isEmpty() method to actually check whtehr its empty or not and we also using .trim as well so we are basically ignoring
    anyone with spaces that's why we're doing additionla tests. So if either of those is true in other words it comes back empty, in either case
    we are going to disable the buttons accordingly
     */
    @FXML
    public void handleKeyReleased() {
        String text = nameField.getText();
        boolean disableButtons = text.isEmpty() || text.trim().isEmpty();
        helloButton.setDisable(disableButtons);
        byeButton.setDisable(disableButtons);
    }

    /*
    Print at the moment wether the check box is selected into the console
     */
    public void handleChange() {
        System.out.println("The checkbox is " + (ourCheckBox.isSelected() ? "checked" : "not checked")); //.isSelected() - method to determine wheter it is selected or not
    }
}
