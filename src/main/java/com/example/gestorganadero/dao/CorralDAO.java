package com.example.gestorganadero.dao;

import com.example.gestorganadero.connections.ConnectionMySQL;
import com.example.gestorganadero.domain.Corral;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase CorralDAO que implementa DAO que contiene todas las consultas a la tabla
 * corral de la base de datos.
 */
public class CorralDAO implements DAO<Corral> {
    private final static String FINDALL ="SELECT * from corral";
    private final static String FINBYID ="SELECT * from corral WHERE IdCorral=?";
    private final static String INSERT ="INSERT INTO corral (IdCorral,Nombre,Tipo,Censo) VALUES (?,?,?,?)";
    private final static String UPDATE ="UPDATE corral SET Nombre=?, Tipo=?, Censo=? WHERE IdCorral=?";
    private final static String DELETE = "DELETE FROM corral WHERE IdCorral=?";

    private Connection conn;

    public  CorralDAO(Connection conn){
        this.conn = conn;
    }

    public CorralDAO(){
        this.conn= ConnectionMySQL.getConnect();
    }

    /**
     * Metodo que obtiene todas las entradas de la tabla
     * @return Todas las entras de la tabla
     * @throws SQLException
     */
    @Override
    public List<Corral> findAll() throws SQLException {
        List<Corral> result = new ArrayList();
        try(PreparedStatement pst=this.conn.prepareStatement(FINDALL)){
            try(ResultSet res = pst.executeQuery()){
                while(res.next()) {
                    Corral c = new Corral();
                    c.setIdCorral(res.getInt("IdCorral"));
                    c.setNombre(res.getString("Nombre"));
                    c.setTipo(res.getString("Tipo"));
                    c.setCenso(res.getInt("Censo"));
                    result.add(c);
                }
            }
        }
        return result;
    }

    /**
     * Metodo que obtiene un objeto de la tabla según su id
     * @return Corral buscado
     * @throws SQLException
     */
    @Override
    public Corral findById(String id) throws SQLException {
        Corral result = null;
        try(PreparedStatement pst=this.conn.prepareStatement(FINBYID)){
            pst.setString(1, id);
            try(ResultSet res = pst.executeQuery()){
                if(res.next()) {
                    result.setIdCorral(res.getInt("IdCorral"));
                    result.setNombre(res.getString("Nombre"));
                    result.setTipo(res.getString("Tipo"));
                    result.setCenso(res.getInt("Censo"));
                }
            }
        }
        return result;
    }

    /**
     * Metodo que agrega o modifica un objeto de la tabla
     * @return Corral agregado/modificado
     * @throws SQLException
     */
    @Override
    public Corral save(Corral entity) throws SQLException {
        Corral result = new Corral();
        if (entity != null) {
            Corral c = findById(String.valueOf(entity.getIdCorral()));
            if (c == null) {
                //INSERT
                try (PreparedStatement pst = this.conn.prepareStatement(INSERT)) {
                    pst.setInt(1, entity.getIdCorral());
                    pst.setString(2, entity.getNombre());
                    pst.setString(3, entity.getTipo());
                    pst.setInt(4, entity.getCenso());
                    pst.executeUpdate();
                }
            }else{
                //UPDATE
                try (PreparedStatement pst = this.conn.prepareStatement(UPDATE)) {
                    pst.setString(1, entity.getNombre());
                    pst.setString(2, entity.getTipo());
                    pst.setInt(3, entity.getCenso());
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
    public void delete(Corral entity) throws SQLException {
        if (entity != null) {
            try (PreparedStatement pst = this.conn.prepareStatement(DELETE)) {
                pst.setInt(1, entity.getIdCorral());
                pst.executeUpdate();
            }
        }
    }

    @Override
    public void close() throws Exception {

    }
}