package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import com.example.gestorganadero.dao.GanaderiaDAO;
import com.example.gestorganadero.dao.GanaderoDAO;
import com.example.gestorganadero.domain.Ganadero;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Clase controlador de animal que extiende App e implementa Initializable
 */
public class Ganaderia extends App implements Initializable {
    @FXML
    private Pane btn_animal;
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

    private GanaderoDAO gdao;
    private GanaderiaDAO ganaderiadao;

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
        com.example.gestorganadero.domain.Ganaderia ganaderia;
        try{
            ganaderia = ganaderiadao.findById(ganaderiaId);
        } catch (SQLException e){
            throw new RuntimeException(e);
        }

        // Establecer nombre y usuarios en el label
        username.setText(ganadero.getNombre() + " " + ganadero.getApellidos());

        // Establecer nombre y siglas en el label
        asociacion.setText(ganaderia.getNombre() + " " + ganaderia.getSiglas());
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
