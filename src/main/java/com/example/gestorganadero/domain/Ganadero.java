package com.example.gestorganadero.domain;

import java.util.Objects;

/**
 * Clase Ganadero que extiende de Persona que contiene todos los atributos de la tabla Ganadero, un constructor, getters and setters, hashcode e equals de la primary key
 * y el metodo toString
 */
public class Ganadero extends Persona{
    private int idGanadero;
    private String password;
    private String REGA;

    public Ganadero(String dni, String nombre, String apellidos, int telefono, int idGanadero, String password) {
        super.dni = dni;
        super.nombre = nombre;
        super.apellidos = apellidos;
        super.telefono = telefono;
        this.idGanadero = idGanadero;
        this.password = password;
    }

    public Ganadero() {
        this("","","",0,0,"");
    }

    public String getREGA() {
        return REGA;
    }

    public void setREGA(String REGA) {
        this.REGA = REGA;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Ganadero ganadero = (Ganadero) o;
        return idGanadero == ganadero.idGanadero && Objects.equals(REGA, ganadero.REGA);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idGanadero, REGA);
    }

    @Override
    public String toString() {
        return "Ganadero{" +
                "idGanadero=" + idGanadero +
                ", password='" + password + '\'' +
                ", REGA='" + REGA + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}