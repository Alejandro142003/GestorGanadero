package com.example.gestorganadero.dao;

import java.util.*;

/**
 * Interfaces para la implementación de los DAO
 * @param <T> Clase que va a usar DAO
 */
public interface DAO extends AutoCloseable {

    /**
     * @return
     */
    Set<T> findAll();

    /**
     * @param id 
     * @return
     */
    T findById(String id);

    /**
     * @param entity 
     * @return
     */
    T save(T entity);

    /**
     * @param entity 
     * @return
     */
    void delete(T entity);

}