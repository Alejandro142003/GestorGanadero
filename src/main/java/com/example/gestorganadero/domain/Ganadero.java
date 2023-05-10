package com.example.gestorganadero.domain;

import java.util.Objects;

public class Ganadero extends Persona{
    private int id;
    private String password;

    public Ganadero(int id, String password) {
        this.id = id;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
        Ganadero ganadero = (Ganadero) o;
        return id == ganadero.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Ganadero{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono='" + telefono + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                '}';
    }
}
