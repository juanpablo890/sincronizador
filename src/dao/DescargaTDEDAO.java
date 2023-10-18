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
import pojos.DescargaTDE;

/**
 *
 * @author n6y
 */
public class DescargaTDEDAO {

    private final String SQL_INSERT = "INSERT INTO avl.tblDescargasTDE VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public DescargaTDEDAO() {

    }

    //Inserta un registro en la tabla [avl].[tblDescargasTDE] BD: DBINTERMEDIA a partir de un objeto DescargaTDE
    public boolean insert(DescargaTDE d, Connection DBConnection, PreparedStatement prepareStatement)  {

        try {
            prepareStatement.setLong(1, d.getId_dgprs());
            prepareStatement.setInt(2, d.getIntTipoFrame());
            prepareStatement.setInt(3, d.getIntSubidas_Pta1());
            prepareStatement.setInt(4, d.getIntBajadas_Pta1());
            prepareStatement.setInt(5, d.getIntBloqueos_Pta1());
            prepareStatement.setInt(6, d.getIntPablos_Pta1());
            prepareStatement.setInt(7, d.getIntSubidas_Pta2());
            prepareStatement.setInt(8, d.getIntBajadas_Pta2());
            prepareStatement.setInt(9, d.getIntBloqueos_Pta2());
            prepareStatement.setInt(10, d.getIntPablos_Pta2());
            prepareStatement.setInt(11, d.getIntNumOperador());
            prepareStatement.setInt(12, d.getIntBanderaLiquidacion());
            prepareStatement.setInt(13, d.getIntVarControl());
            prepareStatement.setInt(14, d.getIntNumApagados_Pta1());
            prepareStatement.setInt(15, d.getIntNumApagados_Pta2());
            prepareStatement.setInt(16, d.getIntId_Asignacion());
            prepareStatement.setInt(17, d.getIntStatus());
            prepareStatement.setString(18, d.getStrModem_ID());
            prepareStatement.setTimestamp(19, d.getdFehaHoraInsert());
            prepareStatement.addBatch();
        } catch (SQLException ex) {
            Logger.getLogger(DescargaTDEDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
return true;
    }

    public String getSQL_INSERT() {
        return SQL_INSERT;
    }

}
