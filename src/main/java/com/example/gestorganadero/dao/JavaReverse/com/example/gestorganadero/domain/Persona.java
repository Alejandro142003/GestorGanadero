package com.example.gestorganadero.domain;

import java.util.*;

/**
 * Clase Persona que contiene un constructor, getters and setters, hashcode e equals de la primary key y el metodo toString para despues extender esta clase.
 */
public class Persona {

    /**
     * Default constructor
     */
    public Persona() {
    }

    /**
     * 
     */
    protected String dni;

    /**
     * 
     */
    protected String nombre;

    /**
     * 
     */
    protected Integer telefono;

    /**
     * 
     */
    protected String apellidos;

    /**
     * @param dni 
     * @param nombre 
     * @param telefono 
     * @param apellidos
     */
    public void Persona(String dni, String nombre, Integer telefono, String apellidos) {
        // TODO implement here
    }

    /**
     * 
     */
    public void Persona() {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getDni() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public String getNombre() {
        // TODO implement here
        return "";
    }

    /**
     * @return
     */
    public Integer getTelefono() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getApellidos() {
        // TODO implement here
        return "";
    }

    /**
     * @param dni 
     * @return
     */
    public void setDni(String dni) {
        // TODO implement here
        return null;
    }

    /**
     * @param nombre 
     * @return
     */
    public void setNombre(String nombre) {
        // TODO implement here
        return null;
    }

    /**
     * @param telefono 
     * @return
     */
    public void setTelefono(int telefono) {
        // TODO implement here
        return null;
    }

    /**
     * @param apellidos 
     * @return
     */
    public void setApellidos(String apellidos) {
        // TODO implement here
        return null;
    }

    /**
     * @param o 
     * @return
     */
    public boolean equals(Object o) {
        // TODO implement here
        return false;
    }

    /**
     * @return
     */
    public int hashCode() {
        // TODO implement here
        return 0;
    }

    /**
     * @return
     */
    public String toString() {
        // TODO implement here
        return "";
    }

}