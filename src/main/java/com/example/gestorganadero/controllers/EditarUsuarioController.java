package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

/**
 * Clase controlador que extiende App para la vista de edición de usuario
 */
public class EditarUsuarioController extends App {
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

    /**
     * @Metodo Botón que guarda los cambios
     * @throws IOException
     */
    @FXML
    private void btnSave() throws IOException {
        App.setRoot("ganaderia");
    }

    /**
     * @Metodo Link para volver a la vista de Ganaderia
     * @throws IOException
     */
    @FXML
    private void  linkVolver() throws IOException {
        App.setRoot("ganaderia");
    }
}
