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
import pojos.OPETransaction;

/**
 *
 * @author n6y
 */
public class OPETransactionDAO {

    private final String SQL_INSERT = "INSERT INTO sfinx.ope_transaction VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    public OPETransactionDAO() {

    }

    //Inserta un registro en la tabla [sfinx].[ope_transaction] BD: DBINTERMEDIA a partir de un objeto OpeTransaction
    public void insert(OPETransaction t, Connection DBConnection, PreparedStatement prepareStatement) throws SQLException {

        prepareStatement.setLong(1, t.getId());
        prepareStatement.setLong(2, t.getCollection_id());
        prepareStatement.setString(3, t.getTransaction_type());
        prepareStatement.setString(4, t.getTransaction_folio());
        prepareStatement.setString(5, t.getEvent_date());
        prepareStatement.setString(6, t.getCard_uid());
        prepareStatement.setString(7, t.getProduct());
        prepareStatement.setString(8, t.getRuta());
        prepareStatement.setBigDecimal(9, t.getAmount());
        prepareStatement.setString(10, t.getIni_vig_prod());
        prepareStatement.setString(11, t.getFin_vig_prod());
        prepareStatement.setString(12, t.getIni_val_day());
        prepareStatement.setString(13, t.getFin_val_day());
        prepareStatement.setDouble(14, t.getInitial_balance());
        prepareStatement.setDouble(15, t.getFinal_balance());
        prepareStatement.setString(16, t.getStation_id());
        prepareStatement.setString(17, t.getUid_sam());
        prepareStatement.setLong(18, t.getConsecutive_sam());
        prepareStatement.setLong(19, t.getConsecutive_app());
        prepareStatement.setDouble(20, t.getLatitude());
        prepareStatement.setDouble(21, t.getLongitude());
        prepareStatement.setString(22, t.getRecharge_type());
        prepareStatement.setString(23, t.getDebit_type());
        prepareStatement.setString(24, t.getSign_parameters());
        prepareStatement.setString(25, t.getSign_transaction());
        prepareStatement.setString(26, t.getDevice_id());
        prepareStatement.setLong(27, t.getProfile_code());
        prepareStatement.setString(28, t.getCreated_at());
        prepareStatement.setString(29, t.getUpdated_at());
        prepareStatement.setBoolean(30, t.getStatus());
        prepareStatement.setString(31, t.getPrevious_card());
        prepareStatement.addBatch();

    }

    public String getSQL_INSERT() {
        return SQL_INSERT;
    }

}
