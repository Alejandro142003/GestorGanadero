package com.example.gestorganadero.domain;

import java.util.Objects;

/**
 * Clase Persona que contiene un constructor, getters and setters, hashcode e equals de la primary key y el metodo toString para despues extender esta clase.
 */
public class Persona {
    protected String dni;
    protected String nombre;
    protected Integer telefono;
    protected String apellidos;

    public Persona(String dni, String nombre, Integer telefono, String apellidos) {
        this.dni = dni;
        this.nombre = nombre;
        this.telefono = telefono;
        this.apellidos = apellidos;
    }

    public Persona() {
        this("", "", 0, "");
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Persona persona = (Persona) o;
        return Objects.equals(dni, persona.dni);
    }

    @Override
    public int hashCode() {
        return Objects.hash(dni);
    }

    @Override
    public String toString() {
        return "Persona{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
