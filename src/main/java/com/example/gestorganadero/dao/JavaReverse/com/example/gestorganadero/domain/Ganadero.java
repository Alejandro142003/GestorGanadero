package com.example.gestorganadero.domain;

import java.util.*;

/**
 * Clase Ganadero que extiende de Persona que contiene todos los atributos de la tabla Ganadero, un constructor, getters and setters, hashcode e equals de la primary key
 * y el metodo toString
 */
public class Ganadero extends Persona {

    /**
     * Default constructor
     */
    public Ganadero() {
    }

    /**
     * 
     */
    private int idGanadero;

    /**
     * 
     */
    private String password;

    /**
     * @param dni 
     * @param nombre 
     * @param telefono 
     * @param apellidos 
     * @param idGanadero 
     * @param password 
     * @param ganaderias
     */
    public void Ganadero(String dni, String nombre, Integer telefono, String apellidos, int idGanadero, String password, Set<Ganaderia> ganaderias) {
        // TODO implement here
    }

    /**
     * 
     */
    public void Ganadero() {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getIdGanadero() {
        // TODO implement here
        return 0;
    }

    /**
     * @param idGanadero 
     * @return
     */
    public void setIdGanadero(int idGanadero) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getPassword() {
        // TODO implement here
        return "";
    }

    /**
     * @param password 
     * @return
     */
    public void setPassword(String password) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<Ganaderia> getGanaderias() {
        // TODO implement here
        return null;
    }

    /**
     * @param ganaderias 
     * @return
     */
    public void setGanaderias(Set<Ganaderia> ganaderias) {
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