package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import com.example.gestorganadero.dao.AnimalDAO;
import com.example.gestorganadero.dao.CorralDAO;
import com.example.gestorganadero.domain.Animal;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;

public class AddAnimalController extends App {
    @FXML
    private Label labelError;
    @FXML
    private TextField crotal;
    @FXML
    private TextField madre;
    @FXML
    private TextField padre;
    @FXML
    private TextField edad;
    @FXML
    private TextField lactancia;
    @FXML
    private TextField vacuna;
    @FXML
    private TextField numHijos;
    @FXML
    private TextField sexo;
    @FXML
    private TextField corral;
    @FXML
    private Label linkVolver;
    @FXML
    private Button btnSave;

    private AnimalDAO adao;

    @FXML
    private void btnSave() throws IOException {
        if (crotal.getText().isEmpty() || madre.getText().isEmpty() || padre.getText().isEmpty()
                || edad.getText().isEmpty() || lactancia.getText().isEmpty() || vacuna.getText().isEmpty()
                || numHijos.getText().isEmpty() || sexo.getText().isEmpty() || corral.getText().isEmpty()) {
            labelError.setText("Se deben completar todos los campos");
            labelError.setTextFill(Color.RED);
        } else {
            adao = new AnimalDAO();
            Animal animal = new Animal();

            animal.setCrotal(Integer.parseInt(crotal.getText()));
            //animal.setMadre(madre.getText());
            //animal.setPadre(Integer.parseInt(crotal.getText()));
            animal.setEdad(Integer.parseInt(edad.getText()));
            animal.setCrotal(Integer.parseInt(lactancia.getText()));
            animal.setVacuna(vacuna.getText());
            animal.setHijos(Integer.parseInt((numHijos.getText())));
            animal.setSexo(sexo.getText());
            //animal.setCorral(corral.getText());
        }
    }

    @FXML
    private void  linkVolver() throws IOException {
        App.setRoot("animal");
    }
}