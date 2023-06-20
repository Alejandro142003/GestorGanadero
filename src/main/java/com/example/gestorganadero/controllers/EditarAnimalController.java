package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import com.example.gestorganadero.dao.AnimalDAO;
import com.example.gestorganadero.domain.Animal;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditarAnimalController extends App implements Initializable,IController {
    @FXML
    private TextField lactancia;
    @FXML
    private TextField edad;
    @FXML
    private TextField vacuna;
    @FXML
    private TextField numHijos;
    @FXML
    private TextField sexo;
    @FXML
    private TextField corral;
    @FXML
    private Button btnSave;
    @FXML
    private Label link_volver;
    @FXML
    private Label labelError;

    private AnimalDAO adao;
    private Animal animalSeleccionado = null;
    private Animal animal = new Animal();

    @Override
    public void setParam(Object o) {
        this.animalSeleccionado = (Animal) o;
    }

    @Override
    public void start() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //Lógica de inicialización del controlador
        adao = new AnimalDAO();
        /*String crotal = String.valueOf(animalSeleccionado.getCrotal()); //Buscar forma de obtener el Id

        // Obtener el corral
        try {
            animal = adao.findById(crotal);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Mostrar los datos del corral
        lactancia.setText(String.valueOf(animalSeleccionado.getLactancia()));
        edad.setText(String.valueOf(animalSeleccionado.getEdad()));
        vacuna.setText(String.valueOf(animalSeleccionado.getVacuna()));
        numHijos.setText(String.valueOf(animalSeleccionado.getHijos()));
        sexo.setText(animalSeleccionado.getSexo());
        corral.setText(String.valueOf(animalSeleccionado.getCorral()));
    }

    @FXML
    private void btnSave() throws IOException {
        animal.setLactancia(Float.parseFloat(lactancia.getText()));
        animal.setEdad(Integer.parseInt(edad.getText()));
        animal.setVacuna(vacuna.getText());
        animal.setHijos(Integer.parseInt(numHijos.getText()));
        animal.setSexo(sexo.getText());
        //animal.setCorral(corral.getText());

        try {
            adao.save(animal);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        App.setRoot("animal");*/
    }

    @FXML
    private void linkVolver() throws IOException {
        App.setRoot("animal");
    }
}