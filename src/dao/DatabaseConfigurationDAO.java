/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.DatabaseConfiguration;
import pojos.RangoAVL;

/**
 *
 * @author n6y
 */
public class DatabaseConfigurationDAO {

private final String SQL_INSERT = "INSERT INTO motor.config_motor_tisa VALUES (?,?,?,?,?,?,?,?,?)";
private final String SQL_UPDATE = "UPDATE motor.config_motor_tisa SET database_alias = ?, database_name = ?, username = ?, password= ?, server = ?, port = ?, synchronization_frec_segs = ?, records_quantity = ?, sgbd = ? WHERE id = ?";
private final String SQL_SELECT_ID_BY_ALIAS = "SELECT id FROM motor.config_motor_tisa WHERE database_alias = ?";
    public DatabaseConfigurationDAO() {

    }

    //Inserta un registro en la tabla [motor].[config_motor_tisa] BD: DBINTERMEDIA a partir de un objeto DatabaseConfiguration
    public void insert(DatabaseConfiguration dbc, PreparedStatement prepareStatement) throws SQLException {

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
    
    public void update(DatabaseConfiguration dbc, PreparedStatement prepareStatement) throws SQLException {

            prepareStatement.setString(1, dbc.getDatabase_alias());
            prepareStatement.setString(2, dbc.getDatabase_name());
            prepareStatement.setString(3, dbc.getUsername());
            prepareStatement.setString(4, dbc.getPassword());
            prepareStatement.setString(5, dbc.getServer());
            prepareStatement.setInt(6, dbc.getPort());
            prepareStatement.setInt(7, dbc.getSynchronization_frec_segs());
            prepareStatement.setInt(8, dbc.getRecords_quantity());
            prepareStatement.setString(9, dbc.getSgbd());
            prepareStatement.setInt(10, dbc.getId());
            prepareStatement.executeUpdate();
        
    }
    
//    public RangoAVL selectByID(DatabaseConfiguration d, PreparedStatement prepareStatement) {
//
//        try {
//            prepareStatement.setLong(1, d.getId());
//            ResultSet executeQuery = prepareStatement.executeQuery();
//            return new DatabaseConfiguration(executeQuery);
//        } catch (SQLException ex) {
//            Logger.getLogger(RangoAVLDAO.class.getName()).log(Level.SEVERE, null, ex);
//            return null;
//        }
//    }

    public String getSQL_INSERT() {
        return SQL_INSERT;
    }

    public String getSQL_UPDATE() {
        return SQL_UPDATE;
    }
    
    
    
}
