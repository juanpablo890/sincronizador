package forms;


import com.microsoft.sqlserver.jdbc.SQLServerException;
import controller.ConnectionDB;
import dao.DAOException;
import dao.OPETransactionImplDAO;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.Executor;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import pojos.OPETransaction;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
/**
 *
 * @author n6y
 */
public class ThreadsAdmin extends javax.swing.JFrame {

    /**
     * Creates new form ThreadsAdmin
     */
    SwingWorker t1, t2, t3, t4, t5, t6;
    Connection DBConnection;
    int i = 0;
    boolean stop = false;

    public ThreadsAdmin() {
        initComponents();
        t1 = new SwingWorker() {
            @Override
            protected Object doInBackground() {
                try {
                    int i = 0;
                    Thread.sleep(1000);
                    jLabel1.setText(String.valueOf(t1.getState()));
                    while (i < 100) {
                        jProgressBar1.setValue(i++);

                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadsAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }

            @Override
            protected void done() {
                jLabel1.setText(String.valueOf(t1.getState()));
            }
        };
        t2 = new SwingWorker() {
            @Override
            protected Object doInBackground() {
                try {
                    int i = 0;
                    Thread.sleep(1000);
                    jLabel2.setText(String.valueOf(t2.getState()));
                    while (i < 100) {
                        jProgressBar2.setValue(i++);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadsAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;

            }

            @Override
            protected void done() {
                jLabel2.setText(String.valueOf(t2.getState()));
            }
        };
        t3 = new SwingWorker() {
            @Override
            protected Object doInBackground() {
                try {
                    int i = 0;
                    Thread.sleep(1000);
                    jLabel3.setText(String.valueOf(t3.getState()));
                    while (i < 100) {
                        System.out.println("corriendo...");
                        jProgressBar3.setValue(i++);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadsAdmin.class.getName()).log(Level.SEVERE, null, ex);
                    Thread.interrupted();
                    System.out.println("hilo 3 interrumpido" + Thread.interrupted());
                }
                return null;

            }

            @Override
            protected void done() {
                jLabel3.setText(String.valueOf(t3.getState()));
                System.out.println("hilo 3 interrumpido" + Thread.interrupted());
            }
        };
        t4 = new SwingWorker() {
            @Override
            protected Object doInBackground() {
                try {
                    int i = 0;
                    Thread.sleep(1000);
                    jLabel4.setText(String.valueOf(t4.getState()));
                    while (i < 100) {
                        jProgressBar4.setValue(i++);
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadsAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
                return null;
            }

            @Override
            protected void done() {
                System.out.println("name: " + Thread.currentThread().getName());
                System.out.println(Thread.interrupted());
                jLabel4.setText(String.valueOf(t4.getState()));

            }
        };
        //BD connection
        t5 = new SwingWorker() {
            @Override
            protected Object doInBackground() {
                long num = 0;
                try {

                    Thread.sleep(1000);

                    jLabel5.setText(String.valueOf(t5.getState()));
//                    DBConnection = new ConnectionDB().DBConnection("sqlserver","192.168.1.206", "1433", "SIGOWEBHISTORICO", "sa", "T1sa.Pr0d.DB");
                    DBConnection = new ConnectionDB().DBConnection("sqlserver", "192.168.1.206", "1433", "DBINTERMEDIA", "user_motor", "Mot0r.Tis4");
                    //Statement createStatement = DBConnection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
                    Statement createStatement = DBConnection.createStatement();
                    System.out.println("ejecutando query...");
                    //createStatement.executeQuery("SELECT * FROM [SIGOWEBHISTORICO].[dbo].[tblDescargasAVL]; ");
                    createStatement.execute("select * FROM [motor].[config_motor_tisa]" + "select id, database_alias as db_alias FROM [motor].[config_motor_tisa] where database_alias = 'sfinx'");
                    CallableStatement prepareCall = DBConnection.prepareCall("exec [motor].[sp_carga_avl_to_intermedia] 'avlgprs'");
                    //CallableStatement prepareCall = DBConnection.prepareCall("select 'ope_recharge' as table_name" +" select * from [sfinx].[ope_transaction]"+ " select 'ope_transaction' as table_name"+ " select * FROM [motor].[config_motor_tisa]");
                    //CallableStatement prepareCall = DBConnection.prepareCall("SELECT * [AVL_GPRS].[AVL_GPRS].dbo.tblDescargasOdometro");
                    prepareCall.execute();
                    jProgressBar5.setMaximum(4929797);
//t6.execute();
//
//                    ResultSet resultSet = createStatement.getResultSet(); 
//                    while(resultSet.next()){
//                        System.out.println(resultSet.getString(2));
//                    }
//                    System.out.println("more? "+createStatement.getMoreResults());
//                    ResultSet resultSet2 = createStatement.getResultSet();
//                    while(resultSet2.next()){
//                        System.out.println(resultSet2.getString(2));
//                    }

                    ResultSet rs;
//                    while (createStatement.getMoreResults()) {
//                        rs = createStatement.getResultSet();
//                        while(rs.next()){
//                            System.out.println(rs.getString(2));
//                        }
//                    }
                    int i = 1;
                    int cant = 0;
                    do{
                        System.out.println("rs: "+i);
                        rs = prepareCall.getResultSet();
//                        if(columnName.equals("ope_recharge")){
                            while(rs.next())
                        System.out.println(rs.getLong(1));
//                        }
                        
                        i++;
                    }while(prepareCall.getMoreResults());
//                    do {
//                        rs = prepareCall.getResultSet();
//                        System.out.println("rs: " + i++);
//                       
//                        System.out.println(rs.getString("table_name")); 
//
//obtener nombre de tabla antes de iterar cada registro
//                        while (rs.next()) { //iterar por cada registro
//                            System.out.println("table name: "+metaData.getCatalogName(1));
//                            System.out.println(rs.getString(1)); 
//                            
//                            
//                            switch("ope_transaction"){
//                                case "ope_transaction":
//                                    OpeTransaction t = new OpeTransaction(rs.getLong("id"), rs.getLong("collection_id"), rs.getString("transaction_type"), 
//                                            rs.getString("transaction_folio"), rs.getString("event_date"), rs.getString("card_uid"), 
//                                            rs.getString("product"), rs.getString("ruta"), rs.getBigDecimal("amount"), rs.getString("ini_vig_prod"), 
//                                            rs.getString("fin_vig_prod"), rs.getString("ini_val_day"), rs.getString("fin_val_day"), rs.getDouble("initial_balance"), 
//                                            rs.getDouble("final_balance"), rs.getString("station_id"), rs.getString("uid_sam"), 
//                                            rs.getLong("consecutive_sam"), rs.getLong("consecutive_app"), 
//                                            rs.getDouble("latitude"), rs.getDouble("longitude"), rs.getString("recharge_type"), 
//                                            rs.getString("debit_type"), rs.getString("sign_parameters"), rs.getString("sign_transaction"), 
//                                            rs.getString("device_id"), rs.getLong("profile_code"), rs.getString("created_at"), 
//                                            rs.getString("updated_at"), rs.getBoolean("status"), rs.getString("previous_card"));
//                                {
//                                    try {
//                                        long timeIni = System.currentTimeMillis();
//                                        new OPETransactionImplDAO().create(t);
//                                        long timeFin = System.currentTimeMillis();
//                                        long timep = timeFin - timeIni;
//                                        System.out.println("tiempo de procesamiento (segs)"+timep/1000);
//                                    } catch (DAOException ex) {
//                                        Logger.getLogger(ThreadsAdmin.class.getName()).log(Level.SEVERE, null, ex);
//                                    } catch (IOException ex) {
//                                        Logger.getLogger(ThreadsAdmin.class.getName()).log(Level.SEVERE, null, ex);
//                                    }
//                                }
//                                    break;
//
//                            }
//
//cant++;
//                        }
//                    } while (prepareCall.getMoreResults()); //iterar por cada tabla (result set)
                    

                } catch (InterruptedException ex) {
                    Logger.getLogger(ThreadsAdmin.class.getName()).log(Level.SEVERE, null, ex);
                    System.out.println("hilo interrumpido");

                } catch (SQLException ex) {
                    Logger.getLogger(ThreadsAdmin.class.getName()).log(Level.SEVERE, null, ex);
                    JOptionPane.showMessageDialog(rootPane, "error al conectar", "", JOptionPane.ERROR_MESSAGE);
                }
                return null;
            }

            @Override
            protected void done() {
                System.out.println("hilo en DONE");
                System.out.println(t5.getState());
                try {
                    new ConnectionDB().abortConnection(DBConnection);
                    System.out.println("conexion abortada");
                    stop = true;
                } catch (SQLException ex) {
                    Logger.getLogger(ThreadsAdmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }; //progressbarBD
        t6 = new SwingWorker() {
            @Override
            protected Object doInBackground() {

                while (i <= jProgressBar5.getMaximum()) {
                    jProgressBar5.setValue(i);
//                    System.out.println("corriendo progress bar bd..."+t5.getState());

                }
                return null;
            }

        };
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        jProgressBar3 = new javax.swing.JProgressBar();
        jProgressBar2 = new javax.swing.JProgressBar();
        jProgressBar5 = new javax.swing.JProgressBar();
        jProgressBar4 = new javax.swing.JProgressBar();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jButton10 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jProgressBar5.setMaximum(30);

        jButton1.setText("Run");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Run");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Run");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Run");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Run BD");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Stop");
        jButton6.setEnabled(false);
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Stop");
        jButton7.setEnabled(false);
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Stop");
        jButton8.setEnabled(false);
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Stop");
        jButton9.setEnabled(false);
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        jButton10.setText("Stop");
        jButton10.setEnabled(false);
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(67, 67, 67)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton10)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(88, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jProgressBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton1)
                                .addComponent(jButton6)))
                        .addGap(19, 19, 19)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jProgressBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton2)
                                        .addComponent(jButton7)))
                                .addGap(18, 18, 18)
                                .addComponent(jProgressBar3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton3)
                        .addComponent(jButton8)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton4)
                        .addComponent(jButton9))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jProgressBar5, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jButton5)
                        .addComponent(jButton10))
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        jButton1.setEnabled(false);
        jLabel1.setText(String.valueOf(t1.getState()));
        t1.execute();
        jButton6.setEnabled(true);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        jButton2.setEnabled(false);
        jLabel2.setText(String.valueOf(t2.getState()));
        t2.execute();
        jButton7.setEnabled(true);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        jButton3.setEnabled(false);
        jLabel3.setText(String.valueOf(t3.getState()));
        t3.execute();
        jButton8.setEnabled(true);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        jButton4.setEnabled(false);
        jLabel4.setText(String.valueOf(t4.getState()));
        t4.execute();
        jButton9.setEnabled(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        jButton5.setEnabled(false);
        jLabel5.setText(String.valueOf(t5.getState()));
        t5.execute();
        jButton10.setEnabled(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        jButton6.setEnabled(false);
        t1.cancel(true);
        jLabel1.setText(String.valueOf(t1.getState()));
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        jButton7.setEnabled(false);
        t2.cancel(true);
        jLabel2.setText(String.valueOf(t2.getState()));
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        jButton8.setEnabled(false);
        t3.cancel(true);
        jLabel3.setText(String.valueOf(t3.getState()));
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jButton9.setEnabled(false);
        t4.cancel(true);
        jLabel4.setText(String.valueOf(t4.getState()));
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        jButton10.setEnabled(false);
        t5.cancel(true);

        jLabel5.setText(String.valueOf(t5.getState()));
    }//GEN-LAST:event_jButton10ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ThreadsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ThreadsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ThreadsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ThreadsAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ThreadsAdmin().setVisible(true);
            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JProgressBar jProgressBar2;
    private javax.swing.JProgressBar jProgressBar3;
    private javax.swing.JProgressBar jProgressBar4;
    private javax.swing.JProgressBar jProgressBar5;
    // End of variables declaration//GEN-END:variables
}
