package com.groupproject.group.Boxes;

import com.groupproject.group.Model.Account;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

/*
 * Description: This class contains static methods for displaying windows for when a user is logged in
 * Created: 02/18/2018
 * Author: Nik
 */

public class LoggedInBoxes {
    /** Displays a settings window for an account that is passed in */
    public static void displaySettings(Account account){
        Stage window = new Stage();

        // Objects
        // TOP
        Button logoutButton = new Button("Logout"); // logs out the user
        Button inventory = new Button("Inventory"); // opens the inventory menu
        // CENTER
        TextArea displayArea = new TextArea();
        displayArea.setEditable(false); // don't let the user edit the text area
        displayArea.setText("ACCOUNT DETAILS\n----------------------------------------------------------\n" +
                "Username: " + account.getUsername() + "\n" +
                "First name: " + account.getFirstName() + "\n" +
                "Last name: " + account.getLastName() + "\n" +
                "Age: " + account.getAge() + "\n" +
                "Tier: " + account.getTier() + "\n");
        // LEFT -- ONLY shows for admins
        Label titleLabel = new Label("Administrator Options:");
        Button addAccountButton = new Button("Create a new account");
        Button deleteAccount = new Button("Delete Account");

        // Events
        logoutButton.setOnAction(event -> window.close()); // closes this window

        /* Layouts */
        // TOP layout
        HBox topLayout = new HBox(20);
        topLayout.getChildren().addAll(logoutButton, inventory);
        // CENTER layout
        VBox centerLayout = new VBox(20);
        // center the layout in the center of the screen
        centerLayout.setAlignment(Pos.CENTER);
        // add objects to CENTER
        centerLayout.getChildren().add(displayArea);
        // LEFT layout -- admin layout
        VBox leftLayout = new VBox(20);
        leftLayout.setAlignment(Pos.CENTER);
        if(account.getTier() == 1){ // if the account is an admin
            // add the objects to the layout
            leftLayout.getChildren().addAll(titleLabel, addAccountButton, deleteAccount);
        }
        // MAIN layout
        Insets marginSize = new Insets(40);
        BorderPane mainLayout = new BorderPane();
        // set margins for each node -- spacing between each layout
        BorderPane.setMargin(topLayout, marginSize);
        BorderPane.setMargin(centerLayout, marginSize);
        BorderPane.setMargin(leftLayout, marginSize);
        // set the TOP layout
        mainLayout.setTop(topLayout);
        // set the center layout
        mainLayout.setCenter(centerLayout);
        if(account.getTier() == 1) { // if account is admin
            // set the left layout
            mainLayout.setLeft(leftLayout);
        }

        // Scene
        Scene mainScene = new Scene(mainLayout, 600, 400);
        mainScene.getStylesheets().add("/com/groupproject/group/Resources/master.css");

        // Window options
        window.setTitle("Settings for " + account.getUsername());
        window.setScene(mainScene); // sets the scene
        window.initModality(Modality.APPLICATION_MODAL);
        window.showAndWait();
    }
}
