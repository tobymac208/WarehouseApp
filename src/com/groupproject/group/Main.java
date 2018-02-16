package com.groupproject.group;

import com.groupproject.group.Boxes.DisplayViewBox;
import com.groupproject.group.Model.AccountsList;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.ArrayList;

/*
 * TODO: Enter the preferred name for what you want as your display name on here to be -- mine is my username for GitHub
 * Authors: Tobymac208, Joe, Scott
 * Date created: 02/11/2018
 * Description:
 */

public class Main extends Application {
    // Change these values to change the window's values
    private static String windowTitle = "Login";
    private final double WIDTH = 600; // sets the window's width
    private final double HEIGHT = 400; // sets the window's height
    // Create a collection of accounts
    private static AccountsList accountsList; // this will allow easier use of accounts when adding and deleting

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage){
        // Objects for the scene
        // TODO: Place objects here
        // NOTE: All objects placed here are for a skeleton setup, and should be modified for a better user experience

        // TOP objects
        Button about = new Button("About"); // about button

        // CENTER objects
        // Username objects
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        usernameField.setPromptText("Enter username");
        // Password objects
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        passwordField.setPromptText("Enter password");
        // Submit button
        Button login = new Button("Login");

        // Events -- the place to add new functionality when the user clicks an object
        stage.setOnCloseRequest(event -> stage.close()); // tells the window to close completely when you hit the X (quit) button
        // TODO: Hook up functionality for logging in :: Required component: An account Model for holding user info
        login.setOnAction(event -> {
            // open window for displaying settings
            System.out.println("Functionality needs to be created for this to work.");
        });
        about.setOnAction(event -> {
            ArrayList<String> labels = new ArrayList<>(), information = new ArrayList<>(); // creates and initializes two new ArrayList objects
            // Populate the labels list
            labels.add("What is this program?");
            // Populate the information list
            information.add("This program is for allowing a Warehouse to organize and manage its stock.");
            DisplayViewBox.display("About", labels, information); // calls the method to show the window
        });

        // Layout -- the place to put all of the objects
        BorderPane layout = new BorderPane();
        // TOP
        // Creates a horizontal box layout for the top of the window -- this includes things like Settings and Quit buttons
        HBox topLayout = new HBox(20);
        topLayout.getChildren().add(about);
        // CENTER
        GridPane centerLayout = new GridPane();
        centerLayout.setAlignment(Pos.CENTER); // SETS WHERE THE LOGIN OPTIONS ARE ALIGNED ON THE SCREEN
        centerLayout.setHgap(10); // sets the horizontal gap
        centerLayout.setVgap(10); // sets the vertical gap
        GridPane.setConstraints(usernameLabel, 0, 0); // first row, first column
        GridPane.setConstraints(usernameField, 1, 0); // first row, second column
        GridPane.setConstraints(passwordLabel, 0, 1); // second row, first column
        GridPane.setConstraints(passwordField, 1, 1); // second row, second column
        GridPane.setConstraints(login, 0, 2); // third row, first column
        centerLayout.getChildren().setAll(usernameField, usernameLabel, passwordField, passwordLabel, login); // adds all of the objects to the GridPane
        // Add the layouts to the main BorderPane layout
        layout.setTop(topLayout); // adds the TOP layout to the BorderPane
        layout.setCenter(centerLayout); // adds the CENTER layout to the BorderPane

        // Scene -- creates a scene and specifies its WIDTH and HEIGHT (these two constants can found at the top of this file, as a member variable)
        Scene mainScene = new Scene(layout, WIDTH, HEIGHT);
        mainScene.getStylesheets().add("/com/groupproject/group/Resources/master.css");

        // Main stage options
        // set the window's title
        stage.setTitle(windowTitle);
        // set the scene
        stage.setScene(mainScene);
        stage.show();
    }
}
