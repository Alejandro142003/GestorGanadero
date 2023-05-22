package com.example.gestorganadero.dao;

import java.sql.SQLException;
import java.util.List;

/**
 * Interfaces para la implementación de los DAO
 * @param <T> Clase que va a usar DAO
 */
public interface DAO<T> extends AutoCloseable {
    List<T> findAll() throws SQLException;
    T findById(String id) throws SQLException;
    T save(T entity) throws SQLException;
    void delete(T entity) throws SQLException;
}
