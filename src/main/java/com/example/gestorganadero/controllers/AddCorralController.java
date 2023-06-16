package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import com.example.gestorganadero.dao.CorralDAO;
import com.example.gestorganadero.dao.GanaderiaDAO;
import com.example.gestorganadero.dao.GanaderoDAO;
import com.example.gestorganadero.domain.Corral;
import com.example.gestorganadero.domain.Ganaderia;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class AddCorralController extends App{
    @FXML
    private Label labelError;
    @FXML
    private TextField nombre;
    @FXML
    private TextField tipo;
    @FXML
    private TextField censo;
    @FXML
    private Button btnSave;
    @FXML
    private Label linkVolver;

    private CorralDAO cdao;
    private GanaderiaDAO gdao;

    @FXML
    private void btnSave() throws IOException {
        if (nombre.getText().isEmpty() || tipo.getText().isEmpty() || censo.getText().isEmpty()){
            labelError.setText("Se deben completar todos los campos");
            labelError.setTextFill(Color.RED);
        }else {
            cdao = new CorralDAO();
            gdao = new GanaderiaDAO();
            String ganaderiaId = "410600000054";
            Corral corral = new Corral();


            // Obtener la ganaderia
            Ganaderia ganaderia;
            try{
                ganaderia = gdao.findById(ganaderiaId);
            } catch (SQLException e){
                throw new RuntimeException(e);
            }

            corral.setNombre(nombre.getText());
            corral.setTipo(tipo.getText());
            corral.setCenso(Integer.parseInt(censo.getText()));
            corral.setGanaderia(ganaderia);

            try {
                cdao.save(corral);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            App.setRoot("corral");
        }
    }
    @FXML
    private void  linkVolver() throws IOException {
        App.setRoot("corral");
    }
}
