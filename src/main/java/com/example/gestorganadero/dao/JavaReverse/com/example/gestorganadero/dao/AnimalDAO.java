package com.example.gestorganadero.dao;

import java.util.*;

/**
 * Clase AnimalDAO que implementa DAO que contiene todas las consultas a la tabla
 * animal de la base de datos.
 */
public class AnimalDAO implements DAO {

    /**
     * Default constructor
     */
    public AnimalDAO() {
    }

    /**
     * 
     */
    private static final String FINDALL = "SELECT * from animal";

    /**
     * 
     */
    private static final String FINBYID = "SELECT * from animal WHERE crotal=?";

    /**
     * 
     */
    private static final String INSERT = "INSERT INTO animal (Crotal,CrotalMadre,CrotalPadre,Lactancia,Vacuna,Edad,NumeroHijos,Sexo,IdCorral) VALUES (?,?,?,?,?,?,?,?,?)";

    /**
     * 
     */
    private static final String UPDATE = "UPDATE animal SET Lactancia=?, Vacuna=?, Edad=?, NumeroHijos=?,IdCorral=? WHERE Crotal=?";

    /**
     * 
     */
    private static final String DELETE = "DELETE FROM ganaderoA WHERE crotal=?";

    /**
     * 
     */
    private Connection conn;

    /**
     * @param conn
     */
    public void AnimalDAO(Connection conn) {
        // TODO implement here
    }

    /**
     * 
     */
    public void AnimalDAO() {
        // TODO implement here
    }

    /**
     * Metodo que obtiene todas las entradas de la tabla
     * @throws SQLException
     * @return
     */
    public Set<Animal> findAll() {
        // TODO implement here
        return null;
    }

    /**
     * Metodo que obtiene un objeto de la tabla según su id
     * @throws SQLException
     * @param id 
     * @return
     */
    public Animal findById(String id) {
        // TODO implement here
        return null;
    }

    /**
     * Metodo que agrega o modifica un objeto de la tabla
     * @throws SQLException
     * @param entity 
     * @return
     */
    public Animal save(Animal entity) {
        // TODO implement here
        return null;
    }

    /**
     * Metodo que elimina un objeto de la tabla según su id
     * @throws SQLException
     * @param entity 
     * @return
     */
    public void delete(Animal entity) {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    public void close() {
        // TODO implement here
        return null;
    }

    /**
     * @return
     */
    Set<T> findAll() {
        // TODO implement here
        return null;
    }

    /**
     * @param id 
     * @return
     */
    T findById(String id) {
        // TODO implement here
        return null;
    }

    /**
     * @param entity 
     * @return
     */
    T save(T entity) {
        // TODO implement here
        return null;
    }

    /**
     * @param entity 
     * @return
     */
    void delete(T entity) {
        // TODO implement here
        return null;
    }

}