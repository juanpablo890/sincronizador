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
    private final String SQL_INSERT = "INSERT INTO avl.tblDescargasAVL VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public DescargaAVLDAO() {

    }

    //Inserta un registro en la tabla [avl].[tblDescargasAVL] BD: DBINTERMEDIA a partir de un objeto DescargaAVL
    public boolean insert(DescargaAVL d, Connection DBConnection, PreparedStatement prepareStatement) {
        try {
            
            prepareStatement.setLong(1, d.getId());
            prepareStatement.setInt(2, d.getTipoAVL());
            prepareStatement.setString(3, d.getModemID());
            prepareStatement.setString(4, d.getNoSerieAVLOriginal());
            prepareStatement.setDouble(5, d.getfLongitud_grad());
            prepareStatement.setDouble(6, d.getfLalitud_grad());
            prepareStatement.setInt(7, d.getVelocidad());
            prepareStatement.setInt(8, d.getAltitud());
            prepareStatement.setInt(9, d.getNum_Sat());
            prepareStatement.setInt(10, d.getHeading());
            prepareStatement.setTimestamp(11, d.getdFecha_hora_Sat());
            prepareStatement.setInt(12, d.getTipo_evento());
            prepareStatement.setInt(13, d.getVariable1());
            prepareStatement.setInt(14, d.getVariable2());
            prepareStatement.setInt(15, d.getVariable3());
            prepareStatement.setInt(16, d.getVariable4());
            prepareStatement.setTimestamp(17, d.getdFechaHoraComputadora());
            prepareStatement.setInt(18, d.getVarControl());
            prepareStatement.setInt(19, d.getStatus());
//            if(d.getId() == 143330473 || d.getId() == 143330475){
//            throw new SQLException();
//            }
            prepareStatement.addBatch();

            
        } catch (SQLException ex) {
            Logger.getLogger(DescargaAVLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
//        return false;
    }

    public String getSQL_INSERT() {
        return SQL_INSERT;
    }
    
    
}
