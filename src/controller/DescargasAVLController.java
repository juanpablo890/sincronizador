/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import dao.DescargaAVLDAO;
import dao.DescargaCARDDAO;
import dao.DescargaOdometroDAO;
import dao.DescargaPOSDAO;
import dao.DescargaPagaBusDAO;
import dao.DescargaTDEDAO;
import dao.RangoAVLDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import pojos.DescargaAVL;
import pojos.DescargaCARD;
import pojos.DescargaOdometro;
import pojos.DescargaPOS;
import pojos.DescargaPagaBus;
import pojos.DescargaTDE;
import pojos.RangoAVL;

/**
 *
 * @author n6y
 */
public class DescargasAVLController extends TimerTask {

    private JProgressBar pb_downloadAVL;
    private JLabel jLabel1;
    private JButton downloadBtn;
    private Connection DBConnection;
    private Connection connDBFIMPETISA;
    private ConsultasSQL consultasSQL;
    private ConsultasSQL consultasSQLDBFIMPETISA;
    private boolean hilo_corriendo;
 
    public void download() throws SQLException {
        downloadBtn.setEnabled(false);
        pb_downloadAVL.setMaximum(100);
        pb_downloadAVL.setValue(0);
        pb_downloadAVL.setIndeterminate(true);
        jLabel1.setText("iniciando descarga AVL...");
        //regCount = new ConsultasSQL(DBConnection).getAVLRegCount();
        downloadBtn.setEnabled(false);
        System.out.println("ejecutando query...");
        StoredProcedure executeSP = consultasSQL.executeSP(consultasSQL.getSQLSP_AVLGPRS());
        StoredProcedure executeSP1 = consultasSQL.executeSP(consultasSQL.getSQLSP_AVLGPRS_SELECTS());
        int regCount = new ConsultasSQL(DBConnection).getAVLRegCount();
//DescargasAVLController avlController = new DescargasAVLController();
        boolean proceso_completado = insertSIGOTODBSMOTOR(pb_downloadAVL, jLabel1, downloadBtn, DBConnection, executeSP1, regCount); //Descarga desde SIGO e inserta a DBINTERMEDIA

        if (proceso_completado) {
            consultasSQL.insertarRangoUltimosIDs(DBConnection, true);
        } else {
            consultasSQL.insertarRangoUltimosIDs(DBConnection, false);
        }
        StoredProcedure executeSP2 = consultasSQLDBFIMPETISA.executeSP(consultasSQLDBFIMPETISA.getSQLSP_DBINTERMEDIA_TO_DBFIMPETISA());
        int avlRegCount = new ConsultasSQL(connDBFIMPETISA).getAVLRegCount(); //obtener cantidad de registros en DBINTERMEDIA contra DBFIMPETISA
        System.out.println("Descargando DBINTERMEDIA A DBFIMPETISA...");
        jLabel1.setText("Descargando DBINTERMEDIA A DBFIMPETISA...");
        insertSIGOTODBSMOTOR(pb_downloadAVL, jLabel1, downloadBtn, connDBFIMPETISA, executeSP2, avlRegCount); //INSERTA desde DBINTERMEDIA A DBFIMPETISA

    }

