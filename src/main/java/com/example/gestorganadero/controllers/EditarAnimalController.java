package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import com.example.gestorganadero.dao.AnimalDAO;
import com.example.gestorganadero.domain.Animal;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import java.io.IOException;
import java.sql.SQLException;

public class EditarAnimalController extends App implements IController {
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
        adao = new AnimalDAO();
        if (animalSeleccionado!= null) {
            lactancia.setText(String.valueOf(animalSeleccionado.getLactancia()));
            edad.setText(String.valueOf(animalSeleccionado.getEdad()));
            vacuna.setText(String.valueOf(animalSeleccionado.getVacuna()));
            numHijos.setText(String.valueOf(animalSeleccionado.getHijos()));
            sexo.setText(animalSeleccionado.getSexo());
            //corral.setText(animalSeleccionado.getCorral().toString());
            //Obtener el animal
            String idAnimal = String.valueOf(animalSeleccionado.getCrotal());
            try {
                animal = adao.findById(idAnimal);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    @FXML
    private void btnSave() throws IOException, SQLException {
        animal.setLactancia(Integer.parseInt(lactancia.getText()));
        animal.setEdad(Integer.parseInt(edad.getText()));
        animal.setVacuna(vacuna.getText());
        animal.setHijos(Integer.parseInt(numHijos.getText()));
        animal.setSexo(sexo.getText());
        //Habria que poner un desplegable con los objetos corrales para asignar uno
        //animal.setCorral(Corral.valueOf(corral.getText()));
        App.setRoot("animal");
    }

    @FXML
    private void linkVolver() throws IOException {
        App.setRoot("animal");
    }
}