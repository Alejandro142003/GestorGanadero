package com.example.gestorganadero.domain;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase Veterinario que extiende de Persona que contiene todos los atributos de la tabla Ganadero, un constructor, getters and setters, hashcode e equals de la primary key
 * y el metodo toString
 */
public class Veterinario extends Persona{
    private int idVeterinario;
    private String password;
    private ArrayList<Ganaderia> ganaderias;

    public Veterinario(String dni, String nombre, Integer telefono, String apellidos, int idVeterinario, String password, ArrayList<Ganaderia> ganaderias) {
        super(dni, nombre, telefono, apellidos);
        this.idVeterinario = idVeterinario;
        this.password = password;
        this.ganaderias = ganaderias;
    }

    public Veterinario() {
        ArrayList<Ganaderia> g = null;
        super.dni = "";
        super.nombre = "";
        super.telefono = 0;
        super.apellidos = "";
        this.idVeterinario = 0;
        this.password = "";
    }

    public int getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(int idVeterinario) {
        this.idVeterinario = idVeterinario;
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
        Veterinario that = (Veterinario) o;
        return idVeterinario == that.idVeterinario;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), idVeterinario);
    }

    @Override
    public String toString() {
        return "Veterinario{" +
                "idVeterinario=" + idVeterinario +
                ", password='" + password + '\'' +
                ", ganaderias=" + ganaderias +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}
