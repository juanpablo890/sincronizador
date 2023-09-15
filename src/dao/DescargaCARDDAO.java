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
import pojos.DescargaCARD;

/**
 *
 * @author n6y
 */
public class DescargaCARDDAO {

private final String SQL_INSERT = "INSERT INTO avl.tblDescargasCARD VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public DescargaCARDDAO() {

    }

    //Inserta un registro en la tabla [avl].[tblDescargasTDE] BD: DBINTERMEDIA a partir de un objeto DescargaTDE
    public void insert(DescargaCARD d, Connection DBConnection, PreparedStatement prepareStatement) {
        try {
            
            prepareStatement.setLong(1, d.getId());
            prepareStatement.setLong(2, d.getId_dgprs());
            prepareStatement.setString(3, d.getValidator());
            prepareStatement.setString(4, d.getIdTarjeta());
            prepareStatement.setInt(5, d.getTipoTarjeta());
            prepareStatement.setInt(6, d.getTipoEvento());
            prepareStatement.setInt(7, d.getSaldoInicial());
            prepareStatement.setInt(8, d.getSaldoFinal());
            prepareStatement.setTimestamp(9, d.getFechaEventoTarjeta());
            prepareStatement.setInt(10, d.getIdPuntoVenta());
            prepareStatement.setInt(11, d.getFolioVenta());
            prepareStatement.setInt(12, d.getVarControl());
            prepareStatement.setInt(13, d.getStatus());
            prepareStatement.setTimestamp(14, d.getdFechaAVL());
            prepareStatement.setInt(15, d.getNumOperador());
            prepareStatement.setInt(16, d.getFolioTarjeta());
            prepareStatement.setString(17, d.getIdFrameEvento());
            prepareStatement.setInt(18, d.getRuta());
            prepareStatement.setInt(19, d.getContadorCiclico());
            prepareStatement.setInt(20, d.getIdProducto());
            prepareStatement.setInt(21, d.getEntidad());
            prepareStatement.setString(22, d.getDsam());
            prepareStatement.setInt(23, d.getIdEvento());
            prepareStatement.setString(24, d.getUid());
            prepareStatement.setString(25, d.getConsecutivoSAM());
            prepareStatement.setString(26, d.getModemID());
            prepareStatement.setTimestamp(27, d.getdFechaHoraInsert());
            prepareStatement.addBatch();
        } catch (SQLException ex) {
            Logger.getLogger(DescargaCARDDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getSQL_INSERT() {
        return SQL_INSERT;
    }
    
    
}
