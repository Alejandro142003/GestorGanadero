package com.example.gestorganadero.dao;

import java.util.*;

/**
 * Clase GanaderoDAO que implementa DAO que contiene todas las consultas a la tabla
 * ganadero de la base de datos.
 */
public class GanaderoDAO implements DAO {

    /**
     * Default constructor
     */
    public GanaderoDAO() {
    }

    /**
     * 
     */
    private static final String FINDALL = "SELECT * from ganadero";

    /**
     * 
     */
    private static final String FINBYID = "SELECT * from ganadero WHERE IdGanadero=?";

    /**
     * 
     */
    private static final String INSERT = "INSERT INTO ganadero (IdGanadero,Dni,Nombre,Apellidos,Telefono,REGA,Password) VALUES (?,?,?,?,?,?,?)";

    /**
     * 
     */
    private static final String UPDATE = "UPDATE ganadero SET nombre=?, apellidos=?, Telefono=?, Password=? WHERE IdGanadero=?";

    /**
     * 
     */
    private static final String DELETE = "DELETE FROM ganadero WHERE IdGanadero=?";

    /**
     * 
     */
    private static final String LOGIN = "SELECT * FROM ganadero WHERE BINARY nombre=? AND Password=?";

    /**
     * 
     */
    private static final String ID = "SELECT IdGanadero FROM ganadero WHERE nombre=? AND Password=?";

    /**
     * 
     */
    private Connection conn;

    /**
     * @param conn
     */
    public void GanaderoDAO(Connection conn) {
        // TODO implement here
    }

    /**
     * 
     */
    public void GanaderoDAO() {
        // TODO implement here
    }

    /**
     * Metodo que obtiene todas las entradas de la tabla
     * @throws SQLException
     * @return
     */
    public Set<Ganadero> findAll() {
        // TODO implement here
        return null;
    }

    /**
     * Metodo que obtiene un objeto de la tabla según su id
     * @throws SQLException
     * @param id 
     * @return
     */
    public Ganadero findById(String id) {
        // TODO implement here
        return null;
    }

    /**
     * @param user 
     * @param passwd 
     * @return
     */
    public String obtenerId(String user, String passwd) {
        // TODO implement here
        return "";
    }

    /**
     * @param user 
     * @param passwd 
     * @return
     */
    public int login(String user, String passwd) {
        // TODO implement here
        return 0;
    }

    /**
     * Metodo que agrega o modifica un objeto de la tabla
     * @throws SQLException
     * @param entity 
     * @return
     */
    public Ganadero save(Ganadero entity) {
        // TODO implement here
        return null;
    }

    /**
     * Metodo que elimina un objeto de la tabla según su id
     * @throws SQLException
     * @param entity 
     * @return
     */
    public void delete(Ganadero entity) {
        // TODO implement here
        return null;
    }

    /**
     * @param g 
     * @return
     */
    public Set<Ganaderia> findGanaderias(Ganadero g) {
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