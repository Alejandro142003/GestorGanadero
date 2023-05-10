package com.example.gestorganadero.domain;

import java.util.Objects;

public class Corral {
    private int id;
    private String nombre;
    private String tipo;

    /*Habría que cambiar el metodo numeroAnimales por un count dentro de animales asociados a cada corral
    * para que saque el número de animales total por corral*/
    private int numeroAnimales;

    public Corral(int id, String nombre, String tipo, int numeroAnimales) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.numeroAnimales = numeroAnimales;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getNumeroAnimales() {
        return numeroAnimales;
    }

    public void setNumeroAnimales(int numeroAnimales) {
        this.numeroAnimales = numeroAnimales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corral corral = (Corral) o;
        return id == corral.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Corral{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", numeroAnimales=" + numeroAnimales +
                '}';
    }
}

