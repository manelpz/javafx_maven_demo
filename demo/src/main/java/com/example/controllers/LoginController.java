package com.example.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginController {

    @FXML
    private TextField txtUsuario;

    @FXML
    private PasswordField txtPassword;

    @FXML
    private Label lblMensaje;

    @FXML
    private void onLogin() {
        String usuario = txtUsuario.getText().trim();
        String password = txtPassword.getText();

        if (usuario.isEmpty() || password.isEmpty()) {
            lblMensaje.setText("Escribe usuario y contraseña");
            return;
        }

        // TODO: validar contra la base de datos MySQL
        lblMensaje.setStyle("-fx-text-fill: #27ae60;");
        lblMensaje.setText("Bienvenido, " + usuario);
    }
}
