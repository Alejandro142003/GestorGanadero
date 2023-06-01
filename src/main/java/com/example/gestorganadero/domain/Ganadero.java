package com.example.gestorganadero.domain;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase Ganadero que extiende de Persona que contiene todos los atributos de la tabla Ganadero, un constructor, getters and setters, hashcode e equals de la primary key
 * y el metodo toString
 */
public class Ganadero extends Persona{
    private int idGanadero;
    private String password;
    private ArrayList<Ganaderia> ganaderias;

    public Ganadero(String dni, String nombre, Integer telefono, String apellidos, int idGanadero, String password, ArrayList<Ganaderia> ganaderias) {
        super(dni, nombre, telefono, apellidos);
        this.idGanadero = idGanadero;
        this.password = password;
        this.ganaderias = ganaderias;
    }

    public Ganadero() {
        this("","",0,"",0,"",ganaderias);
    }

    public int getIdGanadero() {
        return idGanadero;
    }

    public void setIdGanadero(int idGanadero) {
        this.idGanadero = idGanadero;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Ganaderia> getGanaderias() {
        return ganaderias;
    }

    public void setGanaderias(ArrayList<Ganaderia> ganaderias) {
        this.ganaderias = ganaderias;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ganadero ganadero = (Ganadero) o;
        return idGanadero == ganadero.idGanadero;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idGanadero);
    }

    @Override
    public String toString() {
        return "Ganadero{" +
                "idGanadero=" + idGanadero +
                ", password='" + password + '\'' +
                ", ganaderias=" + ganaderias +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}