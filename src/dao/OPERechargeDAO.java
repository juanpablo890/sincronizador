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
import pojos.OPERecharge;

/**
 *
 * @author n6y
 */
public class OPERechargeDAO {

private final String SQL_INSERT = "INSERT INTO sfinx.ope_recharge VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    public OPERechargeDAO() {

    }
//
    //Inserta un registro en la tabla [sfinx].[ope_recharge] BD: DBINTERMEDIA a partir de un objeto OpeRecharge
    public void insert(OPERecharge r, Connection DBConnection, PreparedStatement prepareStatement) {
        try {
            
            prepareStatement.setLong(1, r.getId());
            prepareStatement.setLong(2, r.getId_shift());
            prepareStatement.setLong(3, r.getId_beneficiary());
            prepareStatement.setString(4, r.getUid_card());
            prepareStatement.setString(5, r.getOperation());
            prepareStatement.setString(6, r.getProduct());
            prepareStatement.setDouble(7, r.getInitial_balance());
            prepareStatement.setDouble(8, r.getFinal_balance());
            prepareStatement.setLong(9, r.getTravels());
            prepareStatement.setLong(10, r.getSurplus_trips());
            prepareStatement.setString(11, r.getStart_date());
            prepareStatement.setString(12, r.getExpiration_date());
            prepareStatement.setString(13, r.getCreated_at());
            prepareStatement.setString(14, r.getUpdated_at());
            prepareStatement.setBoolean(15, r.isStatus());
            prepareStatement.setBigDecimal(16, r.getAmount());
            prepareStatement.setString(17, r.getProfile());
            prepareStatement.addBatch();
        } catch (SQLException ex) {
            Logger.getLogger(OPERechargeDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getSQL_INSERT() {
        return SQL_INSERT;
    }
    
    
}
