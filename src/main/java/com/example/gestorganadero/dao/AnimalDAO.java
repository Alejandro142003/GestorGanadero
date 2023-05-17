package com.example.gestorganadero.dao;

import com.example.gestorganadero.domain.Animal;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.gestorganadero.connections.ConnectionMySQL;

public class AnimalDAO implements DAO<Animal> {
    private final static String FINDALL ="SELECT * from animal";
    private final static String FINBYID ="SELECT * from animal WHERE crotal=?";
    private final static String INSERT ="INSERT INTO animal (Crotal,CrotalMadre,CrotalPadre,Lactancia,Vacuna,Edad,NumeroHijos,Sexo,IdCorral) VALUES (?,?,?,?,?,?,?,?)";
    private final static String UPDATE ="UPDATE animal SET Lactancia=?, Vacuna=?, Edad=?, NumeroHijos=?,IdCorral=? WHERE Crotal=?";

    private Connection conn;
    public AnimalDAO(Connection conn){
        this.conn = conn;
    }
    public AnimalDAO(){
        this.conn=ConnectionMySQL.getConnect();
    }

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
                    a.setMadre(res.getInt("Madre"));
                    a.setPadre(res.getInt("Padre"));
                    a.setVacuna(res.getString("Vacuna"));
                    result.add(a);
                }
            }
        }
        return result;
    }

    @Override
    public Animal findById(String id) throws SQLException {
        return null;
    }

    @Override
    public Animal save(Animal entity) throws SQLException {
        return null;
    }

    @Override
    public void delete(Animal entity) throws SQLException {

    }

    @Override
    public void close() throws Exception {

    }
}
