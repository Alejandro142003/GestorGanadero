package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;

public class Ganaderia extends App {
    @FXML
    private Pane btn_animal;
    @FXML
    private Pane btn_corral;
    @FXML
    private Button btn_logout;
    @FXML
    private Label link_editar;

    @FXML
    private void btnLogout() throws IOException {
        App.setRoot("login");
    }
    @FXML
    private void linkEdit() throws IOException {
        App.setRoot("editarUsuario");
    }

    @FXML
    private void btnCorral() throws IOException {
        App.setRoot("corral");
    }

    @FXML
    private void btnAnimal() throws IOException {
        App.setRoot("animal");
    }
}
