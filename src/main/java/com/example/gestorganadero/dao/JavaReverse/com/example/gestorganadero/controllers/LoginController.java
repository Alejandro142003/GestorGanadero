package com.example.gestorganadero.controllers;

import java.util.*;

/**
 * \
 * Clase controller Login que extiende App
 */
public class LoginController extends App implements Initializable {

    /**
     * Default constructor
     */
    public LoginController() {
    }

    /**
     * 
     */
    private Label labelError;

    /**
     * 
     */
    private TextField userField;

    /**
     * 
     */
    private PasswordField passField;

    /**
     * 
     */
    private GanaderiaDAO ganaderiadao;

    /**
     * 
     */
    private GanaderoDAO gdao;

    /**
     * 
     */
    private Set<Ganadero> ganaderos = null;

    /**
     * 
     */
    public static Ganadero currentUser;

    /**
     * 
     */
    public static Ganaderia currentEntity;

    /**
     * @return
     */
    public Ganadero getCurrentUser() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public static Ganaderia getCurrentEntity() {
        // TODO implement here
        return null;
    }

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
     * @Metodo Valida usuario y contraseña para que en caso de que no sea admin admin
     * no se pueda accedera a la App
     * @throws IOException
     * @return
     */
    private void btnLoginValidate() {
        // TODO implement here
        return null;
    }

}