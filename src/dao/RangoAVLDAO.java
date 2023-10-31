/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import pojos.RangoAVL;

/**
 *
 * @author n6y
 */
public class RangoAVLDAO {

    private final String SQL_INSERT = "INSERT INTO dbo.ultimo_rango_avl_id VALUES (?,?,?,?,?,?,?)";
    private final String SQL_UPDATE = "UPDATE dbo.ultimo_rango_avl_id SET id_primero = ?, id_ultimo = ?, cantidad_insertada = ?, cantidad_esperada = ?,  proceso_completo = ?, reprocesado = ?, created_at = ? WHERE id = ?";
    private final String SQL_SELECT_BY_ID = "SELECT * FROM dbo.ultimo_rango_avl_id WHERE id = ?";

    //Inserta un registro en la tabla [dbo].[ultimo_rango_avl_id] BD: DBINTERMEDIA a partir de un objeto RangoAVL
    public boolean insert(RangoAVL d, PreparedStatement prepareStatement) {

        try {

            prepareStatement.setLong(1, d.getId());
            prepareStatement.setLong(2, d.getId_primero());
            prepareStatement.setLong(3, d.getId_ultimo());
            prepareStatement.setLong(4, d.getCantidad_insertada());
            prepareStatement.setLong(5, d.getCantidad_esperada());
            prepareStatement.setBoolean(6, d.isProceso_completo());
            prepareStatement.setBoolean(7, d.isReprocesado());
            prepareStatement.setTimestamp(8, d.getCreated_at());
            prepareStatement.addBatch();
        } catch (SQLException ex) {
            Logger.getLogger(RangoAVLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public boolean update(RangoAVL d, PreparedStatement prepareStatement) {

        try {

            prepareStatement.setLong(1, d.getId_primero());
            prepareStatement.setLong(2, d.getId_ultimo());
            prepareStatement.setLong(3, d.getCantidad_insertada());
            prepareStatement.setLong(4, d.getCantidad_esperada());
            prepareStatement.setBoolean(5, d.isProceso_completo());
            prepareStatement.setBoolean(6, d.isReprocesado());
            prepareStatement.setTimestamp(7, d.getCreated_at());
            prepareStatement.setLong(8, d.getId());

            prepareStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RangoAVLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
    }

    public RangoAVL select(RangoAVL d, PreparedStatement prepareStatement) {

        try {
            prepareStatement.setLong(1, d.getId());
            ResultSet executeQuery = prepareStatement.executeQuery();
            return new RangoAVL(executeQuery);
        } catch (SQLException ex) {
            Logger.getLogger(RangoAVLDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    public String getSQL_INSERT() {
        return SQL_INSERT;
    }

    public String getSQL_UPDATE() {
        return SQL_UPDATE;
    }

    public String getSQL_SELECT_BY_ID() {
        return SQL_SELECT_BY_ID;
    }

}
