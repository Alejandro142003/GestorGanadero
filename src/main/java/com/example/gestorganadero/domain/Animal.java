package com.example.gestorganadero.domain;

import java.util.List;
import java.util.Objects;

public class Animal {
    private int Crotal;
    private int madre;
    private int padre;
    private float Lactancia;
    private String Vacuna;
    private int Edad;
    private int Hijos;

    private List<Animal> animales = null;

    public Animal(int crotal, int madre, int padre, float lactancia, String vacuna, int edad, int hijos) {
        this.Crotal = crotal;
        this.madre = madre;
        this.padre = padre;
        this.Lactancia = lactancia;
        this.Vacuna = vacuna;
        this.Edad = edad;
        this.Hijos = hijos;
    }

    public int getCrotal() {
        return Crotal;
    }

    public void setCrotal(int crotal) {
        Crotal = crotal;
    }

    public int getMadre() {
        return madre;
    }

    public void setMadre(int madre) {
        this.madre = madre;
    }

    public int getPadre() {
        return padre;
    }

    public void setPadre(int padre) {
        this.padre = padre;
    }

    public float getLactancia() {
        return Lactancia;
    }

    public void setLactancia(float lactancia) {
        Lactancia = lactancia;
    }

    public String getVacuna() {
        return Vacuna;
    }

    public void setVacuna(String vacuna) {
        Vacuna = vacuna;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        Edad = edad;
    }

    public int getHijos() {
        return Hijos;
    }

    public void setHijos(int hijos) {
        Hijos = hijos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Crotal == animal.Crotal && Objects.equals(madre, animal.madre) && Objects.equals(padre, animal.padre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(Crotal, madre, padre);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "Crotal=" + Crotal +
                ", madre=" + madre +
                ", padre=" + padre +
                ", Lactancia=" + Lactancia +
                ", Vacuna='" + Vacuna + '\'' +
                ", Edad=" + Edad +
                ", Hijos=" + Hijos +
                '}';
    }
}
