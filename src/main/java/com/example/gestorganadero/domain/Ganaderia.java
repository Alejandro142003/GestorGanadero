package com.example.gestorganadero.domain;

import java.util.ArrayList;
import java.util.Objects;

public class Ganaderia {
    private int REGA;
    private ArrayList<Corral> corrales = new ArrayList<>();
    private int age;//Antigüedad
    private int CensoTotal;
    private String Siglas;
    private String Nombre;
    private String Localidad;
    private String Provincia;
    private String Titular;
    private String SistemaExplotacion;

    public Ganaderia(int REGA, ArrayList<Corral> corrales, int age, int censoTotal, String siglas, String nombre, String localidad, String provincia, String titular, String sistemaExplotacion) {
        this.REGA = REGA;
        this.corrales = corrales;
        this.age = age;
        CensoTotal = censoTotal;
        Siglas = siglas;
        Nombre = nombre;
        Localidad = localidad;
        Provincia = provincia;
        Titular = titular;
        SistemaExplotacion = sistemaExplotacion;
    }

    public int getREGA() {
        return REGA;
    }

    public void setREGA(int REGA) {
        this.REGA = REGA;
    }

    public ArrayList<Corral> getCorrales() {
        return corrales;
    }

    public void setCorrales(ArrayList<Corral> corrales) {
        this.corrales = corrales;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getCensoTotal() {
        return CensoTotal;
    }

    public void setCensoTotal(int censoTotal) {
        CensoTotal = censoTotal;
    }

    public String getSiglas() {
        return Siglas;
    }

    public void setSiglas(String siglas) {
        Siglas = siglas;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getLocalidad() {
        return Localidad;
    }

    public void setLocalidad(String localidad) {
        Localidad = localidad;
    }

    public String getProvincia() {
        return Provincia;
    }

    public void setProvincia(String provincia) {
        Provincia = provincia;
    }

    public String getTitular() {
        return Titular;
    }

    public void setTitular(String titular) {
        Titular = titular;
    }

    public String getSistemaExplotacion() {
        return SistemaExplotacion;
    }

    public void setSistemaExplotacion(String sistemaExplotacion) {
        SistemaExplotacion = sistemaExplotacion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ganaderia ganaderia = (Ganaderia) o;
        return REGA == ganaderia.REGA;
    }

    @Override
    public int hashCode() {
        return Objects.hash(REGA);
    }

    @Override
    public String toString() {
        return "Ganaderia{" +
                "REGA=" + REGA +
                ", corrales=" + corrales +
                ", age=" + age +
                ", CensoTotal=" + CensoTotal +
                ", Siglas='" + Siglas + '\'' +
                ", Nombre='" + Nombre + '\'' +
                ", Localidad='" + Localidad + '\'' +
                ", Provincia='" + Provincia + '\'' +
                ", Titular='" + Titular + '\'' +
                ", SistemaExplotacion='" + SistemaExplotacion + '\'' +
                '}';
    }
}
