/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import forms.MotorTISA;
import dao.FimpeDEBITODAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JProgressBar;
import pojos.FimpeDEBITO;

/**
 *
 * @author n6y
 */
public class DebitoFilesController extends TimerTask{
private JProgressBar pb_debitosFIMPE;
    public DebitoFilesController(JProgressBar pb_debitosFIMPE) {
        this.pb_debitosFIMPE = pb_debitosFIMPE;
    }

    
    @Override
    public void run() {

        try {
            Connection connDBFIMPETISA = new ConnectionDB().DBConnection("sqlserver", "192.168.1.206", "1433", "DBFIMPETISA", "user_motor", "Mot0r.Tis4");
            
            ConsultasSQL consultasSQLDBFIMPETISA = new ConsultasSQL(connDBFIMPETISA);
            StoredProcedure executeSP = consultasSQLDBFIMPETISA.executeSP(consultasSQLDBFIMPETISA.getSQLSP_CREATE_DEBIT_TMP_TABLE());
            ResultSet resultset = executeSP.getResultset();resultset.next();
            String tableName = resultset.getString("tableName");System.out.println(tableName);
            FimpeDEBITODAO fd = new FimpeDEBITODAO(tableName);
            System.out.println(fd.getSQL_INSERT());
            StoredProcedure debitos = consultasSQLDBFIMPETISA.executeSP(consultasSQLDBFIMPETISA.getSQLSP_SELECT_DEBITOS());
            ResultSet rs = debitos.getResultset();
            System.out.println("columnas"+rs.getMetaData().getColumnCount());
            PreparedStatement prepareStatement = connDBFIMPETISA.prepareStatement(fd.getSQL_INSERT());
            int i = 1;
            pb_debitosFIMPE.setMaximum(76);
            while(rs.next()){
                System.out.println("insertando...");
                FimpeDEBITO fimpeDEBITO = new FimpeDEBITO(rs);
                if(fd.insert(fimpeDEBITO, connDBFIMPETISA, prepareStatement)){
                    pb_debitosFIMPE.setValue(i);
                    i++;
                }
            }
            prepareStatement.executeBatch();
        } catch (SQLException ex) {
            Logger.getLogger(MotorTISA.class.getName()).log(Level.SEVERE, null, ex);
        }
                
              
    }
    
}
