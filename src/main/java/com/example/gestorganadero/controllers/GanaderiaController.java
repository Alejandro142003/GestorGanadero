package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import com.example.gestorganadero.dao.GanaderiaDAO;
import com.example.gestorganadero.dao.GanaderoDAO;
import com.example.gestorganadero.domain.Corral;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Clase controlador de animal que extiende App e implementa Initializable
 */
public class GanaderiaController extends App implements Initializable {
    @FXML
    private TableView<Ganadero> tbGanaderos;
    @FXML
    private TableColumn<Ganadero, Integer> colIdGanadero;
    @FXML
    private TableColumn<Ganadero, String> colDni;
    @FXML
    private TableColumn<Ganadero, String> colNombreGanadero;
    @FXML
    private TableColumn<Ganadero, String> colApellidos;
    @FXML
    private TableColumn<Ganadero, Integer> colTelefono;
    @FXML
    private TableColumn<Ganadero, String> colPassword;
    @FXML
    private TableView<Ganaderia> tbGanaderias;
    @FXML
    private TableColumn<Ganaderia, String> colRega;
    @FXML
    private TableColumn<Ganaderia, String> colNombreGanaderia;
    @FXML
    private TableColumn<Ganaderia, String> colSiglas;
    @FXML
    private TableColumn<Ganaderia, String> colLocalidad;
    @FXML
    private TableColumn<Ganaderia, String> colProvincia;
    @FXML
    private TableColumn<Ganaderia, String> colTitular;
    @FXML
    private TableColumn<Ganaderia, Integer> colCenso;
    @FXML
    private TableColumn<Ganaderia, String> colSistema;
    @FXML
    private TableColumn<Ganaderia, Integer> colAge;
    @FXML
    private TableColumn<Ganaderia, String> colGanadero;
    @FXML
    private Label username;
    @FXML
    private Label asociacion;

    private GanaderoDAO gdao;
    private GanaderiaDAO ganaderiadao;
    private LoginController loginController = new LoginController();
    private Ganadero currentUser = loginController.getCurrentUser();
    private Ganaderia currentEntity = loginController.getCurrentEntity();

    //Creacion de las observableList para la tablas
    private ObservableList<Ganadero> listaGanaderos;
    private ObservableList<Ganaderia> listaGanaderias;

    /**
     * @param url
     * @param resourceBundle
     * @Metodo Initialize para cargar los datos de la vista
     */
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Lógica de inicialización del controlador
        gdao = new GanaderoDAO();
        ganaderiadao = new GanaderiaDAO();

        // Obtener la ganaderia
        com.example.gestorganadero.domain.Ganaderia ganaderia;
        try{
            ganaderia = ganaderiadao.findById(currentEntity.getRega());
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        // Establecer nombre y usuarios en el label
        username.setText(currentUser.getNombre() + " " + currentUser.getApellidos());

        // Establecer nombre y siglas en el label
        asociacion.setText(currentEntity.getNombre() + " " + currentEntity.getSiglas());

        // Crear una ObservableList a partir de la lista de ganaderos y ganaderias
        listaGanaderos = FXCollections.observableArrayList();
        listaGanaderias = FXCollections.observableArrayList();

        // Configurar la tabla ganaderos y sus columnas
        colIdGanadero.setCellValueFactory(new PropertyValueFactory<>("IdGanadero"));
        colDni.setCellValueFactory(new PropertyValueFactory<>("Dni"));
        colNombreGanadero.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("Apellidos"));
        colTelefono.setCellValueFactory(new PropertyValueFactory<>("Telefono"));
        colPassword.setCellValueFactory(new PropertyValueFactory<>("Password"));

        // Configurar la tabla ganaderias y sus columnas
        colRega.setCellValueFactory(new PropertyValueFactory<>("Rega"));
        colNombreGanaderia.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colSiglas.setCellValueFactory(new PropertyValueFactory<>("Siglas"));
        colLocalidad.setCellValueFactory(new PropertyValueFactory<>("Localidad"));
        colProvincia.setCellValueFactory(new PropertyValueFactory<>("Provincia"));
        colTitular.setCellValueFactory(new PropertyValueFactory<>("Titular"));
        colCenso.setCellValueFactory(new PropertyValueFactory<>("CensoTotal"));
        colSistema.setCellValueFactory(new PropertyValueFactory<>("SistemaExplotacion"));
        colAge.setCellValueFactory(new PropertyValueFactory<>("Age"));
        colGanadero.setCellValueFactory(new PropertyValueFactory<>("Ganadero"));

        // Asignar la lista de ganaderos a la tabla
        List<Ganadero> aux = new ArrayList<>();
        try {
            aux = gdao.findAll(); //Ver como añdir la ganaderia aquí para hacer un ganaderia.getNombre
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        listaGanaderos.setAll(aux);
        tbGanaderos.setItems(listaGanaderos);

        // Asignar la lista de ganaderias a la tabla
        List<Ganaderia> aux1 = new ArrayList<>();
        try {
            aux1 = ganaderiadao.findAll(); //Ver como añdir la ganaderia aquí para hacer un ganaderia.getNombre
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        listaGanaderias.setAll(aux1);
        tbGanaderias.setItems(listaGanaderias);

        // Configurar el evento de selección de la tabla Ganaderos
        tbGanaderos.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Actualizar la vista de detalles con los datos del ganadero seleccionado
                Ganadero ganaderoSeleccionado = tbGanaderos.getSelectionModel().getSelectedItem();
            }
        });

        // Configurar el evento de selección de la tabla Ganaderias
        tbGanaderias.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Actualizar la vista de detalles con los datos de la ganaderia seleccionado
                Ganaderia ganaderiaSeleccionada = tbGanaderias.getSelectionModel().getSelectedItem();
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
    private void btnAnimal() throws IOException {
        App.setRoot("animal");
    }
}
