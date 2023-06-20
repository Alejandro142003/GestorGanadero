package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import com.example.gestorganadero.dao.CorralDAO;
import com.example.gestorganadero.dao.GanaderiaDAO;
import com.example.gestorganadero.dao.GanaderoDAO;
import com.example.gestorganadero.domain.Corral;
import com.example.gestorganadero.domain.Ganaderia;
import com.example.gestorganadero.domain.Ganadero;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Clase controlador de corral que extiende App e implementa Initializable
 */
public class CorralController extends App implements Initializable {
    @FXML
    private Label username;
    @FXML
    private Label asociacion;
    @FXML
    private TableView<Corral> tbCorral;
    @FXML
    private TableColumn<Corral, Integer> colIdCorral;
    @FXML
    private TableColumn<Corral, String> colNombre;
    @FXML
    private TableColumn<Corral, String> colTipo;
    @FXML
    private TableColumn<Corral, Integer> colCenso;
    @FXML
    private TableColumn<Ganaderia, String> colGanaderia;

    private CorralDAO cdao;
    private LoginController loginController = new LoginController();
    private GanaderoDAO gdao;
    private Ganadero currentUser = loginController.getCurrentUser();
    private Ganaderia currentEntity = loginController.getCurrentEntity();

    //Creacion de las observableList para la tabla
    private ObservableList<Corral> listaCorrales;

    /**
     * @param url
     * @param resourceBundle
     * @Metodo Initialize para cargar los datos de la vista
     */
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Lógica de inicialización del controlador
        cdao = new CorralDAO();
        gdao = new GanaderoDAO();

        //Obtener lista de ganaderias del ganadero
        try {
            List<Ganaderia> ganaderias = gdao.findGanaderias(currentUser);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Establecer nombre y usuarios en el label
        username.setText(currentUser.getNombre() + " " + currentUser.getApellidos());

        // Establecer nombre y siglas en el label
        asociacion.setText(currentEntity.getNombre() + " " + currentEntity.getSiglas());

        // Crear una ObservableList a partir de la lista de corrales
        listaCorrales = FXCollections.observableArrayList();

        // Configurar la tabla y sus columnas
        colIdCorral.setCellValueFactory(new PropertyValueFactory<>("IdCorral"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        colCenso.setCellValueFactory(new PropertyValueFactory<>("Censo"));
        colGanaderia.setCellValueFactory(new PropertyValueFactory<>("Ganaderia"));

        // Asignar la lista de corrales a la tabla
        List<Corral> aux = new ArrayList<>();
        try {
            aux = cdao.findAll(); //Ver como añdir la ganaderia aquí para hacer un ganaderia.getNombre
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        listaCorrales.setAll(aux);
        tbCorral.setItems(listaCorrales);

        // Configurar el evento de selección de la tabla
        tbCorral.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Actualizar la vista de detalles con los datos del corral seleccionado
                Corral corralSeleccionado = tbCorral.getSelectionModel().getSelectedItem();
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
     * @Metodo Cambia a la vista de ganaderia
     * @throws IOException
     */
    @FXML
    private void btnGanaderia() throws IOException {
        App.setRoot("ganaderia");
    }

    /**
     * @Metodo Cambia a la vista de animales
     * @throws IOException
     */
    @FXML
    private void btnAnimal() throws IOException {
        App.setRoot("animal");
    }

    @FXML public void addCorral() throws IOException{
        App.setRoot("addCorral");
    }

    @FXML
    public void editCorral() throws IOException {
         Corral selectedItem = tbCorral.getSelectionModel().getSelectedItem();

         if (selectedItem != null) {
             //Abrir edtiarCorralController con paso de parámetro
             App.setRootWithParams("editarCorral", selectedItem);
         }
    }

    @FXML
    public void deleteCorral() throws IOException, SQLException {
        Corral selectedItem = tbCorral.getSelectionModel().getSelectedItem();
        cdao.delete(selectedItem);
        App.setRoot("corral");
    }
}