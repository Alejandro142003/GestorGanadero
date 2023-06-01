package com.example.gestorganadero.dao;

import com.example.gestorganadero.connections.ConnectionMySQL;
import com.example.gestorganadero.domain.Ganaderia;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase GanaderiaDAO que implementa DAO que contiene todas las consultas a la tabla
 * ganaderia de la base de datos.
 */
public class GanaderiaDAO implements DAO<Ganaderia>{

    private final static String FINDALL ="SELECT * from ganaderia";
    private final static String FINBYID ="SELECT * from ganaderia WHERE REGA=?";
    private final static String INSERT ="INSERT INTO ganaderia (REGA,Nombre,Siglas,Localidad,Provincia,Titular,CensoTotal,SistemaExplotacion,Age) VALUES (?,?,?,?,?,?,?,?,?)";
    private final static String UPDATE ="UPDATE ganaderia SET Nombre=?,Siglas=?,Localidad=?,Provincia=?,Titular=?,CensoTotal=?,SistemaExplotacion=?,Age=? WHERE REGA=?";
    private final static String DELETE = "DELETE FROM ganaderoA WHERE crotal=?";


    private Connection conn;
    public GanaderiaDAO(Connection conn){
        this.conn = conn;
    }
    public GanaderiaDAO(){
        this.conn = ConnectionMySQL.getConnect();
    }

    /**
     * Metodo que obtiene todas las entradas de la tabla
     * @return Todas las entras de la tabla
     * @throws SQLException
     */
    public List<Ganaderia> findAll() throws SQLException {
        List<Ganaderia> result = new ArrayList();
        try(PreparedStatement pst=this.conn.prepareStatement(FINDALL)){
            try(ResultSet res = pst.executeQuery()){
                while(res.next()) {
                    Ganaderia g = new Ganaderia();
                    g.setRega(res.getString("REGA"));
                    g.setNombre(res.getString("Nombre"));
                    g.setSiglas(res.getString("Siglas"));
                    g.setLocalidad(res.getString("Localidad"));
                    g.setProvincia(res.getString("Provincia"));
                    g.setProvincia(res.getString("Titular"));
                    g.setCensoTotal(res.getInt("CensoTotal"));
                    g.setSistemaExplotacion(res.getString("SistemaExplotacion"));
                    g.setAge(res.getInt("Age"));
                    result.add(g);
                }
            }
        }
        return result;
    }

    /**
     * Metodo que obtiene un objeto de la tabla según su id
     * @return Ganaderia buscada
     * @throws SQLException
     */
    public Ganaderia findById(String id) throws SQLException {
        Ganaderia result = null;
        try(PreparedStatement pst=this.conn.prepareStatement(FINBYID)){
            pst.setString(1, id);
            try(ResultSet res = pst.executeQuery()){
                if(res.next()) {
                    result = new Ganaderia();
                    result.setRega(res.getString("REGA"));
                    result.setNombre(res.getString("Nombre"));
                    result.setSiglas(res.getString("Siglas"));
                    result.setLocalidad(res.getString("Localidad"));
                    result.setProvincia(res.getString("Provincia"));
                    result.setProvincia(res.getString("Titular"));
                    result.setCensoTotal(res.getInt("CensoTotal"));
                    result.setSistemaExplotacion(res.getString("SistemaExplotacion"));
                    result.setAge(res.getInt("Age"));
                }
            }
        }
        return result;
    }

    /**
     * Metodo que agrega o modifica un objeto de la tabla
     * @return Ganaderia agregada/modificada
     * @throws SQLException
     */
    public Ganaderia save(Ganaderia entity) throws SQLException {
        Ganaderia result = new Ganaderia();
        if (entity != null) {
            Ganaderia g = findById(String.valueOf(entity.getRega()));
            if (g == null) {
                //INSERT
                try (PreparedStatement pst = this.conn.prepareStatement(INSERT)) {
                    pst.setString(1, entity.getRega());
                    pst.setString(2, entity.getNombre());
                    pst.setString(3, entity.getSiglas());
                    pst.setString(4, entity.getLocalidad());
                    pst.setString(5, entity.getProvincia());
                    pst.setString(6, entity.getTitular());
                    pst.setInt(7, entity.getCensoTotal());
                    pst.setString(8, entity.getSistemaExplotacion());
                    pst.setInt(9, entity.getAge());
                    pst.executeUpdate();
                }
            }else{
                //UPDATE
                try (PreparedStatement pst = this.conn.prepareStatement(UPDATE)) {
                    pst.setString(1, entity.getNombre());
                    pst.setString(2, entity.getSiglas());
                    pst.setString(3, entity.getLocalidad());
                    pst.setString(4, entity.getProvincia());
                    pst.setString(5, entity.getTitular());
                    pst.setInt(6, entity.getCensoTotal());
                    pst.setString(7, entity.getSistemaExplotacion());
                    pst.setInt(8, entity.getAge());
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
    public void delete(Ganaderia entity) throws SQLException {
        if (entity != null) {
            try (PreparedStatement pst = this.conn.prepareStatement(DELETE)) {
                pst.setString(1, entity.getRega());
                pst.executeUpdate();
            }
        }
    }

    @Override
    public void close() throws Exception {

    }
}