    public boolean insertSIGOTODBSMOTOR(JProgressBar pb_downloadAVL, JLabel jLabel1, JButton downloadBtn, Connection DBConnection, StoredProcedure executeSP, int regCount) throws OutOfMemoryError, SQLException {
        System.out.println("ejecutando proceso en hilo...");
        ResultSet rs = null;
        PreparedStatement prepareStatement;
        int rsCont = 1;
        int i = 1;
        int j = 1;
        boolean proceso_completado = true;

//        downloadBtn.setEnabled(false);
//        pb_downloadAVL.setMaximum(100);
        pb_downloadAVL.setValue(0);
//        pb_downloadAVL.setIndeterminate(true);
//        jLabel1.setText("iniciando descarga AVL...");
//
//        downloadBtn.setEnabled(false);
        System.out.println("ejecutando query...");
        //StoredProcedure executeSP = consultasSQL.executeSP(DBConnection, consultasSQL.getSQLSP_AVLGPRS());
        //StoredProcedure executeSP1 = consultasSQL.executeSP(DBConnection, consultasSQL.getSQLSP_AVLGPRS_SELECTS());

        System.out.println("regcount:" + regCount);

        ArrayList<PreparedStatement> prepareStatementList = new ArrayList();
        pb_downloadAVL.setMaximum(regCount);
        pb_downloadAVL.setStringPainted(true);
        DescargaAVLDAO avlDAO = new DescargaAVLDAO();
        DescargaTDEDAO tdeDAO = new DescargaTDEDAO();
        DescargaCARDDAO cardDAO = new DescargaCARDDAO();
        DescargaPagaBusDAO pagabusDAO = new DescargaPagaBusDAO();
        DescargaPOSDAO posDAO = new DescargaPOSDAO();
        DescargaOdometroDAO odometroDAO = new DescargaOdometroDAO();

        do {
            pb_downloadAVL.setIndeterminate(false);
//                        rs = prepareCall.getResultSet();
            rs = executeSP.getPrepareCall().getResultSet();

            System.out.println("rs: " + rsCont);
            if (rs != null) {
                switch (rsCont) {
                    case 1: //AVL
                        prepareStatement = DBConnection.prepareStatement(avlDAO.getSQL_INSERT());
                        DescargaAVL davl;
                        while (rs.next()) {

                            //System.out.println(rs.getLong(1));
                            davl = new DescargaAVL(rs);

                            if (avlDAO.insert(davl, DBConnection, prepareStatement)) {
                                pb_downloadAVL.setValue(i);
                                jLabel1.setText("descargando registro: " + i + "/" + regCount);
                                //System.out.println("descargando registro: " + i + "/" + regCount);
                                i++;
                                j++;
                            } else {
                                proceso_completado = false;
                            }

                            if (j > 500000) {
                                j = 1;
                                prepareStatement.executeBatch();
                                prepareStatement.close();
                                prepareStatement = DBConnection.prepareStatement(avlDAO.getSQL_INSERT());
                            }
                        }

                        prepareStatementList.add(prepareStatement);

//                                long id = davl.getId();
//                                System.out.println("id ultimo:" + id);
                        //prepareStatement.executeBatch();
                        //prepareStatementList.add(prepareStatement);
                        break;

                    case 2: //TDE
                        prepareStatement = DBConnection.prepareStatement(tdeDAO.getSQL_INSERT());
                        while (rs.next()) {

                            //System.out.println(rs.getLong(1));
                            DescargaTDE dtde = new DescargaTDE(rs);

                            if (tdeDAO.insert(dtde, DBConnection, prepareStatement)) {
                                pb_downloadAVL.setValue(i);
                                jLabel1.setText("descargando registro: " + i + "/" + regCount);
                                //System.out.println("descargando registro: " + i + "/" + regCount);
                                i++;
                            } else {
                                proceso_completado = false;
                            }

                        }
                        //prepareStatement.executeBatch();
                        prepareStatementList.add(prepareStatement);
                        break;

                    case 3: //CARD
                        prepareStatement = DBConnection.prepareStatement(cardDAO.getSQL_INSERT());
                        while (rs.next()) {

                            //System.out.println(rs.getLong(1));
                            DescargaCARD dcard = new DescargaCARD(rs);

                            if (cardDAO.insert(dcard, DBConnection, prepareStatement)) {
                                pb_downloadAVL.setValue(i);
                                jLabel1.setText("descargando registro: " + i + "/" + regCount);
                                //System.out.println("descargando registro: " + i + "/" + regCount);
                                i++;
                            } else {
                                proceso_completado = false;
                            }
                        }
                        //prepareStatement.executeBatch();
                        prepareStatementList.add(prepareStatement);
                        break;

                    case 4: //PagaBus
                        prepareStatement = DBConnection.prepareStatement(pagabusDAO.getSQL_INSERT());
                        while (rs.next()) {
                            DescargaPagaBus dpagabus = null;
                            //System.out.println(rs.getLong(1));

                            dpagabus = new DescargaPagaBus(rs);

                            if (pagabusDAO.insert(dpagabus, DBConnection, prepareStatement)) {
                                pb_downloadAVL.setValue(i);
                                jLabel1.setText("descargando registro: " + i + "/" + regCount);
                                //System.out.println("descargando registro: " + i + "/" + regCount);
                                i++;
                            } else {
                                proceso_completado = false;
                            }
                        }
                        //prepareStatement.executeBatch();
                        prepareStatementList.add(prepareStatement);
                        break;

                    case 5: //POS
                        prepareStatement = DBConnection.prepareStatement(posDAO.getSQL_INSERT());
                        while (rs.next()) {

                            //System.out.println(rs.getLong(1));
                            DescargaPOS dpos = new DescargaPOS(rs);

                            if (posDAO.insert(dpos, DBConnection, prepareStatement)) {
                                pb_downloadAVL.setValue(i);
                                jLabel1.setText("descargando registro: " + i + "/" + regCount);
                                //System.out.println("descargando registro: " + i + "/" + regCount);
                                i++;
                            } else {
                                proceso_completado = false;
                            }

                        }
                        //prepareStatement.executeBatch();
                        prepareStatementList.add(prepareStatement);
                        break;

                    case 6: //Odometro
                        prepareStatement = DBConnection.prepareStatement(odometroDAO.getSQL_INSERT());
                        while (rs.next()) {

                            //System.out.println(rs.getLong(1));
                            DescargaOdometro d_odometro = new DescargaOdometro(rs);

                            if (odometroDAO.insert(d_odometro, DBConnection, prepareStatement)) {
                                pb_downloadAVL.setValue(i);
                                jLabel1.setText("descargando registro: " + i + "/" + regCount);
                                //System.out.println("descargando registro: " + i + "/" + regCount);
                                i++;
                            } else {
                                proceso_completado = false;
                            }
                        }
                        //prepareStatement.executeBatch();
                        prepareStatementList.add(prepareStatement);
                        break;

                    default:
                }
            }

            rsCont++;
        } while (executeSP.getPrepareCall().getMoreResults());
        // while (prepareCall.getMoreResults());

        //itera sobre el ArrayList de objetos Batch con todos los registros de una tabla para insertarlos en la BD
        //pb_downloadAVL.setMaximum(prepareStatementList.size());
//                    int j = 1;
//                    jLabel1.setText("insertando registros...");
        for (PreparedStatement preparedStatementB : prepareStatementList) {

            preparedStatementB.executeBatch(); //ejecuta el Batch para una tabla

            //pb_downloadAVL.setValue(j++);
        }

        return proceso_completado;
    }

