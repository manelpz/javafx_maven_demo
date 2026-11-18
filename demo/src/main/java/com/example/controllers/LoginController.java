package com.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class LoginController {


    @FXML 
    private TextField usernameField;

    @FXML
    private TextField passwordField;

    @FXML 
    private  Button buttonLogin;


    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();


        System.out.println("Username: " + username);
        System.out.println("Password: " + password);
    }



}
