package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.IOException;
import java.lang.System.Logger;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.HashMap;

/**
 *
 * @author n6y
 */
public class ConnectionDB {

    public Connection DBConnection() throws SQLException, IOException {
        HashMap conexionData = new ConfigurationFile().readConfigurationFile();

        

            Connection conn = DriverManager.getConnection( //obtener datos de la bd (tabla de configuración)
                    "jdbc:sqlserver://" + conexionData.get("server") + ":" + conexionData.get("port") + ";database=" + conexionData.get("database") + ";user=" + conexionData.get("username") + ";password=" + conexionData.get("password") + ";" + "encrypt=true;"
                    + "trustServerCertificate=true;"
                    + "loginTimeout=30;");
            System.out.println("conexion" + conn.toString());

            return conn;
    }

    public Connection DBConnection(String server, String port, String database, String username, String password) throws SQLException {
        Connection conn = DriverManager.getConnection( //obtener datos de la bd (tabla de configuración)
                "jdbc:sqlserver://" + server + ":" + port + ";database=" + database + ";user=" + username + ";password=" + password + ";" + "encrypt=true;"
                + "trustServerCertificate=true;"
                + "loginTimeout=30;");
        System.out.println("conexion" + conn.toString());
        return conn;

    }

}
