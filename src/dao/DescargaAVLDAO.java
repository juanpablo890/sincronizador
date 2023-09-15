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
import pojos.DescargaAVL;

/**
 *
 * @author n6y
 */
public class DescargaAVLDAO {
    private final String SQL_INSERT = "INSERT INTO avl.tblDescargasAVL VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public DescargaAVLDAO() {

    }

    //Inserta un registro en la tabla [avl].[tblDescargasAVL] BD: DBINTERMEDIA a partir de un objeto DescargaAVL
    public void insert(DescargaAVL d, Connection DBConnection, PreparedStatement prepareStatement) {
        try {
            
            prepareStatement.setLong(1, d.getId());
            prepareStatement.setInt(2, d.getTipoAVL());
            prepareStatement.setString(3, d.getModemID());
            prepareStatement.setDouble(4, d.getfLongitud_grad());
            prepareStatement.setDouble(5, d.getfLalitud_grad());
            prepareStatement.setInt(6, d.getVelocidad());
            prepareStatement.setInt(7, d.getAltitud());
            prepareStatement.setInt(8, d.getNum_Sat());
            prepareStatement.setInt(9, d.getHeading());
            prepareStatement.setTimestamp(10, d.getdFecha_hora_Sat());
            prepareStatement.setInt(11, d.getTipo_evento());
            prepareStatement.setInt(12, d.getVariable1());
            prepareStatement.setInt(13, d.getVariable2());
            prepareStatement.setInt(14, d.getVariable3());
            prepareStatement.setInt(15, d.getVariable4());
            prepareStatement.setTimestamp(16, d.getdFechaHoraComputadora());
            prepareStatement.setInt(17, d.getVarControl());
            prepareStatement.setInt(18, d.getStatus());
            prepareStatement.addBatch();
        } catch (SQLException ex) {
            Logger.getLogger(DescargaAVLDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getSQL_INSERT() {
        return SQL_INSERT;
    }
    
    
}
