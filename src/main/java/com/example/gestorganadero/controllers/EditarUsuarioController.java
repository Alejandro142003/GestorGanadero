package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import com.example.gestorganadero.dao.GanaderoDAO;
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
public class EditarUsuarioController extends App implements Initializable {
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField telefono;
    @FXML
    private PasswordField passwd;
    @FXML
    private PasswordField passwdconf;
    @FXML
    private Button btn_save;
    @FXML
    private Label link_volver;
    @FXML
    private Label labelError;

    private GanaderoDAO gdao;
    private Ganadero ganadero = new Ganadero();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        //Lógica de inicialización del controlador
        gdao = new GanaderoDAO();
        String ganaderoId = "1";

        // Obtener el ganadero
        try {
            ganadero = gdao.findById(ganaderoId);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Mostrar los datos del usuario
        nombre.setText(ganadero.getNombre());
        apellidos.setText(ganadero.getApellidos());
        telefono.setText(String.valueOf(ganadero.getTelefono()));
    }

    /**
     * @Metodo Botón que guarda los cambios
     * @throws IOException
     */
    @FXML
    private void btnSave() throws IOException {
        if (nombre.getText().isEmpty() || apellidos.getText().isEmpty() || telefono.getText().isEmpty()){
            labelError.setText("Se deben completar todos los campos");
            labelError.setTextFill(Color.RED);
        }else {
            if (passwd.getText().isEmpty() && passwdconf.getText().isEmpty()) {
                ganadero.setNombre(nombre.getText());
                ganadero.setApellidos(apellidos.getText());
                ganadero.setTelefono(Integer.parseInt(telefono.getText()));
                ganadero.setPassword(ganadero.getPassword());
                try {
                    gdao.save(ganadero);
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
                App.setRoot("ganaderia");
            } else {
                if (passwd.getText().equals(passwdconf.getText()) && passwdconf.getText().equals(passwd.getText())) {
                    ganadero.setNombre(nombre.getText());
                    ganadero.setApellidos(apellidos.getText());
                    ganadero.setTelefono(Integer.parseInt(telefono.getText()));
                    ganadero.setPassword(passwd.getText());
                    try {
                        gdao.save(ganadero);
                    } catch (SQLException e) {
                        throw new RuntimeException(e);
                    }
                    App.setRoot("ganaderia");
                } else {
                    labelError.setText("Las contraseñas no coinciden");
                    labelError.setTextFill(Color.RED);
                }
            }
        }
    }

    /**
     * @Metodo Link para volver a la vista de Ganaderia
     * @throws IOException
     */
    @FXML
    private void  linkVolver() throws IOException {
        App.setRoot("ganaderia");
    }
}
