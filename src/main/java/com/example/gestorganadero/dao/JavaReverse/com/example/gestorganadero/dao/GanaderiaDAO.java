package com.example.gestorganadero.dao;

import java.util.*;

/**
 * Clase GanaderiaDAO que implementa DAO que contiene todas las consultas a la tabla
 * ganaderia de la base de datos.
 */
public class GanaderiaDAO implements DAO {

    /**
     * Default constructor
     */
    public GanaderiaDAO() {
    }

    /**
     * 
     */
    private static final String FINDALL = "SELECT * from ganaderia";

    /**
     * 
     */
    private static final String FINBYID = "SELECT * from ganaderia WHERE REGA=?";

    /**
     * 
     */
    private static final String INSERT = "INSERT INTO ganaderia (REGA,Nombre,Siglas,Localidad,Provincia,Titular,CensoTotal,SistemaExplotacion,Age) VALUES (?,?,?,?,?,?,?,?,?)";

    /**
     * 
     */
    private static final String UPDATE = "UPDATE ganaderia SET Nombre=?,Siglas=?,Localidad=?,Provincia=?,Titular=?,CensoTotal=?,SistemaExplotacion=?,Age=? WHERE REGA=?";

    /**
     * 
     */
    private static final String DELETE = "DELETE FROM ganaderia WHERE crotal=?";

    /**
     * 
     */
    private static final String ID = "SELECT REGA FROM ganaderia WHERE IdGanadero=?";

    /**
     * 
     */
    private Connection conn;

    /**
     * @param conn
     */
    public void GanaderiaDAO(Connection conn) {
        // TODO implement here
    }

    /**
     * 
     */
    public void GanaderiaDAO() {
        // TODO implement here
    }

    /**
     * Metodo que obtiene todas las entradas de la tabla
     * @throws SQLException
     * @return
     */
    public Set<Ganaderia> findAll() {
        // TODO implement here
        return null;
    }

    /**
     * Metodo que obtiene un objeto de la tabla según su id
     * @throws SQLException
     * @param id 
     * @return
     */
    public Ganaderia findById(String id) {
        // TODO implement here
        return null;
    }

    /**
     * @param idGanadero 
     * @return
     */
    public String obtenerId(String idGanadero) {
        // TODO implement here
        return "";
    }

    /**
     * Metodo que agrega o modifica un objeto de la tabla
     * @throws SQLException
     * @param entity 
     * @return
     */
    public Ganaderia save(Ganaderia entity) {
        // TODO implement here
        return null;
    }

    /**
     * Metodo que elimina un objeto de la tabla según su id
     * @throws SQLException
     * @param entity 
     * @return
     */
    public void delete(Ganaderia entity) {
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