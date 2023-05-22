package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

/**\
 * Clase controller Login que extiende App
 */
public class Login extends App {
    @FXML
    private Button btn_login;

    @FXML
    private Label labelUser;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    /**
     * @Metodo Valida usuario y contraseña para que en caso de que no sea admin admin
     * no se pueda accedera a la App
     * @throws IOException
     */
    @FXML
    private void btnLoginValidate() throws IOException { //Controlador de usuario y contraseña
        if (userField.getText().equals("admin") && passField.getText().equals("admin")){
            labelUser.setText("¡Usuario y contraseñas correctos!");
            labelUser.setTextFill(Color.GREEN);
            App.setRoot("ganaderia");
        }else {
            if (userField.getText().equals("user") && passField.getText().equals("user")){
                App.setRoot("veterinaria");
            } else {
                labelUser.setText("¡Usuario o contraseña invalidos!");
                labelUser.setTextFill(Color.RED);
            }
        }
    }
}
