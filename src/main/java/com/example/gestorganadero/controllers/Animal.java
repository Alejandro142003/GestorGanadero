package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import com.example.gestorganadero.dao.AnimalDAO;
import com.example.gestorganadero.dao.GanaderiaDAO;
import com.example.gestorganadero.dao.GanaderoDAO;
import com.example.gestorganadero.domain.Ganaderia;
import com.example.gestorganadero.domain.Ganadero;
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

/**
 * Clase controlador de animal que extiende App e implementa Initializable
 */
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
    private Label username;
    @FXML
    private Label asociacion;
    @FXML
    private TableView<com.example.gestorganadero.domain.Animal> tbAnimal;

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
    private TableColumn<com.example.gestorganadero.domain.Animal, Integer> colCrotalMadre;

    @FXML
    private TableColumn<com.example.gestorganadero.domain.Animal, Integer> colCrotalPadre;

    @FXML
    private TableColumn<com.example.gestorganadero.domain.Animal, Integer> colSexo;

    @FXML
    private TableColumn<com.example.gestorganadero.domain.Animal, Integer> colCorral;



    private ObservableList<com.example.gestorganadero.domain.Animal> listaAnimales;

    /**
     * @param url
     * @param resourceBundle
     * @Metodo Initialize para cargar los datos de la vista
     */
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Lógica de inicialización del controlador
        AnimalDAO adao = new AnimalDAO();
        GanaderoDAO gdao = new GanaderoDAO();
        GanaderiaDAO ganaderiadao = new GanaderiaDAO();
        String ganaderoId = "1";
        String ganaderiaId = "410600000054";

        // Obtener el ganadero
        Ganadero ganadero;
        try {
            ganadero = gdao.findById(ganaderoId);
        } catch (SQLException e) {
            throw new RuntimeException("El ganadero buscado no existe");
        }

        // Obtener la ganaderia
        Ganaderia ganaderia;
        try{
            ganaderia = ganaderiadao.findById(ganaderiaId);
        } catch (SQLException e){
            throw new RuntimeException("La ganaderia buscada no existe");
        }

        // Establecer nombre y usuarios en el label
        username.setText(ganadero.getNombre() + " " + ganadero.getApellidos());

        // Establecer nombre y siglas en el label
        asociacion.setText(ganaderia.getNombre() + " " + ganaderia.getSiglas());

        // Crear una ObservableList a partir de la lista de animales
        listaAnimales = FXCollections.observableArrayList();

        // Configurar la tabla y sus columnas
        colCrotal.setCellValueFactory(new PropertyValueFactory<>("Crotal"));
        colLactancia.setCellValueFactory(new PropertyValueFactory<>("Lactancia"));
        colVacuna.setCellValueFactory(new PropertyValueFactory<>("Vacuna"));
        colEdad.setCellValueFactory(new PropertyValueFactory<>("Edad"));
        colNumeroHijos.setCellValueFactory(new PropertyValueFactory<>("NumeroHijos"));
        colSexo.setCellValueFactory(new PropertyValueFactory<>("Sexo"));
        colCrotalMadre.setCellValueFactory(new PropertyValueFactory<>("CrotalMadre"));
        colCrotalPadre.setCellValueFactory(new PropertyValueFactory<>("CrotalPadre"));
        colCorral.setCellValueFactory(new PropertyValueFactory<>("IdCorral"));

        // Asignar la lista de animales a la tabla
        List<com.example.gestorganadero.domain.Animal> aux = null;
        try {
            aux = adao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        listaAnimales.setAll(aux);
        tbAnimal.setItems(listaAnimales);

        // Configurar el evento de selección de la tabla
        tbAnimal.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Actualizar la vista de detalles con los datos del animal seleccionado
                com.example.gestorganadero.domain.Animal animalSeleccionado = tbAnimal.getSelectionModel().getSelectedItem();
            }
        });
    }

    /**
     * @Metodo Cambia a la vista de Login
     * @throws IOException
     */
    @FXML
    private void btnLogout() throws IOException {
        App.setRoot("login");
    }

    /**
     * @Metodo Cambia a la vista de edicion de usuario
     * @throws IOException
     */
    @FXML
    private void linkEdit() throws IOException {
        App.setRoot("editarUsuario");
    }

    /**
     * @Metodo Cambia a la vista de Corral
     * @throws IOException
     */
    @FXML
    private void btnCorral() throws IOException {
        App.setRoot("corral");
    }

    /**
     * @Metodo Cambia a la vista de Ganaderia
     * @throws IOException
     */
    @FXML
    private void btnGanaderia() throws IOException {
        App.setRoot("ganaderia");
    }
}