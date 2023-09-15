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
import pojos.DescargaPOS;

/**
 *
 * @author n6y
 */
public class DescargaPOSDAO {

private final String SQL_INSERT = "INSERT INTO avl.tblDescargasPOS VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public DescargaPOSDAO() {

    }

    //Inserta un registro en la tabla [avl].[tblDescargasTDE] BD: DBINTERMEDIA a partir de un objeto DescargaTDE
    public void insert(DescargaPOS d, Connection DBConnection, PreparedStatement prepareStatement) {
        try {
            
            prepareStatement.setLong(1, d.getId());
            prepareStatement.setLong(2, d.getId_DGPRS());
            prepareStatement.setString(3, d.getStrValidador());
            prepareStatement.setString(4, d.getStrIDTarjeta());
            prepareStatement.setInt(5, d.getIntTipoTarjeta());
            prepareStatement.setInt(6, d.getIntTipoEventoTarjeta());
            prepareStatement.setInt(7, d.getIntSaldoInicialTarjeta());
            prepareStatement.setInt(8, d.getIntSaldoFinalTarjeta());
            prepareStatement.setTimestamp(9, d.getdFechaEventoTarjeta());
            prepareStatement.setInt(10, d.getIntIDPuntoVenta());
            prepareStatement.setInt(11, d.getIntFolioVenta());
            prepareStatement.setInt(12, d.getIntVarControl());
            prepareStatement.setInt(13, d.getIntStatus());
            prepareStatement.setTimestamp(14, d.getdFechaAVL());
            prepareStatement.setInt(15, d.getIntNumOperador());
            prepareStatement.setInt(16, d.getIntFolioTarjeta());
             prepareStatement.setString(17, d.getIdFrameEvento());
            prepareStatement.setInt(18, d.getIntRuta());
            prepareStatement.setInt(19, d.getIntContadorCiclicoTrans());
            prepareStatement.setInt(20, d.getIntIDProducto());
            prepareStatement.setInt(21, d.getIntEntidad());
             prepareStatement.setString(22, d.getStrIDSAM());
            prepareStatement.setInt(23, d.getIntIdEvento());
            prepareStatement.setInt(24, d.getIntSaldoUltimaRecarga());
            prepareStatement.setTimestamp(25, d.getDtRecarga());
            prepareStatement.setBoolean(26, d.isBErrorRecarga());
            prepareStatement.setBoolean(27, d.isBEsVenta());
            prepareStatement.setString(28, d.getGuidUsuario());
            prepareStatement.setBoolean(29, d.isBOffline());
            prepareStatement.setString(30, d.getGuidFolio());
            prepareStatement.setBigDecimal(31, d.getMSaldoPOSAnterior());
            prepareStatement.setString(32, d.getStrUID());
            prepareStatement.setString(33, d.getStrCSAM());
            prepareStatement.setInt(34, d.getIntContadorCiclico());
            prepareStatement.setString(35, d.getStrModem_ID());
            prepareStatement.setTimestamp(36, d.getdFechaHoraInsert());
            
            prepareStatement.addBatch();
        } catch (SQLException ex) {
            Logger.getLogger(DescargaPOSDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getSQL_INSERT() {
        return SQL_INSERT;
    }
    
    
}
