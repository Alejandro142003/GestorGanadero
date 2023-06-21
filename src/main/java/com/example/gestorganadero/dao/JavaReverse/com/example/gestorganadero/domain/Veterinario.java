package com.example.gestorganadero.domain;

import java.util.*;

/**
 * Clase Veterinario que extiende de Persona que contiene todos los atributos de la tabla Ganadero, un constructor, getters and setters, hashcode e equals de la primary key
 * y el metodo toString
 */
public class Veterinario extends Persona {

    /**
     * Default constructor
     */
    public Veterinario() {
    }

    /**
     * 
     */
    private int idVeterinario;

    /**
     * 
     */
    private String password;

    /**
     * @param dni 
     * @param nombre 
     * @param telefono 
     * @param apellidos 
     * @param idVeterinario 
     * @param password 
     * @param ganaderias
     */
    public void Veterinario(String dni, String nombre, Integer telefono, String apellidos, int idVeterinario, String password, Set<Ganaderia> ganaderias) {
        // TODO implement here
    }

    /**
     * 
     */
    public void Veterinario() {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getIdVeterinario() {
        // TODO implement here
        return 0;
    }

    /**
     * @param idVeterinario 
     * @return
     */
    public void setIdVeterinario(int idVeterinario) {
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