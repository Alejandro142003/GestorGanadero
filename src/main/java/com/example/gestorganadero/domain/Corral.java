package com.example.gestorganadero.domain;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase Corral que contiene todos los atributos de la tabla Corral, un constructor, getters and setters, hashcode e equals de la primary key y el metodo toString
 */
public class Corral {
    private int idCorral;
    private String nombre;
    private String tipo;
    private String nombreGanaderia;

    /*Habría que cambiar el metodo numeroAnimales por un count dentro de animales asociados a cada corral
     * para que saque el número de animales total por corral*/
    private int censo;

    private Ganaderia ganaderia;
    private ArrayList<Animal> animales;

    public Corral(int idCorral, String nombre, String tipo, int censo, Ganaderia ganaderia, ArrayList<Animal> animales) {
        this.idCorral = idCorral;
        this.nombre = nombre;
        this.tipo = tipo;
        this.censo = censo;
        this.ganaderia = ganaderia;
        this.animales = animales;
        this.nombreGanaderia = null;
    }

    public Corral() {
        Ganaderia g = null;
        ArrayList<Animal> a = null;
        this.idCorral = 0;
        this.nombre = "";
        this.tipo = "";
        this.censo = 0;
        this.nombreGanaderia = "";
    }

    public String getNombreGanaderia() {
        return nombreGanaderia;
    }

    public void setNombreGanaderia(String nombreGanaderia) {
        this.nombreGanaderia = nombreGanaderia;
    }

    public int getIdCorral() {
        return idCorral;
    }

    public void setIdCorral(int idCorral) {
        this.idCorral = idCorral;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCenso() {
        return censo;
    }

    public void setCenso(int censo) {
        this.censo = censo;
    }

    public Ganaderia getGanaderia() {
        return ganaderia;
    }

    public void setGanaderia(Ganaderia ganaderia) {
        this.ganaderia = ganaderia;
    }

    public ArrayList<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(ArrayList<Animal> animales) {
        this.animales = animales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corral corral = (Corral) o;
        return idCorral == corral.idCorral && Objects.equals(ganaderia, corral.ganaderia);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCorral, ganaderia);
    }

    @Override
    public String toString() {
        return "Corral{" +
                "idCorral=" + idCorral +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", nombreGanaderia='" + nombreGanaderia + '\'' +
                ", censo=" + censo +
                ", ganaderia=" + ganaderia +
                ", animales=" + animales +
                '}';
    }
}