    public void procesarFaltantesAVL(JProgressBar pb_downloadAVL, JLabel jLabel1, JButton downloadBtn, Connection DBConnection) throws SQLException {
        ConsultasSQL consultasSQL = new ConsultasSQL(DBConnection);
//        //StoredProcedure executeSPFaltantes = consultasSQL.executeSP(consultasSQL.getSQLSP_AVLGPRS_FALTANTES());
//        StoredProcedure executeSPFaltantesSelects = consultasSQL.executeSP(consultasSQL.getSQLSP_AVLGPRS_FALTANTES_SELECTS());
//        //StoredProcedure executeSPFaltantesCounts = consultasSQL.executeSP(consultasSQL.getSQLFN_AVLGPRS_FALTANTES_COUNTS());
////        ResultSet resultsetAVLFaltantesCounts = executeSPFaltantesCounts.getResultset();
////        resultsetAVLFaltantesCounts.next();
////        int countAVLFaltantes = resultsetAVLFaltantesCounts.getInt("total_count");
////        System.out.println("procesando faltantes..." + countAVLFaltantes);
//
//        insertSIGOTODBSMOTOR(pb_downloadAVL, jLabel1, downloadBtn, DBConnection, executeSPFaltantesSelects, countAVLFaltantes);
//        //ResultSet resultset = executeSPFaltantes.getResultset();
//        //resultset.next();
//        //return Integer.parseInt(resultset.getString("id_rango_incompleto"));

        Statement createStatement = DBConnection.createStatement();
        System.out.println("registros faltantes?");
        ResultSet rs = createStatement.executeQuery(consultasSQL.getSQL_SELECT_COUNT_RANGOS_PROCESO_INCOMPLETO());
        rs.next();
        int cant_reg = rs.getInt("cant_reg");
        System.out.println("cantidad de registros: " + cant_reg);

        ResultSet executeQuery = createStatement.executeQuery(consultasSQL.getSQL_SELECT_RANGOS_PROCESO_INCOMPLETO());
        createStatement = DBConnection.createStatement();
        while (executeQuery.next()) {
            String id_rango = executeQuery.getString("id");
            String id_primero = executeQuery.getString("id_primero");
            String id_ultimo = executeQuery.getString("id_ultimo");
            System.out.println(id_primero + " " + id_ultimo);
            String parameterizedFor_SQLSP_AVLGPRS_FALTANTES2 = consultasSQL.getParameterizedFor_SQLSP_AVLGPRS_FALTANTES2(id_primero, id_ultimo);
            System.out.println(parameterizedFor_SQLSP_AVLGPRS_FALTANTES2);
            createStatement.execute(parameterizedFor_SQLSP_AVLGPRS_FALTANTES2);
            StoredProcedure executeSPFaltantesCounts = consultasSQL.executeSP(consultasSQL.getSQLFN_AVLGPRS_FALTANTES_COUNTS());
            ResultSet resultsetAVLFaltantesCounts = executeSPFaltantesCounts.getResultset();
            resultsetAVLFaltantesCounts.next();
            int countAVLFaltantes = resultsetAVLFaltantesCounts.getInt("total_count");
            System.out.println("countAVLFaltantes: " + countAVLFaltantes);
            StoredProcedure executeSPFaltantesSelects = consultasSQL.executeSP(consultasSQL.getSQLSP_AVLGPRS_FALTANTES_SELECTS());
            insertSIGOTODBSMOTOR(pb_downloadAVL, jLabel1, downloadBtn, DBConnection, executeSPFaltantesSelects, countAVLFaltantes);
            //createStatement.execute(consultasSQL.getSQL_TRUNCATE_TABLE_AVL_IDS_FALTANTES());
            RangoAVL rangoAVL = obtenerRangoPorID(DBConnection, Long.parseLong(id_rango));
            rangoAVL.setReprocesado(true);
            actualizarEstatusReprocesado(DBConnection, rangoAVL);
        }
    }

