package sample;

/*
                    FileChooser
- By default filechooser initially choose shows the default file system view of the operating system, instead we want to show the last
directory the user save to or a directory that they specified perhaps in the application settings. So to have the filechooser initially
open to a specific directory method .
 */

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.GridPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;


public class Controller {

    @FXML
    private Label label;

    @FXML
    private Button button4;

    @FXML
    private GridPane gridPane;

    @FXML
    private WebView webView;


    public void initialize() {
        button4.setEffect(new DropShadow());

    }

    @FXML
    public void handleMouseEnter() { //zooming in something when mouse entering specific area of text or button
        label.setScaleX(2.0);
        label.setScaleY(2.0);
    }

    @FXML
    public void handleMouseExit() { //zooming out from something when mouse is exiting this area
        label.setScaleX(1.0);
        label.setScaleY(1.0);
    }

    @FXML
    public void handleClick() {
        FileChooser chooser = new FileChooser();//initializing filechooser

//        chooser.setTitle("Save ApplicationFile");
        chooser.getExtensionFilters().addAll( //when you wana save files it's sugets by default  to us formats that we indicated b
                new FileChooser.ExtensionFilter("Zip", "*.zip"),
                new FileChooser.ExtensionFilter("PDF", "*.pdf"),
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.png", "*.gif"),
                new FileChooser.ExtensionFilter("All Files", "*.*")
        );
//        DirectoryChooser chooser = new DirectoryChooser();
        List<File> file = chooser.showOpenMultipleDialog(gridPane.getScene().getWindow());
        if(file != null) {
            for(int i=0; i<file.size(); i++)
            System.out.println(file.get(i));
        } else {
            System.out.println("Chooser was cancelled  ");
        }


        // FileChooser - chose a file not a directory or folder
        // DirectoryChooser - choose folder & directoryies not only files
        // .showOpenDialog() - open menu to select files that we need
        // gridPane.getScene().getWindow - making our filechoser to be on the main screen and only use it without touching previous window
    }

    @FXML
    public void handleLinkClick() {
//        try {
//            Desktop.getDesktop().browse(new URI("http://www.javafx.com"));
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (URISyntaxException  e) {
//            e.printStackTrace();
//        }

        WebEngine engine = webView.getEngine(); // Make to appear in our scene a webview and by pressing link inside the app we can sufrf this link
        engine.load("http://www.javafx.com");
    }



}
