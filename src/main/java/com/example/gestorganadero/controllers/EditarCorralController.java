package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import com.example.gestorganadero.dao.CorralDAO;
import com.example.gestorganadero.dao.GanaderoDAO;
import com.example.gestorganadero.domain.Corral;
import com.example.gestorganadero.domain.Ganadero;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

/**
 * Clase controlador que extiende App para la vista de edición de usuario
 */
public class EditarCorralController extends App implements Initializable,IController {
    @FXML
    private TextField nombre;
    @FXML
    private TextField tipo;
    @FXML
    private TextField censo;

    private CorralDAO cdao;
    private Corral corralSeleccionado = null;
    private Corral corral = new Corral();

    @Override
    public void setParam(Object o) {
        this.corralSeleccionado = (Corral) o;
    }

    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void start(){
        cdao = new CorralDAO();
        if (corralSeleccionado != null) {
            //Mostrar los datos del corral
            nombre.setText(corralSeleccionado.getNombre());
            tipo.setText(corralSeleccionado.getTipo());
            censo.setText(String.valueOf(corralSeleccionado.getCenso()));
            //Obtener el corral
            String idCorral = String.valueOf(corralSeleccionado.getIdCorral());
            try {
                corral = cdao.findById(idCorral);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    /**
     * @Metodo Botón que guarda los cambios
     * @throws IOException
     */
    @FXML
    private void btnSave() throws IOException, SQLException {
        corral.setNombre(nombre.getText());
        corral.setTipo(tipo.getText());
        corral.setCenso(Integer.parseInt(censo.getText()));
        cdao.save(corral);
        App.setRoot("corral");
    }

    /**
     * @Metodo Link para volver a la vista de Ganaderia
     * @throws IOException
     */
    @FXML
    private void linkVolver() throws IOException {
        App.setRoot("corral");
    }
}
