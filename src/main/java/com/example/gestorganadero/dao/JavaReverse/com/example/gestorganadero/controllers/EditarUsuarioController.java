package com.example.gestorganadero.controllers;

import java.util.*;

/**
 * Clase controlador que extiende App para la vista de edición de usuario
 */
public class EditarUsuarioController extends App implements Initializable {

    /**
     * Default constructor
     */
    public EditarUsuarioController() {
    }

    /**
     * 
     */
    private TextField nombre;

    /**
     * 
     */
    private TextField apellidos;

    /**
     * 
     */
    private TextField telefono;

    /**
     * 
     */
    private PasswordField passwd;

    /**
     * 
     */
    private PasswordField passwdconf;

    /**
     * 
     */
    private Button btn_save;

    /**
     * 
     */
    private Label link_volver;

    /**
     * 
     */
    private Label labelError;

    /**
     * 
     */
    private GanaderoDAO gdao;

    /**
     * 
     */
    private Ganadero ganadero;

    /**
     * 
     */
    private Ganadero currentUser;

    /**
     * @param url 
     * @param resourceBundle 
     * @return
     */
    public void initialize(URL url, ResourceBundle resourceBundle) {
        // TODO implement here
        return null;
    }

    /**
     * @Metodo Botón que guarda los cambios
     * @throws IOException
     * @return
     */
    private void btnSave() {
        // TODO implement here
        return null;
    }

    /**
     * @Metodo Link para volver a la vista de Ganaderia
     * @throws IOException
     * @return
     */
    private void linkVolver() {
        // TODO implement here
        return null;
    }

}