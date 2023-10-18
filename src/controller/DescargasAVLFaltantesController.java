/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author n6y
 */
public class DescargasAVLFaltantesController extends TimerTask {

    private Connection DBConnection;
    private ConsultasSQL consultasSQL;
    private DescargasAVLController avlController;
    private Statement createStatement;
    private JProgressBar pb_downloadAVL;
    private JLabel jLabel1;
    private JButton downloadBtn;

    public DescargasAVLFaltantesController(Connection DBConnection, ConsultasSQL consultasSQL, DescargasAVLController avlController, Statement createStatement, JProgressBar pb_downloadAVL, JLabel jLabel1, JButton downloadBtn) {
        this.DBConnection = DBConnection;
        this.consultasSQL = consultasSQL;
        this.avlController = avlController;
        this.createStatement = createStatement;
        this.pb_downloadAVL = pb_downloadAVL;
        this.jLabel1 = jLabel1;
        this.downloadBtn = downloadBtn;
    }
    
    

    @Override
    public void run() {
        try {
            System.out.println("hilo de registros faltantes en ejecución...");
            System.out.println("registros faltantes?");
            //Statement createStatement = DBConnection.createStatement();
            ResultSet rs = createStatement.executeQuery(consultasSQL.getSQL_SELECT_COUNT_RANGOS_PROCESO_INCOMPLETO());
            rs.next();
            int cant_reg = rs.getInt("cant_reg");
            System.out.println("cantidad de registros: " + cant_reg);
            if (cant_reg > 0) {
                avlController.procesarFaltantesAVL(pb_downloadAVL, jLabel1, downloadBtn, DBConnection);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DescargasAVLFaltantesController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
