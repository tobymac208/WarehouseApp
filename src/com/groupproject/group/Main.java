package com.groupproject.group;

import com.groupproject.group.Boxes.DisplayViewBox;
import com.groupproject.group.Boxes.LoggedInBoxes;
import com.groupproject.group.Model.Account;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/*
 * Authors: Nik, Joe, Scott
 * Date created: 02/11/2018
 * Description: This program allows a user with an account to manage day-to-day operations of a warehouse
 * Author of this class: Nik
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

    /* Author Nik */
    public void start(Stage stage){
        accountsList = new AccountsList();
        // Add items to the accounts list
        accountsList.addAccount(new Account("root", "root", "root", "password", 1000, Account.ADMIN_LEVEL));
        accountsList.addAccount(new Account("Mike", "Johnson", "mike_account", "mikes123", 22, Account.FIRST_LEVEL));

        // Objects for the scene
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
        // Error label
        Label errorLabel = new Label("");

        // Events -- the place to add new functionality when the user clicks an object
        stage.setOnCloseRequest(event -> stage.close()); // tells the window to close completely when you hit the X (quit) button
        login.setOnAction(event -> {
            // Check what's in the username field and password field
            if( !(usernameField.getText().equals("")) || !(passwordField.getText().equals("")) ){ // if the fields are not empty
                Account checkerAccount = accountsList.findByUsername(usernameField.getText());
                if(checkerAccount != null){ // if an account was found
                    // check if the password matches
                    if(checkerAccount.getPassword().equals(passwordField.getText())){
                        // open window for displaying settings
                        errorLabel.setStyle("-fx-text-fill: green");
                        errorLabel.setText("Account logged in.");
                        LoggedInBoxes.displaySettings(checkerAccount);
                        // after this method returns, update account that was possibly changed
                    } else{ // no password found
                        // display an error message
                        errorLabel.setStyle("-fx-text-fill: red");
                        errorLabel.setText("Incorrect password.");
                    }
                }else{ // no username found
                    // display an error message
                    errorLabel.setStyle("-fx-text-fill: red");
                    errorLabel.setText("Username not found.");
                }
            }else{
                // display an error message
                errorLabel.setStyle("-fx-text-fill: red");
                errorLabel.setText("You must enter text into both fields.");
            }
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
        GridPane.setConstraints(errorLabel, 0, 3);
        centerLayout.getChildren().setAll(usernameField, usernameLabel, passwordField, passwordLabel, login, errorLabel); // adds all of the objects to the GridPane
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

    /** Method that reads in from the login-data file
     * Author: Nik */
    private static AccountsList loadInAccounts(){
        // An accounts list to populate
        AccountsList list = new AccountsList();
        File file = new File("/com/groupproject/group/Resources/login-data.txt");
        // A scanner to read in data from the login-data.txt file
        try { // exception handling, in case of the file not being found
            Scanner fileReader = new Scanner(file);
            while(fileReader.hasNextLine()){ // check if there is still a line to read
                String currentLine = fileReader.nextLine(); // reads in the current line, stores it in the variable
                // split the string into multiple parts
                String[] parts = currentLine.split(", "); // reads in every element split by a comma-space combination
                String firstName, lastName, username, password; // creates strings to use for storing each member variable
                for(int i = 0, length = parts.length; i < length; i++){ // a loop that runs through each member variable of the current account and initializes them to what was read in

                }
            }
        }catch(FileNotFoundException e){
            System.out.println("File not found!");
        }
        return list;
    }
}
