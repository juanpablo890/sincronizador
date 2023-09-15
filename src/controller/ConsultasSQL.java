/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
/**
 *
 * @author n6y
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasSQL {

    Connection DBConnection;

    public ConsultasSQL(Connection conn) {
        DBConnection = conn;
    }

    public int getRegCount() throws SQLException {
        PreparedStatement prepareStatement = DBConnection.prepareStatement("SELECT [motor].[fn_carga_avl_to_intermedia_total_count]() AS total_count");
        prepareStatement.execute();
        ResultSet resultSet = prepareStatement.getResultSet();
        resultSet.next();
        return resultSet.getInt("total_count");
    }
}
