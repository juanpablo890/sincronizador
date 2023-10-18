/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.DatabaseConfiguration;

/**
 *
 * @author n6y
 */
public class DatabaseConfigurationDAO {

private final String SQL_INSERT = "INSERT INTO motor.config_motor_tisa VALUES (?,?,?,?,?,?,?,?,?)";
    public DatabaseConfigurationDAO() {

    }

    //Inserta un registro en la tabla [motor].[config_motor_tisa] BD: DBINTERMEDIA a partir de un objeto DatabaseConfiguration
    public void insert(DatabaseConfiguration dbc, Connection DBConnection, PreparedStatement prepareStatement) throws SQLException {
     
            
            
            prepareStatement.setString(1, dbc.getDatabase_alias());
            prepareStatement.setString(2, dbc.getDatabase_name());
            prepareStatement.setString(3, dbc.getUsername());
            prepareStatement.setString(4, dbc.getPassword());
            prepareStatement.setString(5, dbc.getServer());
            prepareStatement.setInt(6, dbc.getPort());
            prepareStatement.setInt(7, dbc.getSynchronization_frec_segs());
            prepareStatement.setInt(8, dbc.getRecords_quantity());
            prepareStatement.setString(9, dbc.getSgbd());
            
            prepareStatement.execute();
        
    }

    public String getSQL_INSERT() {
        return SQL_INSERT;
    }
    
    
}
