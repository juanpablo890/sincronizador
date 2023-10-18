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
import pojos.FimpeDEBITO;

/**
 *
 * @author n6y
 */
public class FimpeDEBITODAO {

    private String SQL_INSERT = "INSERT INTO dbo.tableName VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public FimpeDEBITODAO(String tableName) {
        SQL_INSERT = SQL_INSERT.replace("tableName", tableName);
    }

    //Inserta un registro en la tabla [dbo].[tmpTblFIMPE...] BD: DBFIMPETISA a partir de un objeto FimpeDEBITO
    public boolean insert(FimpeDEBITO d, Connection DBConnection, PreparedStatement prepareStatement) {
        
        try {
            prepareStatement.setString(1, d.getIntNumArch());
            prepareStatement.setLong(2, d.getId());
            prepareStatement.setInt(3, d.getIntTipoTarjeta());
            prepareStatement.setInt(4, d.getIntTipoEventoTarjeta());
            prepareStatement.setInt(5, d.getIntIDProducto());
            prepareStatement.setInt(6, d.getIdSIR());
            prepareStatement.setInt(7, d.getIdEmpresa());
            prepareStatement.setString(8, d.getCorredor());
            prepareStatement.setString(9, d.getfIdentidad());
            prepareStatement.setString(10, d.getC1());
            prepareStatement.setString(11, d.getC2());
            prepareStatement.setString(12, d.getC3());
            prepareStatement.setString(13, d.getC4());
            prepareStatement.setBigDecimal(14, d.getC5());
            prepareStatement.setBigDecimal(15, d.getC6());
            prepareStatement.setBigDecimal(16, d.getC7());
            prepareStatement.setString(17, d.getC8());
            prepareStatement.setString(18, d.getC9());
            prepareStatement.setString(19, d.getC10());
            prepareStatement.setInt(20, d.getC11());
            prepareStatement.setBigDecimal(21, d.getC12());
            prepareStatement.setBigDecimal(22, d.getC13());
            prepareStatement.setString(23, d.getC14());
            prepareStatement.setString(24, d.getC15());
            prepareStatement.setString(25, d.getC16());
            prepareStatement.setString(26, d.getC17());
            prepareStatement.setString(27, d.getC172());
            prepareStatement.setString(28, d.getC18());
            prepareStatement.setInt(29, d.getEstatus());

            prepareStatement.addBatch();
        } catch (SQLException ex) {
            Logger.getLogger(FimpeDEBITODAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public String getSQL_INSERT() {
        return SQL_INSERT;
    }

}
