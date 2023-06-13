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
    private TextField Nombre;
    @FXML
    private TextField Apellidos;
    @FXML
    private TextField Telefono;
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
        Nombre.setText(ganadero.getNombre());
        Apellidos.setText(ganadero.getApellidos());
        Telefono.setText(String.valueOf(ganadero.getTelefono()));
        passwd.setText(ganadero.getPassword());
        passwdconf.setText(ganadero.getPassword());
    }

    /**
     * @Metodo Botón que guarda los cambios
     * @throws IOException
     */
    @FXML
    private void btnSave() throws IOException {
        if (passwd.getText().equals(passwdconf.getText()) && passwdconf.getText().equals(passwd.getText())){
            ganadero.setNombre(Nombre.getText());
            ganadero.setApellidos(Apellidos.getText());
            ganadero.setTelefono(Integer.parseInt(Telefono.getText()));
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

    /**
     * @Metodo Link para volver a la vista de Ganaderia
     * @throws IOException
     */
    @FXML
    private void  linkVolver() throws IOException {
        App.setRoot("ganaderia");
    }
}