    public void actualizarEstatusReprocesado(Connection DBConnection, RangoAVL rangoAVL) throws SQLException {
        RangoAVLDAO rdao = new RangoAVLDAO();
        PreparedStatement prepareStatement = DBConnection.prepareStatement(rdao.getSQL_UPDATE());
        prepareStatement.setLong(1, rangoAVL.getId_primero());
        prepareStatement.setLong(2, rangoAVL.getId_ultimo());
        prepareStatement.setLong(3, rangoAVL.getCantidad_insertada());
        prepareStatement.setLong(4, rangoAVL.getCantidad_esperada());
        prepareStatement.setBoolean(5, rangoAVL.isProceso_completo());
        prepareStatement.setBoolean(6, rangoAVL.isReprocesado());
        prepareStatement.setTimestamp(7, rangoAVL.getCreated_at());
        prepareStatement.setLong(8, rangoAVL.getId());
        prepareStatement.executeUpdate();

    }

    public RangoAVL obtenerRangoPorID(Connection DBConnection, long id) throws SQLException {
        RangoAVLDAO rdao = new RangoAVLDAO();
        PreparedStatement prepareStatement = DBConnection.prepareStatement(rdao.getSQL_SELECT_BY_ID());
        prepareStatement.setLong(1, id);
        ResultSet rs = prepareStatement.executeQuery();
        RangoAVL rangoAVL = null;
        while (rs.next()) {
            rangoAVL = new RangoAVL(rs);
            System.out.println("rango: " + rangoAVL.getId_primero());
        }
        return rangoAVL;
    }

    @Override
    public void run() {
//        try {
//            System.out.println("hilo corriendo = "+hilo_corriendo);
//            if (!hilo_corriendo) {
//                System.out.println("descargar registros...");
//                hilo_corriendo = true;
//                download();
//                hilo_corriendo = false;
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DescargasAVLController.class.getName()).log(Level.SEVERE, null, ex);
//        } finally {
//            hilo_corriendo = false;
//        }
System.out.println("iniciando TimerTask...");
System.out.println("hilo corriendo = "+hilo_corriendo);
if (!hilo_corriendo) {
    try {
        System.out.println("descargar registros...");
        hilo_corriendo = true;
        System.out.println("hilo corriendo? = "+hilo_corriendo);
        download();
        System.out.println("descarga completa");
        hilo_corriendo = false;
        System.out.println("hilo corriendo? = "+hilo_corriendo);
//    Thread thread = new Thread(new Runnable() {
//        @Override
//        public void run() {
//            System.out.println("descargando registros...");
//            System.out.println("hilo corriendo? = "+hilo_corriendo);
//            try {
//                Thread.sleep(120000);
//                System.out.println("descarga completa");
//                hilo_corriendo = false;
//                System.out.println("hilo corriendo? = "+hilo_corriendo);
//            } catch (InterruptedException ex) {
//                Logger.getLogger(DescargasAVLController.class.getName()).log(Level.SEVERE, null, ex);
//            }
//            
//        }
//    });
//    thread.start();
    } catch (SQLException ex) {
        Logger.getLogger(DescargasAVLController.class.getName()).log(Level.SEVERE, null, ex);
    }
    
}

    }

    public DescargasAVLController(JProgressBar pb_downloadAVL, JLabel jLabel1, JButton downloadBtn, Connection DBConnection, Connection connDBFIMPETISA, ConsultasSQL consultasSQL, ConsultasSQL consultasSQLDBFIMPETISA) {
        this.pb_downloadAVL = pb_downloadAVL;
        this.jLabel1 = jLabel1;
        this.downloadBtn = downloadBtn;
        this.DBConnection = DBConnection;
        this.connDBFIMPETISA = connDBFIMPETISA;
        this.consultasSQL = consultasSQL;
        this.consultasSQLDBFIMPETISA = consultasSQLDBFIMPETISA;
    }

    public DescargasAVLController() {
    }

}
