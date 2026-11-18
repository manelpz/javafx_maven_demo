package com.example.controllers;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

         Alert alert = new Alert(Alert.AlertType.INFORMATION);


        if ("a".equals(username) && "1".equals(password)) {
         
            FXMLLoader loader = new FXMLLoader(
                getClass().getResource("/views/menu.fxml")
            );

            
            try {
                Scene scene = new Scene(loader.load());
                Stage stage = (Stage) buttonLogin.getScene().getWindow();
                stage.setTitle("Menu principal");
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                
                e.printStackTrace();
            }
           
            
        } else {
            //System.out.println("Login failed!");
            alert.setTitle("Login Failed");
            alert.setContentText("Invalid username or password.");
            alert.showAndWait();
        }

        //System.out.println("Username: " + username);
        //System.out.println("Password: " + password);



    }



}
