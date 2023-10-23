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
import pojos.DescargaPagaBus;

/**
 *
 * @author n6y
 */
public class DescargaPagaBusDAO {

    private final String SQL_INSERT = "INSERT INTO avl.tblDescargasPagaBus VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public DescargaPagaBusDAO() {

    }

    //Inserta un registro en la tabla [avl].[tblDescargasTDE] BD: DBINTERMEDIA a partir de un objeto DescargaTDE
    public boolean insert(DescargaPagaBus d, Connection DBConnection, PreparedStatement prepareStatement) {

        try {
            prepareStatement.setLong(1, d.getId_dgprs());
            prepareStatement.setBigDecimal(2, d.getdTotalEfectivoRegistrado());
            prepareStatement.setBigDecimal(3, d.getdTotalVentas());
            prepareStatement.setBigDecimal(4, d.getdTotalVentasTarifa0());
            prepareStatement.setBigDecimal(5, d.getdTotalVentasTarifa1());
            prepareStatement.setBigDecimal(6, d.getdTotalVentasTarifa2());
            prepareStatement.setBigDecimal(7, d.getdTotalVentasTarifa3());
            prepareStatement.setBigDecimal(8, d.getdTotalVentasTarifa4());
            prepareStatement.setBigDecimal(9, d.getdTotalVentasTarifa5());
            prepareStatement.setBigDecimal(10, d.getdTotalVentasTarifa6());
            prepareStatement.setBigDecimal(11, d.getdTotalVentasTarifa7());
            prepareStatement.setBigDecimal(12, d.getdTotalVentasTarifa8());
            prepareStatement.setBigDecimal(13, d.getdTotalVentasTarifa9());
            prepareStatement.setTimestamp(14, d.getdFechaHoraEnvio());
            prepareStatement.setString(15, d.getStrModem_ID());
            prepareStatement.setString(16, d.getNoSerieAVLOriginal());
            prepareStatement.setTimestamp(17, d.getdFechaHoraInsert());
            prepareStatement.setInt(18, d.getContadorCiclico());
            prepareStatement.addBatch();

        } catch (SQLException ex) {
            Logger.getLogger(DescargaPagaBusDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public String getSQL_INSERT() {
        return SQL_INSERT;
    }

}
