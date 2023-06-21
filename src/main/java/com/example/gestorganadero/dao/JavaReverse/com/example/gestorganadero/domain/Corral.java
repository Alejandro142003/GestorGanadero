package com.example.gestorganadero.domain;

import java.util.*;

/**
 * Clase Corral que contiene todos los atributos de la tabla Corral, un constructor, getters and setters, hashcode e equals de la primary key y el metodo toString
 */
public class Corral {

    /**
     * Default constructor
     */
    public Corral() {
    }

    /**
     * 
     */
    private int idCorral;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String tipo;

    /**
     * Habría que cambiar el metodo numeroAnimales por un count dentro de animales asociados a cada corral
     * para que saque el número de animales total por corral
     */
    private int censo;

    /**
     * @param idCorral 
     * @param nombre 
     * @param tipo 
     * @param censo 
     * @param ganaderia 
     * @param animales
     */
    public void Corral(int idCorral, String nombre, String tipo, int censo, Ganaderia ganaderia, Set<Animal> animales) {
        // TODO implement here
    }

    /**
     * 
     */
    public void Corral() {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getIdCorral() {
        // TODO implement here
        return 0;
    }

    /**
     * @param idCorral 
     * @return
     */
    public void setIdCorral(int idCorral) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getNombre() {
        // TODO implement here
        return "";
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
     * @return
     */
    public String getTipo() {
        // TODO implement here
        return "";
    }

    /**
     * @param tipo 
     * @return
     */
    public void setTipo(String tipo) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int getCenso() {
        // TODO implement here
        return 0;
    }

    /**
     * @param censo 
     * @return
     */
    public void setCenso(int censo) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Ganaderia getGanaderia() {
        // TODO implement here
        return null;
    }

    /**
     * @param ganaderia 
     * @return
     */
    public void setGanaderia(Ganaderia ganaderia) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<Animal> getAnimales() {
        // TODO implement here
        return null;
    }

    /**
     * @param animales 
     * @return
     */
    public void setAnimales(Set<Animal> animales) {
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