package com.example.gestorganadero.dao;

import com.example.gestorganadero.domain.Animal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.example.gestorganadero.connections.ConnectionMySQL;

/**
 * Clase AnimalDAO que implementa DAO que contiene todas las consultas a la tabla
 * animal de la base de datos.
 */
public class AnimalDAO implements DAO<Animal> {
    private final static String FINDALL ="SELECT * from animal";
    private final static String FINBYID ="SELECT * from animal WHERE crotal=?";
    private final static String INSERT ="INSERT INTO animal (Crotal,CrotalMadre,CrotalPadre,Lactancia,Vacuna,Edad,NumeroHijos,Sexo,IdCorral) VALUES (?,?,?,?,?,?,?,?,?)";
    private final static String UPDATE ="UPDATE animal SET Lactancia=?, Vacuna=?, Edad=?, NumeroHijos=?,IdCorral=? WHERE Crotal=?";
    private final static String DELETE = "DELETE FROM ganaderoA WHERE crotal=?";

    private Connection conn;
    public AnimalDAO(Connection conn){
        this.conn = conn;
    }
    public AnimalDAO(){
        this.conn=ConnectionMySQL.getConnect();
    }

    /**
     * Metodo que obtiene todas las entradas de la tabla
     * @return Todas las entras de la tabla
     * @throws SQLException
     */
    @Override
    public List<Animal> findAll() throws SQLException {
        List<Animal> result = new ArrayList();
        try(PreparedStatement pst=this.conn.prepareStatement(FINDALL)){
            try(ResultSet res = pst.executeQuery()){
                while(res.next()) {
                    Animal a = new Animal();
                    a.setCrotal(res.getInt("Crotal"));
                    a.setEdad(res.getInt("Edad"));
                    a.setHijos(res.getInt("NumeroHijos"));
                    a.setLactancia(res.getFloat("Lactancia"));
                    a.setMadre(res.getInt("CrotalMadre"));
                    a.setPadre(res.getInt("CrotalPadre"));
                    a.setVacuna(res.getString("Vacuna"));
                    a.setSexo(res.getString("Sexo"));
                    a.setIdCorral(res.getInt("IdCorral"));
                    result.add(a);
                }
            }
        }
        return result;
    }

    /**
     * Metodo que obtiene un objeto de la tabla según su id
     * @return Animal buscado
     * @throws SQLException
     */
    public Animal findById(String id) throws SQLException {
        Animal result = null;
        try(PreparedStatement pst=this.conn.prepareStatement(FINBYID)){
            pst.setString(1, id);
            try(ResultSet res = pst.executeQuery()){
                if(res.next()) {
                    result = new Animal();
                    result.setCrotal(res.getInt("Crotal"));
                    result.setEdad(res.getInt("Edad"));
                    result.setHijos(res.getInt("NumeroHijos"));
                    result.setLactancia(res.getFloat("Lactancia"));
                    result.setMadre(res.getInt("Madre"));
                    result.setPadre(res.getInt("Padre"));
                    result.setVacuna(res.getString("Vacuna"));
                    result.setSexo(res.getString("Sexo"));
                    result.setIdCorral(res.getInt("IdCorral"));
                }
            }
        }
        return result;
    }

    /**
     * Metodo que agrega o modifica un objeto de la tabla
     * @return Animal agregado/modificado
     * @throws SQLException
     */
    public Animal save(Animal entity) throws SQLException {
        Animal result = new Animal();
        if (entity != null) {
            Animal a = findById(String.valueOf(entity.getCrotal()));
            if (a == null) {
                //INSERT
                try (PreparedStatement pst = this.conn.prepareStatement(INSERT)) {
                    pst.setInt(1, entity.getCrotal());
                    pst.setInt(2, entity.getEdad());
                    pst.setInt(3, entity.getHijos());
                    pst.setFloat(4, entity.getLactancia());
                    pst.setInt(5, entity.getMadre());
                    pst.setInt(6, entity.getPadre());
                    pst.setString(7, entity.getVacuna());
                    pst.setString(8, entity.getSexo());
                    pst.setInt(8, entity.getIdCorral());
                    pst.executeUpdate();
                }
            }else{
                //UPDATE
                try (PreparedStatement pst = this.conn.prepareStatement(UPDATE)) {
                    pst.setInt(1, entity.getEdad());
                    pst.setInt(2, entity.getHijos());
                    pst.setFloat(3, entity.getLactancia());
                    pst.setString(4, entity.getVacuna());
                    pst.setInt(5,entity.getIdCorral());
                    pst.executeUpdate();
                }
            }
            result = entity;
        }
        return result;
    }

    /**
     * Metodo que elimina un objeto de la tabla según su id
     * @throws SQLException
     */
    @Override
    public void delete(Animal entity) throws SQLException {
        if (entity != null) {
            try (PreparedStatement pst = this.conn.prepareStatement(DELETE)) {
                pst.setInt(1, entity.getCrotal());
                pst.executeUpdate();
            }
        }
    }

    @Override
    public void close() throws Exception {

    }
}
