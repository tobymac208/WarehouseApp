package com.groupproject.nik;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * Authors: Nik, Scott, Joe
 * Date created: 02/11/2018
 * Description:
 */

public class Main extends Application {
    // Change these values to change the window's values
    private String windowTitle = "Login";
    private final int WIDTH = 600; // sets the window's width
    private final int HEIGHT = 400; // sets the window's height

    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage){
        // Objects for the scene
        // TODO: Place objects here
        // NOTE: All objects placed here are for a skeleton setup, and should be modified for a better user experience

        // Username objects
        Label usernameLabel = new Label("Username:");
        TextField usernameField = new TextField();
        // Password objects
        Label passwordLabel = new Label("Password:");
        PasswordField passwordField = new PasswordField();
        // Submit button
        Button login = new Button("Login");

        // Events -- the place to add new functionality when the user clicks an object
        // TODO: Hook up functionality for logging in :: Required component: An account Model for holding user info

        // Layout -- the place to put all of the objects
        BorderPane layout = new BorderPane();

        // Main stage options
        // set the window's title
        stage.setTitle(windowTitle);
    }
}
