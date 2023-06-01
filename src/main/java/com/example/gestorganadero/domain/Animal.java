package com.example.gestorganadero.domain;

import java.util.Objects;

/**
 * Clase Animal que contiene todos los atributos de la tabla Animal, un constructor, getters and setters, hashcode e equals de la primary key y el metodo toString
 */
public class Animal {
    private int crotal;
    private Animal madre;
    private Animal padre;
    private float lactancia;
    private String vacuna;
    private int edad;
    private int hijos;
    private String sexo;
    private Corral corral;

    public Animal(int crotal, Animal madre, Animal padre, float lactancia, String vacuna, int edad, int hijos, String sexo, Corral corral) {
        this.crotal = crotal;
        this.madre = madre;
        this.padre = padre;
        this.lactancia = lactancia;
        this.vacuna = vacuna;
        this.edad = edad;
        this.hijos = hijos;
        this.sexo = sexo;
        this.corral = corral;
    }

    public Animal(){
        this(0,madre,padre,0.0,"",0,0,"",corral);
    }

    public int getCrotal() {
        return crotal;
    }

    public void setCrotal(int crotal) {
        this.crotal = crotal;
    }

    public Animal getMadre() {
        return madre;
    }

    public void setMadre(Animal madre) {
        this.madre = madre;
    }

    public Animal getPadre() {
        return padre;
    }

    public void setPadre(Animal padre) {
        this.padre = padre;
    }

    public float getLactancia() {
        return lactancia;
    }

    public void setLactancia(float lactancia) {
        this.lactancia = lactancia;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getHijos() {
        return hijos;
    }

    public void setHijos(int hijos) {
        this.hijos = hijos;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Corral getCorral() {
        return corral;
    }

    public void setCorral(Corral corral) {
        this.corral = corral;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return crotal == animal.crotal;
    }

    @Override
    public int hashCode() {
        return Objects.hash(crotal);
    }

    @Override
    public String toString() {
        return "Animal{" +
                "crotal=" + crotal +
                ", madre=" + madre +
                ", padre=" + padre +
                ", lactancia=" + lactancia +
                ", vacuna='" + vacuna + '\'' +
                ", edad=" + edad +
                ", hijos=" + hijos +
                ", sexo='" + sexo + '\'' +
                ", corral=" + corral +
                '}';
    }
}
