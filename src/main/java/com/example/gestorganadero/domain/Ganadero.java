package com.example.gestorganadero.domain;

import java.nio.MappedByteBuffer;
import java.util.Objects;

public class Ganadero extends Persona{
    private int id;
    private String password;

    public Ganadero(String dni, String nomnbre, String apellidos, int telefono, int id, String password) {
        super.dni = dni;
        super.nombre = nomnbre;
        super.apellidos = apellidos;
        super.telefono = telefono;
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
        if (!super.equals(o)) return false;
        Ganadero ganadero = (Ganadero) o;
        return id == ganadero.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), id);
    }

    @Override
    public String toString() {
        return "Ganadero{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", telefono=" + telefono +
                ", apellidos='" + apellidos + '\'' +
                '}';
    }
}