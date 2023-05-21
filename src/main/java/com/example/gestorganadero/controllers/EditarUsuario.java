package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

public class EditarUsuario extends App {
    @FXML
    private TextField Nombre;
    @FXML
    private TextField Apellidos;
    @FXML
    private TextField Telefono;
    @FXML
    private PasswordField passwd;
    @FXML
    private PasswordField passwdconf;
    @FXML
    private Button btn_save;
    @FXML
    private Label link_volver;

    @FXML
    private void btnSave() throws IOException {
        App.setRoot("ganaderia");
    }

    @FXML
    private void  linkVolver() throws IOException {
        App.setRoot("ganaderia");
    }
}
