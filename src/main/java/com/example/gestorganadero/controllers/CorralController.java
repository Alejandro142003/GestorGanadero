package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import com.example.gestorganadero.dao.CorralDAO;
import com.example.gestorganadero.dao.GanaderiaDAO;
import com.example.gestorganadero.dao.GanaderoDAO;
import com.example.gestorganadero.domain.Corral;
import com.example.gestorganadero.domain.Ganaderia;
import com.example.gestorganadero.domain.Ganadero;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;

/**
 * Clase controlador de corral que extiende App e implementa Initializable
 */
public class CorralController extends App implements Initializable {
    @FXML
    private Pane btn_ganaderia;
    @FXML
    private Pane btn_animal;
    @FXML
    private Button btn_logout;
    @FXML
    private Label link_editar;
    @FXML
    private Label username;
    @FXML
    private Label asociacion;
    @FXML
    private TableView<Pair<Corral, Ganaderia>> tbCorral;
    @FXML
    private TableColumn<Corral, Integer> colIdCorral;
    @FXML
    private TableColumn<Corral, String> colNombre;
    @FXML
    private TableColumn<Corral, String> colTipo;
    @FXML
    private TableColumn<Corral, Integer> colCenso;
    @FXML
    private TableColumn<Corral, String> colGanaderia;

    private CorralDAO adao;
    private GanaderoDAO gdao;
    private GanaderiaDAO ganaderiadao;

    //Creacion de las observableList para la tabla
    private ObservableList<Corral> listaCorrales;
    private ObservableList<Ganaderia> listaGanaderias;
    private ObservableList<Pair<Corral,Ganaderia>> listaCombinada;

    /**
     * @param url
     * @param resourceBundle
     * @Metodo Initialize para cargar los datos de la vista
     */
    @FXML
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // Lógica de inicialización del controlador
        adao = new CorralDAO();
        gdao = new GanaderoDAO();
        ganaderiadao = new GanaderiaDAO();
        String ganaderoId = "1";
        String ganaderiaId = "410600000054";

        // Obtener el ganadero
        Ganadero ganadero;
        try {
            ganadero = gdao.findById(ganaderoId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Obtener la ganaderia
        Ganaderia ganaderia;
        try{
            ganaderia = ganaderiadao.findById(ganaderiaId);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
        
        //Obtener lista de ganaderias del ganadero
        try {
            List<Ganaderia> ganaderias = gdao.findGanaderias(ganadero);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        // Establecer nombre y usuarios en el label
        username.setText(ganadero.getNombre() + " " + ganadero.getApellidos());

        // Establecer nombre y siglas en el label
        asociacion.setText(ganaderia.getNombre() + " " + ganaderia.getSiglas());

        // Crear la ObservableList para los Corrales
        listaCorrales = FXCollections.observableArrayList();
        List<Corral> auxC = null;
        try {
            auxC = adao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        listaCorrales.setAll(auxC);

        // Crear la ObservableList para las Ganaderias del ganadero
        listaGanaderias = FXCollections.observableArrayList();
        listaGanaderias.setAll(ganaderia);

        // Crear la ObservableList combinada para mostrar en la tabla
        listaCombinada = FXCollections.observableArrayList();
        for (int i = 0; i < listaCorrales.size(); i++) {
            Corral c = listaCorrales.get(i);
            Ganaderia g = listaGanaderias.get(0);
            Pair<Corral, Ganaderia> pareja = new Pair<>(c, g);
            listaCombinada.add(pareja);
        }

        // Configurar la tabla y sus columnas
        colIdCorral.setCellValueFactory(new PropertyValueFactory<>("IdCorral"));
        colNombre.setCellValueFactory(new PropertyValueFactory<>("Nombre"));
        colTipo.setCellValueFactory(new PropertyValueFactory<>("Tipo"));
        colCenso.setCellValueFactory(new PropertyValueFactory<>("Censo"));
        colGanaderia.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getGanaderia().getNombre()));

        // Asignar la lista de corrales a la tabla
        tbCorral.setItems(listaCombinada);

        // Configurar el evento de selección de la tabla
        tbCorral.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                // Actualizar la vista de detalles con los datos del corral seleccionado
                Pair<Corral, Ganaderia> corralSeleccionado = tbCorral.getSelectionModel().getSelectedItem();
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
}