package com.example.gestorganadero.connections;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class ConnectionMySQL {

    private String file = "conexion.xml";

    private static ConnectionMySQL _newInstance;

    private static Connection conn;

    public ConnectionMySQL() {
        ConnectionData dc = loadXML();

        try{
            conn = DriverManager.getConnection(dc.getServer() + "/" + dc.getDatabase(), dc.getUsername(), dc.getPassword());
        }catch (SQLException e){
            conn = null;
            e.printStackTrace();
        }
    }

    public static Connection getConnect(){
        if (_newInstance == null) {
            _newInstance = new ConnectionMySQL();
        }
        return conn;
    }

    /**
     * Metodo para los datos de la conexion
     * @return objeto CoonnectionData con los datos leidos
     */
    public ConnectionData loadXML() {
        ConnectionData con = new ConnectionData();
        JAXBContext jaxbContext;
        try {
            jaxbContext = JAXBContext.newInstance(ConnectionData.class);
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            ConnectionData newR = (ConnectionData) jaxbUnmarshaller.unmarshal(new File(file));
            con = newR;
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return con;
    }
}
