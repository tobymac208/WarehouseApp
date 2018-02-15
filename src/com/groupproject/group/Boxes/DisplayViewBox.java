package com.groupproject.group.Boxes;

import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;

/*
 * Description: This class is a generic Box class for a allowing someone to see a list of information
 * Created: 02/15/2018
 */
public class DisplayViewBox {
    private static String windowTitle;
    /** This method opens a new window that allows a user to see a bunch of populated information on the screen.
     * Pass in a a list of labels and descriptions (parallel arrays), to have them populate on the screen */
    public static void display(String title, ArrayList<String> labels, ArrayList<String> descriptions){
        windowTitle = title; // Change this to change the title of the window
        // Create the new window
        Stage window = new Stage();

        /* Scene options */
        // Objects

        /* Add labels to the list view */
        ListView<String> labelListView = new ListView<>();
        // run a loop to populate the listView
        for(int i = 0, numberOfLabels = labels.size(); i < numberOfLabels; i++){ // gets the number of items passed in, iterating through each and sticking them in the listView
            labelListView.getItems().add(labels.get(i)); // get the string at the current location, and add it to the list view
        }

        // Events
        // listener for when the user clicks on the items of the listView, since clicking doesn't trigger an event
        labelListView.getSelectionModel().selectedItemProperty().addListener((model, oldVal, newVal) -> {
            // Get the index of the item clicked
            int index = labelListView.getSelectionModel().getSelectedIndex();
            // analyze the index and set the TextArea at the bottom with the corresponding text of the field selected -- this is where parallel arrays come into play
            String currentInfo = descriptions.get(index);
            // set the TextArea with the currentInfo that was retrieved from seeing which index was selected
            // TODO: Change the TextArea object's text to currentInfo
        });

        // Scene

        // Window options
        window.setTitle(windowTitle); // sets the title of the window
        window.initModality(Modality.APPLICATION_MODAL); // this restricts users from clicking on another window until this one is closed
        window.showAndWait(); // call this method for every window that isn't the main login screen
    }
}
