package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class Login extends App {
    @FXML
    private Button btn_login;

    @FXML
    private Label labelUser;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    @FXML
    private void btnLoginValidate() throws IOException { //Controlador de usuario y contraseña
        if (userField.getText().equals("admin") && passField.getText().equals("admin")){
            labelUser.setText("¡Usuario y contraseñas correctos!");
            labelUser.setTextFill(Color.GREEN);
            App.setRoot("ganadero");
        }else {
            if (userField.getText().equals("user") && passField.getText().equals("user")){
                App.setRoot("users");
            } else {
                labelUser.setText("¡Usuario o contraseña invalidos!");
                labelUser.setTextFill(Color.RED);
            }
        }
    }
}
