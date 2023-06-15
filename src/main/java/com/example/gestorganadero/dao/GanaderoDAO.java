package com.example.gestorganadero.dao;

import com.example.gestorganadero.connections.ConnectionMySQL;
import com.example.gestorganadero.domain.Ganaderia;
import com.example.gestorganadero.domain.Ganadero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase GanaderoDAO que implementa DAO que contiene todas las consultas a la tabla
 * ganadero de la base de datos.
 */
public class GanaderoDAO implements DAO<Ganadero> {
    private final static String FINDALL ="SELECT * from ganadero";
    private final static String FINBYID ="SELECT * from ganadero WHERE IdGanadero=?";
    private final static String INSERT ="INSERT INTO ganadero (IdGanadero,Dni,Nombre,Apellidos,Telefono,REGA,Password) VALUES (?,?,?,?,?,?,?)";
    private final static String UPDATE ="UPDATE ganadero SET nombre=?, apellidos=?, Telefono=?, Password=? WHERE IdGanadero=?";
    private final static String DELETE = "DELETE FROM ganadero WHERE IdGanadero=?";
    private final static String LOGIN = "SELECT * FROM ganadero WHERE BINARY nombre=? AND Password=?";

    private Connection conn;

    public  GanaderoDAO(Connection conn){
        this.conn = conn;
    }

    public GanaderoDAO(){
        this.conn= ConnectionMySQL.getConnect();
    }

    /**
     * Metodo que obtiene todas las entradas de la tabla
     * @return Todas las entras de la tabla
     * @throws SQLException
     */
    @Override
    public List<Ganadero> findAll() throws SQLException {
        List<Ganadero> result = new ArrayList();
        try(PreparedStatement pst=this.conn.prepareStatement(FINDALL)){
            try(ResultSet res = pst.executeQuery()){
                while(res.next()) {
                    Ganadero g = new Ganadero();
                    g.setIdGanadero(res.getInt("IdGanadero"));
                    g.setDni(res.getString("Dni"));
                    g.setNombre(res.getString("Nombre"));
                    g.setApellidos(res.getString("Apellidos"));
                    g.setTelefono(res.getInt("Telefono"));
                    g.setPassword(res.getString("Password"));
                    result.add(g);
                }
            }
        }
        return result;
    }

    /**
     * Metodo que obtiene un objeto de la tabla según su id
     * @return Ganadero buscado
     * @throws SQLException
     */
    public Ganadero findById(String id) throws SQLException {
        Ganadero result = null;
        try(PreparedStatement pst=this.conn.prepareStatement(FINBYID)){
            pst.setString(1, id);
            try(ResultSet res = pst.executeQuery()){
                if(res.next()) {
                    result = new Ganadero();
                    result.setIdGanadero(res.getInt("IdGanadero"));
                    result.setDni(res.getString("Dni"));
                    result.setNombre(res.getString("Nombre"));
                    result.setApellidos(res.getString("Apellidos"));
                    result.setTelefono(res.getInt("Telefono"));
                    result.setPassword(res.getString("Password"));
                }
            }
        }
        return result;
    }

    public int login(String user, String passwd) {
        int state = -1;

        try(PreparedStatement pst=this.conn.prepareStatement(LOGIN)){
            pst.setString(1, user);
            pst.setString(2, passwd);
            try(ResultSet res = pst.executeQuery()){
                if(res.next()){
                    state = 1;
                }else {
                    state = 0;
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return state;
    }

    /**
     * Metodo que agrega o modifica un objeto de la tabla
     * @return Ganadero agregado/modificado
     * @throws SQLException
     */
    public Ganadero save(Ganadero entity) throws SQLException {
        Ganadero result = new Ganadero();
        if (entity != null) {
            Ganadero g = findById(String.valueOf(entity.getIdGanadero()));
            if (g == null) {
                //INSERT
                try (PreparedStatement pst = this.conn.prepareStatement(INSERT)) {
                    pst.setInt(1, entity.getIdGanadero());//Puede que sobre al ser  autoincrement
                    pst.setString(2, entity.getDni());
                    pst.setString(3, entity.getNombre());
                    pst.setString(4, entity.getApellidos());
                    pst.setInt(5, entity.getTelefono());
                    pst.setString(6, entity.getPassword());
                    pst.executeUpdate();
                }
            }else{
                //UPDATE
                try (PreparedStatement pst = this.conn.prepareStatement(UPDATE)) {
                    pst.setString(1, entity.getNombre());
                    pst.setString(2, entity.getApellidos());
                    pst.setInt(3, entity.getTelefono());
                    pst.setString(4, entity.getPassword());
                    pst.setInt(5, entity.getIdGanadero());
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
    public void delete(Ganadero entity) throws SQLException {
        if (entity != null) {
            try (PreparedStatement pst = this.conn.prepareStatement(DELETE)) {
                pst.setInt(1, entity.getIdGanadero());
                pst.executeUpdate();
            }
        }
    }

    private GanaderiaDAO ganaderiadao;
    public List<Ganaderia>findGanaderias(Ganadero g) throws SQLException {
        ganaderiadao = new GanaderiaDAO();
        List<Ganaderia> ganaderias = ganaderiadao.findAll();
        List<Ganaderia> misGanaderias = null;
        for (Ganaderia ganaderia:ganaderias) {
            if (g == ganaderia.getOwner()){
                misGanaderias.add(ganaderia);
            }
        }
        return  misGanaderias;
    }

    public void close() throws Exception {

    }
}