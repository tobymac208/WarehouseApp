package com.groupproject.group.Boxes;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

/*
 * Description: This class is a generic Box class for a allowing someone to see a list of information
 * Created: 02/15/2018
 */
public class DisplayViewBox {
    private static String windowTitle;
    private static Stage window;
    /** This method opens a new window that allows a user to see a bunch of populated information on the screen.
     * Pass in a a list of labels and descriptions (parallel arrays), to have them populate on the screen */
    public static void display(String title, ArrayList<String> labels, ArrayList<String> descriptions){
        // check if the labels and descriptions list have the same amount of items to avoid problems
        if(labels.size() != descriptions.size()){
            System.out.println("ArrayLists MUST have the same amount of objects for both. Cannot open window!");
        }
        else{ // show and populate the screen
            windowTitle = title; // Change this to change the title of the window
            // Create the new window
            window = new Stage();

            /* Scene options */
            /* Objects */
            /* Add labels to the list view */
            ListView<String> labelListView = new ListView<>();
            // run a for-each loop to populate the listView
            for(String currentString : labels){ // adds the current string to the listView
                labelListView.getItems().add(currentString); // adds the current string into the listView
            }

            // TextArea object for display the current description for the current item
            TextArea descriptionArea = new TextArea("");

            // Events
            // listener for when the user clicks on the items of the listView, since clicking doesn't trigger an event
            labelListView.getSelectionModel().selectedItemProperty().addListener((model, oldVal, newVal) -> {
                // Get the index of the item clicked
                int index = labelListView.getSelectionModel().getSelectedIndex();
                // analyze the index and set the TextArea at the bottom with the corresponding text of the field selected -- this is where parallel arrays come into play
                String currentInfo = descriptions.get(index);
                // set the TextArea with the currentInfo that was retrieved from seeing which index was selected
                descriptionArea.setText(currentInfo);
            });

            // Layout -- Creates a layout, sets the spacing in the constructor, sets the alignment, and then adds the two objects to the layout
            VBox layout = new VBox(20);
            layout.setAlignment(Pos.CENTER);
            layout.getChildren().addAll(labelListView, descriptionArea); // add the listView and the textArea to the screen

            // Scene -- Creates a scene, and then sets the layout to use and the width and height of the window
            Scene mainScene = new Scene(layout, 600, 400);

            // Window options
            window.setTitle(windowTitle); // sets the title of the window
            window.setScene(mainScene);
            window.initModality(Modality.APPLICATION_MODAL); // this restricts users from clicking on another window until this one is closed
            window.showAndWait(); // call this method for every window that isn't the main login screen
        } // end of else
    } // end of display()
} // end of class DisplayViewBox
