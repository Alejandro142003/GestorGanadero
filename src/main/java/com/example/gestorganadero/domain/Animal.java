package com.example.gestorganadero.domain;

import java.util.Objects;

/**
 * Clase Animal que contiene todos los atributos de la tabla Animal, un constructor, getters and setters, hashcode e equals de la primary key y el metodo toString
 */
public class Animal {
    private int Crotal;
    private int madre;
    private int padre;
    private float Lactancia;
    private String Vacuna;
    private int Edad;
    private int Hijos;
    private String Sexo;
    private int IdCorral;

    public Animal(int crotal, int madre, int padre, float lactancia, String vacuna, int edad, int hijos,String sexo, int IdCorral) {
        this.Crotal = crotal;
        this.madre = madre;
        this.padre = padre;
        this.Lactancia = lactancia;
        this.Vacuna = vacuna;
        this.Edad = edad;
        this.Hijos = hijos;
        this.Sexo = sexo;
        this.IdCorral = IdCorral;
    }

    public Animal(){
        this(0,0,0,0,"",0,0,"",0);
    }

    public void setIdCorral(int idCorral) {
        IdCorral = idCorral;
    }

    public String getSexo() {
        return Sexo;
    }

    public void setSexo(String sexo) {
        Sexo = sexo;
    }

    public int getIdCorral() {
        return IdCorral;
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
                ", Sexo='" + Sexo + '\'' +
                ", IdCorral=" + IdCorral +
                '}';
    }
}
