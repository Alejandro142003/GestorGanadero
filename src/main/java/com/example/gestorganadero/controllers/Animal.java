package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import com.example.gestorganadero.connections.ConnectionMySQL;
import com.example.gestorganadero.dao.AnimalDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.List;
import java.util.ResourceBundle;

public class Animal extends App implements Initializable {
    @FXML
    private Pane btn_ganaderia;
    @FXML
    private Pane btn_corral;
    @FXML
    private Button btn_logout;
    @FXML
    private Label link_editar;

    @FXML
    private TableView<Animal> tbAnimal;

    @FXML
    private TableColumn<com.example.gestorganadero.domain.Animal, Integer> colCrotal;

    @FXML
    private TableColumn<com.example.gestorganadero.domain.Animal, Integer> colEdad;

    @FXML
    private TableColumn<com.example.gestorganadero.domain.Animal, String> colVacuna;

    @FXML
    private TableColumn<com.example.gestorganadero.domain.Animal, Float> colLactancia;

    @FXML
    private TableColumn<com.example.gestorganadero.domain.Animal, Integer> colNumeroHijos;

    @FXML
    private TableColumn<com.example.gestorganadero.domain.Animal, Integer> colMadre;

    @FXML
    private TableColumn<com.example.gestorganadero.domain.Animal, Integer> colPadre;

    @FXML
    private TableColumn<com.example.gestorganadero.domain.Animal, Integer> colSexo;

    @FXML
    private TableColumn<com.example.gestorganadero.domain.Animal, Integer> colCorral;

    private AnimalDAO adao;
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Lógica de inicialización del controlador
        Connection conn = ConnectionMySQL.getConnect();
        adao = new AnimalDAO(conn);
        // Obtener la lista de animales desde el AnimalDAO
        try {
            List<com.example.gestorganadero.domain.Animal> animales = adao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Crear una ObservableList a partir de la lista de animales
        ObservableList<Animal> listaAnimales = FXCollections.observableArrayList();

        // Configurar la tabla y sus columnas
        colCrotal.setCellValueFactory(new PropertyValueFactory<>("crotal"));
        colLactancia.setCellValueFactory(new PropertyValueFactory<>("lactancia"));
        colVacuna.setCellValueFactory(new PropertyValueFactory<>("vacuna"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));
        colNumeroHijos.setCellValueFactory(new PropertyValueFactory<>("numHijos"));
        colSexo.setCellValueFactory(new PropertyValueFactory<>("sexo"));
        colMadre.setCellValueFactory(new PropertyValueFactory<>("madre"));
        colPadre.setCellValueFactory(new PropertyValueFactory<>("padre"));
        colCorral.setCellValueFactory(new PropertyValueFactory<>("corral"));

        // Asignar la lista de animales a la tabla
        tbAnimal.setItems(listaAnimales);

        // Configurar el evento de selección de la tabla
        tbAnimal.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Actualizar la vista de detalles con los datos del animal seleccionado
                Animal animalSeleccionado = tbAnimal.getSelectionModel().getSelectedItem();
                // Lógica para mostrar los detalles del animal seleccionado en la vista correspondiente
            }
        });

        // Otros pasos de inicialización que puedas necesitar
    }

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
    private void btnGanaderia() throws IOException {
        App.setRoot("ganaderia");
    }

}
