package com.example.gestorganadero.controllers;

import com.example.gestorganadero.App;
import com.example.gestorganadero.dao.GanaderoDAO;
import com.example.gestorganadero.domain.Ganadero;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

/**\
 * Clase controller Login que extiende App
 */
public class LoginController extends App implements Initializable {

    @FXML
    private Label labelError;

    @FXML
    private TextField userField;

    @FXML
    private PasswordField passField;

    private GanaderoDAO gdao;
    private List<Ganadero> ganaderos = null;

    public void initialize(URL url, ResourceBundle resourceBundle){
        //Logica de inicialización del controlador
        gdao = new GanaderoDAO();

        //Obtener todos los ganaderos
        try{
            ganaderos = gdao.findAll();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        //Obtener la lista de los nombres de todos los ganaderos

    }

    /**
     * @Metodo Valida usuario y contraseña para que en caso de que no sea admin admin
     * no se pueda accedera a la App
     * @throws IOException
     */
    @FXML
    private void btnLoginValidate() throws IOException { //Controlador de usuario y contraseña
        if (userField.getText().isEmpty() || passField.getText().isEmpty()) {
            labelError.setText("Se deben de completar todos los campos");
            labelError.setTextFill(Color.RED);
        }else {
            String user = userField.getText();
            String passwd = passField.getText();

            int state = gdao.login(user,passwd);

            if(state != -1){
                if (state == 1){
                    App.setRoot("ganaderia");//Datos correctos se puede acceder al sistema
                } else {
                    labelError.setText("¡Usuario o contraseña invalidos!");
                    labelError.setTextFill(Color.RED);//Mensaje de error al iniciar sesión
                }
            }
        }

        /*else{
            if (userField.getText().equals("admin") && passField.getText().equals("admin")){
                labelError.setText("¡Usuario y contraseñas correctos!");
                labelError.setTextFill(Color.GREEN);
                App.setRoot("ganaderia");
            }else {
                if (userField.getText().equals("user") && passField.getText().equals("user")){
                    App.setRoot("veterinaria");
                } else {
                    labelError.setText("¡Usuario o contraseña invalidos!");
                    labelError.setTextFill(Color.RED);
                }
            }
        }*/
    }
}
