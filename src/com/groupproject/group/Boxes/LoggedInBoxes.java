package com.groupproject.group.Boxes;

import com.groupproject.group.Model.Account;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

/** This class contains static methods for displaying windows for when a user is logged in */
public class LoggedInBoxes {
    /** Displays a settings window for an account that is passed in */
    public static void displaySettings(Account account){
        Stage window = new Stage();

        // Objects
        TextArea displayArea = new TextArea();
        displayArea.setText("Username: " + account.getUsername() + "\n" +
                "First name: " + account.getFirstName() + "\n" +
                "Last name: " + account.getLastName() + "\n" +
                "Age: " + account.getAge() + "\n" +
                "Tier");

        // Events

        /* Layouts */
        // CENTER layout
        GridPane centerLayout = new GridPane();
        // Set the horizontal and vertical gaps
        centerLayout.setHgap(20);
        centerLayout.setVgap(20);
        // center the layout in the center of the screen
        centerLayout.setAlignment(Pos.CENTER);
        // TODO: Set the constraints
        // TODO: Add the objects to the layout
        // MAIN layout
        BorderPane mainLayout = new BorderPane();

        // Scene
        Scene mainScene = new Scene(mainLayout, 600, 400);

        // Window options
        window.setTitle("Settings for " + account.getUsername());
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();
    }
}
