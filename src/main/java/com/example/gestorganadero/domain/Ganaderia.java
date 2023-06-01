package com.example.gestorganadero.domain;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Clase Ganaderia que contiene todos los atributos de la tabla Ganaderia, un constructor, getters and setters, hashcode e equals de la primary key y el metodo toString
 */
public class Ganaderia {
    private String rega;
    private int age;//Antigüedad
    private int censoTotal;
    private String siglas;
    private String nombre;
    private String localidad;
    private String provincia;
    private String titular;
    private String sistemaExplotacion;
    private Ganadero owner;
    private ArrayList<Corral> corrales;

    public Ganaderia(String rega, int age, int censoTotal, String siglas, String nombre, String localidad, String provincia, String titular, String sistemaExplotacion, Ganadero owner, ArrayList<Corral> corrales) {
        this.rega = rega;
        this.age = age;
        this.censoTotal = censoTotal;
        this.siglas = siglas;
        this.nombre = nombre;
        this.localidad = localidad;
        this.provincia = provincia;
        this.titular = titular;
        this.sistemaExplotacion = sistemaExplotacion;
        this.owner = owner;
        this.corrales = corrales;
    }

    public Ganaderia(){
        this("",0,0,"","","","","","",owner,corrales);
    }

    public String getRega() {
        return rega;
    }

    public void setRega(String rega) {
        this.rega = rega;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCensoTotal() {
        return censoTotal;
    }

    public void setCensoTotal(int censoTotal) {
        this.censoTotal = censoTotal;
    }

    public String getSiglas() {
        return siglas;
    }

    public void setSiglas(String siglas) {
        this.siglas = siglas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public String getSistemaExplotacion() {
        return sistemaExplotacion;
    }

    public void setSistemaExplotacion(String sistemaExplotacion) {
        this.sistemaExplotacion = sistemaExplotacion;
    }

    public Ganadero getOwner() {
        return owner;
    }

    public void setOwner(Ganadero owner) {
        this.owner = owner;
    }

    public ArrayList<Corral> getCorrales() {
        return corrales;
    }

    public void setCorrales(ArrayList<Corral> corrales) {
        this.corrales = corrales;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ganaderia ganaderia = (Ganaderia) o;
        return Objects.equals(rega, ganaderia.rega) && Objects.equals(owner, ganaderia.owner);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rega, owner);
    }

    @Override
    public String toString() {
        return "Ganaderia{" +
                "rega='" + rega + '\'' +
                ", age=" + age +
                ", censoTotal=" + censoTotal +
                ", siglas='" + siglas + '\'' +
                ", nombre='" + nombre + '\'' +
                ", localidad='" + localidad + '\'' +
                ", provincia='" + provincia + '\'' +
                ", titular='" + titular + '\'' +
                ", sistemaExplotacion='" + sistemaExplotacion + '\'' +
                ", owner=" + owner +
                ", corrales=" + corrales +
                '}';
    }
}
