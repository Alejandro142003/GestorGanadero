package com.example.gestorganadero.domain;

import java.util.*;

/**
 * Clase Animal que contiene todos los atributos de la tabla Animal, un constructor, getters and setters, hashcode e equals de la primary key y el metodo toString
 */
public class Animal {

    /**
     * Default constructor
     */
    public Animal() {
    }

    /**
     * 
     */
    private int crotal;

    /**
     * 
     */
    private float lactancia;

    /**
     * 
     */
    private String vacuna;

    /**
     * 
     */
    private int edad;

    /**
     * 
     */
    private int hijos;

    /**
     * 
     */
    private String sexo;

    /**
     * @param crotal 
     * @param madre 
     * @param padre 
     * @param lactancia 
     * @param vacuna 
     * @param edad 
     * @param hijos 
     * @param sexo 
     * @param corral
     */
    public void Animal(int crotal, Animal madre, Animal padre, float lactancia, String vacuna, int edad, int hijos, String sexo, Corral corral) {
        // TODO implement here
    }

    /**
     * 
     */
    public void Animal() {
        // TODO implement here
    }

    /**
     * @return
     */
    public int getCrotal() {
        // TODO implement here
        return 0;
    }

    /**
     * @param crotal 
     * @return
     */
    public void setCrotal(int crotal) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Animal getMadre() {
        // TODO implement here
        return null;
    }

    /**
     * @param madre 
     * @return
     */
    public void setMadre(Animal madre) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Animal getPadre() {
        // TODO implement here
        return null;
    }

    /**
     * @param padre 
     * @return
     */
    public void setPadre(Animal padre) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public float getLactancia() {
        // TODO implement here
        return 0.0f;
    }

    /**
     * @param lactancia 
     * @return
     */
    public void setLactancia(float lactancia) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getVacuna() {
        // TODO implement here
        return "";
    }

    /**
     * @param vacuna 
     * @return
     */
    public void setVacuna(String vacuna) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int getEdad() {
        // TODO implement here
        return 0;
    }

    /**
     * @param edad 
     * @return
     */
    public void setEdad(int edad) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int getHijos() {
        // TODO implement here
        return 0;
    }

    /**
     * @param hijos 
     * @return
     */
    public void setHijos(int hijos) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getSexo() {
        // TODO implement here
        return "";
    }

    /**
     * @param sexo 
     * @return
     */
    public void setSexo(String sexo) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Corral getCorral() {
        // TODO implement here
        return null;
    }

    /**
     * @param corral 
     * @return
     */
    public void setCorral(Corral corral) {
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