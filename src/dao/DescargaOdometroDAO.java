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
import pojos.DescargaOdometro;

/**
 *
 * @author n6y
 */
public class DescargaOdometroDAO {

    private final String SQL_INSERT = "INSERT INTO avl.tblDescargasOdometro VALUES (?,?,?,?)";

    public DescargaOdometroDAO() {

    }

    //Inserta un registro en la tabla [avl].[tblDescargasOdometro] BD: DBINTERMEDIA a partir de un objeto DescargaOdometro
    public boolean insert(DescargaOdometro d, Connection DBConnection, PreparedStatement prepareStatement) {
        try {
            prepareStatement.setLong(1, d.getId_dgprs());
            prepareStatement.setLong(2, d.getBintOdometro());
            prepareStatement.setString(3, d.getStrModemID());
            prepareStatement.setInt(4, d.getIntVarControl());
            prepareStatement.addBatch();
        } catch (SQLException ex) {
            Logger.getLogger(DescargaOdometroDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public String getSQL_INSERT() {
        return SQL_INSERT;
    }

}
