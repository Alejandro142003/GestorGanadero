package com.example.gestorganadero.domain;

import java.util.Objects;

public class Corral {
    private int idCorral;
    private String nombre;
    private String tipo;

    /*Habría que cambiar el metodo numeroAnimales por un count dentro de animales asociados a cada corral
    * para que saque el número de animales total por corral*/
    private int censo;

    private String REGA;

    public Corral(int id, String nombre, String tipo, int numeroAnimales, String REGA) {
        this.idCorral = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.censo = numeroAnimales;
        this.REGA = REGA;
    }


    public String getREGA() {
        return REGA;
    }

    public void setREGA(String REGA) {
        this.REGA = REGA;
    }

    public Corral(){
        this(0,"","",0,"");
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corral corral = (Corral) o;
        return idCorral == corral.idCorral;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idCorral);
    }

    @Override
    public String toString() {
        return "Corral{" +
                "idCorral=" + idCorral +
                ", nombre='" + nombre + '\'' +
                ", tipo='" + tipo + '\'' +
                ", censo=" + censo +
                ", rega='" + REGA + '\'' +
                '}';
    }
}

