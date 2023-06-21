package com.example.gestorganadero.dao;

import java.util.*;

/**
 * Clase CorralDAO que implementa DAO que contiene todas las consultas a la tabla
 * corral de la base de datos.
 */
public class CorralDAO implements DAO {

    /**
     * Default constructor
     */
    public CorralDAO() {
    }

    /**
     * 
     */
    private static final String FINDALL = "SELECT * from corral";

    /**
     * 
     */
    private static final String FINBYID = "SELECT * from corral WHERE IdCorral=?";

    /**
     * 
     */
    private static final String INSERT = "INSERT INTO corral (IdCorral,Nombre,Tipo,Censo,Rega) VALUES (?,?,?,?,?)";

    /**
     * 
     */
    private static final String UPDATE = "UPDATE corral SET Nombre=?, Tipo=?, Censo=? WHERE IdCorral=?";

    /**
     * 
     */
    private static final String DELETE = "DELETE FROM corral WHERE IdCorral=?";

    /**
     * 
     */
    private Connection conn;

    /**
     * @param conn
     */
    public void CorralDAO(Connection conn) {
        // TODO implement here
    }

    /**
     * 
     */
    public void CorralDAO() {
        // TODO implement here
    }

    /**
     * Metodo que obtiene todas las entradas de la tabla
     * @throws SQLException
     * @return
     */
    public Set<Corral> findAll() {
        // TODO implement here
        return null;
    }

    /**
     * Metodo que obtiene un objeto de la tabla según su id
     * @throws SQLException
     * @param id 
     * @return
     */
    public Corral findById(String id) {
        // TODO implement here
        return null;
    }

    /**
     * Metodo que agrega o modifica un objeto de la tabla
     * @throws SQLException
     * @param entity 
     * @return
     */
    public Corral save(Corral entity) {
        // TODO implement here
        return null;
    }

    /**
     * Metodo que elimina un objeto de la tabla según su id
     * @throws SQLException
     * @param entity 
     * @return
     */
    public void delete(Corral entity) {
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