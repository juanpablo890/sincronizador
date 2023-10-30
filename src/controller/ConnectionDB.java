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

    private HashMap conexionData;

    public Connection DBConnection() throws SQLException, IOException {
        conexionData = new ConfigurationFile().readConfigurationFile(); //leer archivo properties
        Connection conn = null;
        System.out.println("Sistema: " + String.valueOf(conexionData.get("sgbd")));
        switch (String.valueOf(conexionData.get("sgbd"))) {
            case "sqlserver":
                conn = DriverManager.getConnection( //obtener datos de la bd (tabla de configuración)
                        "jdbc:sqlserver://" + conexionData.get("server") + ":" + conexionData.get("port") + ";database=" + conexionData.get("database") + ";user=" + conexionData.get("username") + ";password=" + conexionData.get("password") + ";" + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;");
                System.out.println("conexion" + conn.toString());
                break;

            case "postgresql":
                conn = DriverManager.getConnection(
                        "jdbc:postgresql://" + String.valueOf(conexionData.get("server")) + ":" + String.valueOf(conexionData.get("port")) + "/"
                        + String.valueOf(conexionData.get("database")), String.valueOf(conexionData.get("username")), String.valueOf(conexionData.get("password")));
                break;

            default:
                break;
        }

        return conn;
    }

    public Connection DBConnection(String sgbd, String server, String port, String database, String username, String password) throws SQLException {
        System.out.println("trying to connect to database...");
        Connection conn = null;
        switch (sgbd) {
            case "sqlserver":
//                conn = DriverManager.getConnection( //obtener datos de la bd (tabla de configuración)
//                        "jdbc:sqlserver://" + server + ":" + port + ";database=" + database + ";user=" + username + ";password=" + password + ";" + "encrypt=true;"
//                        + "trustServerCertificate=true;"
//                        + "loginTimeout=30;" + "allowMultiQueries=true");
                conn = DriverManager.getConnection( //obtener datos de la bd (tabla de configuración)
                        "jdbc:sqlserver://" + server + ":" + port + ";database=" + database + ";user=" + username + ";password=" + password + ";" + "encrypt=true;"
                        + "trustServerCertificate=true;"
                        + "loginTimeout=30;");
                break;

            case "postgresql":
                conn = DriverManager.getConnection(
                        "jdbc:postgresql://" + server + ":" + port + "/" + database, username, password);
                break;

            default:
                System.out.println("error de conexión a la base de datos");
                break;
        }

        return conn;

    }

    public void abortConnection(Connection conn) throws SQLException {
        conn.abort(runnable -> new Thread(runnable).start());
    }

    public Object getRecordsCount() {
        return conexionData.get("records_count");
    }

    public HashMap getConexionData() {
        return conexionData;
    }

}
