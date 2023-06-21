package com.example.gestorganadero.domain;

import java.util.*;

/**
 * Clase Ganaderia que contiene todos los atributos de la tabla Ganaderia, un constructor, getters and setters, hashcode e equals de la primary key y el metodo toString
 */
public class Ganaderia {

    /**
     * Default constructor
     */
    public Ganaderia() {
    }

    /**
     * 
     */
    private String rega;

    /**
     * 
     */
    private int age;

    /**
     * 
     */
    private int censoTotal;

    /**
     * 
     */
    private String siglas;

    /**
     * 
     */
    private String nombre;

    /**
     * 
     */
    private String localidad;

    /**
     * 
     */
    private String provincia;

    /**
     * 
     */
    private String titular;

    /**
     * 
     */
    private String sistemaExplotacion;

    /**
     * @param rega 
     * @param age 
     * @param censoTotal 
     * @param siglas 
     * @param nombre 
     * @param localidad 
     * @param provincia 
     * @param titular 
     * @param sistemaExplotacion 
     * @param owner 
     * @param corrales
     */
    public void Ganaderia(String rega, int age, int censoTotal, String siglas, String nombre, String localidad, String provincia, String titular, String sistemaExplotacion, Ganadero owner, Set<Corral> corrales) {
        // TODO implement here
    }

    /**
     * 
     */
    public void Ganaderia() {
        // TODO implement here
    }

    /**
     * @return
     */
    public String getRega() {
        // TODO implement here
        return "";
    }

    /**
     * @param rega 
     * @return
     */
    public void setRega(String rega) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int getAge() {
        // TODO implement here
        return 0;
    }

    /**
     * @param age 
     * @return
     */
    public void setAge(int age) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public int getCensoTotal() {
        // TODO implement here
        return 0;
    }

    /**
     * @param censoTotal 
     * @return
     */
    public void setCensoTotal(int censoTotal) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getSiglas() {
        // TODO implement here
        return "";
    }

    /**
     * @param siglas 
     * @return
     */
    public void setSiglas(String siglas) {
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
    public String getLocalidad() {
        // TODO implement here
        return "";
    }

    /**
     * @param localidad 
     * @return
     */
    public void setLocalidad(String localidad) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getProvincia() {
        // TODO implement here
        return "";
    }

    /**
     * @param provincia 
     * @return
     */
    public void setProvincia(String provincia) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getTitular() {
        // TODO implement here
        return "";
    }

    /**
     * @param titular 
     * @return
     */
    public void setTitular(String titular) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public String getSistemaExplotacion() {
        // TODO implement here
        return "";
    }

    /**
     * @param sistemaExplotacion 
     * @return
     */
    public void setSistemaExplotacion(String sistemaExplotacion) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Ganadero getOwner() {
        // TODO implement here
        return null;
    }

    /**
     * @param owner 
     * @return
     */
    public void setOwner(Ganadero owner) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public Set<Corral> getCorrales() {
        // TODO implement here
        return null;
    }

    /**
     * @param corrales 
     * @return
     */
    public void setCorrales(Set<Corral> corrales) {
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