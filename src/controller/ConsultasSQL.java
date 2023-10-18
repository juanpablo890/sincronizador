/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.CallableStatement;
import java.sql.Connection;
/**
 *
 * @author n6y
 */
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConsultasSQL {

    private final Connection DBConnection;
    private final String SQLSP_SFINXFIMPE = "exec [motor].[sp_carga_sfinx_fimpe_to_intermedia] 'sfinx_fimpe'"; //opetransaction
    private final String SQLSP_SFINXFIMPE_SELECTS = "exec [motor].[sp_carga_sfinx_fimpe_to_intermedia_selects] 'sfinx_fimpe'";
    private final String SQLSP_SFINX = "exec [motor].[sp_carga_sfinx_to_intermedia] 'sfinx'"; //operecharge
    private final String SQLSP_SFINX_SELECTS = "exec [motor].[sp_carga_sfinx_to_intermedia_selects] 'sfinx'";
    private final String SQLSP_AVLGPRS = "exec [motor].[sp_carga_avl_to_intermedia] 'avlgprs'";
    private final String SQLSP_AVLGPRS_SELECTS = "exec [motor].[sp_carga_avl_to_intermedia_selects2] 'avlgprs' "; //
    private final String SQLSP_AVLGPRS_RANGO_IDS_COMPLETED = "exec [motor]. [sp_carga_avl_to_intermedia_rango_ids] 1";
    private final String SQLSP_AVLGPRS_RANGO_IDS_UNCOMPLETED = "exec [motor]. [sp_carga_avl_to_intermedia_rango_ids] 0";
    private final String SQLSP_AVLGPRS_FALTANTES = "exec [motor].[sp_carga_avl_to_intermedia_faltantes] 'avlgprs'";
    private final String SQLSP_AVLGPRS_FALTANTES_SELECTS = "exec [motor].[sp_carga_avl_to_intermedia_faltantes_selects] 'avlgprs'";
    private final String SQLSP_AVLGPRS_FALTANTES2 = "exec [motor].[sp_carga_avl_to_intermedia_faltantes2] 'avlgprs', @id_primero, @id_ultimo";
    private final String SQLFN_AVLGPRS_FALTANTES_COUNTS = "SELECT [motor].[fn_carga_avl_to_intermedia_faltantes_total_count]() AS total_count";
    private final String SQL_SELECT_COUNT_RANGOS_PROCESO_INCOMPLETO = "SELECT COUNT(id) AS cant_reg FROM dbo.ultimo_rango_avl_id WHERE proceso_completo = 0 AND reprocesado = 0";
    private final String SQL_SELECT_RANGOS_PROCESO_INCOMPLETO = "SELECT id, id_primero, id_ultimo \n"
            + "FROM dbo.ultimo_rango_avl_id \n"
            + "WHERE id IN\n"
            + "	(SELECT id \n"
            + "	FROM  dbo.ultimo_rango_avl_id\n"
            + "	WHERE proceso_completo = 0 AND reprocesado = 0)";
    private final String SQL_TRUNCATE_TABLE_AVL_IDS_FALTANTES = "TRUNCATE TABLE dbo.tmp_avl_ids_faltantes";

    private final String SQLFN_AVL_REG_COUNT = "SELECT [motor].[fn_carga_avl_to_intermedia_total_count]() AS total_count";
    //procedimientos almacenados en BD DBFIMPETISA:
    private final String SQLSP_DBINTERMEDIA_TO_DBFIMPETISA = "exec [motor].[sp_carga_dbintermedia_to_dbfimpetisa]";
    private final String SQLSP_CREATE_DEBIT_TMP_TABLE = "exec [motor].[sp_crear_tablatmp_debito]";
    private final String SQLSP_SELECT_DEBITOS = "EXEC [motor].[sp_obtener_registros_debitos]";

    public ConsultasSQL(Connection conn) {
        DBConnection = conn;
    }

    public int getAVLRegCount() throws SQLException {
        PreparedStatement prepareStatement = DBConnection.prepareStatement("SELECT [motor].[fn_carga_avl_to_intermedia_total_count]() AS total_count");
        prepareStatement.execute();
        ResultSet resultSet = prepareStatement.getResultSet();
        resultSet.next();
        return resultSet.getInt("total_count");
    }

    public int getSFINXRegCount() throws SQLException {
        PreparedStatement prepareStatement = DBConnection.prepareStatement("SELECT [motor].[fn_carga_sfinx_to_intermedia_total_count]() AS total_count");
        prepareStatement.execute();
        ResultSet resultSet = prepareStatement.getResultSet();
        resultSet.next();
        return resultSet.getInt("total_count");
    }

    public String getSQLSP_SFINXFIMPE() {
        return SQLSP_SFINXFIMPE;
    }

    public String getSQLSP_SFINXFIMPE_SELECTS() {
        return SQLSP_SFINXFIMPE_SELECTS;
    }

    public String getSQLSP_SFINX() {
        return SQLSP_SFINX;
    }

    public String getSQLSP_SFINX_SELECTS() {
        return SQLSP_SFINX_SELECTS;
    }

    public String getSQLSP_AVLGPRS() {
        return SQLSP_AVLGPRS;
    }

    public String getSQLSP_AVLGPRS_SELECTS() {
        return SQLSP_AVLGPRS_SELECTS;
    }

    public StoredProcedure executeSP(String sp_name) throws SQLException {
        CallableStatement prepareCall = DBConnection.prepareCall(sp_name);
        prepareCall.execute();
        return new StoredProcedure(prepareCall, prepareCall.getResultSet());
    }

    public void insertarRangoUltimosIDs(Connection DBConnection, boolean proceso_completo) throws SQLException {
        if (proceso_completo) {
            executeSP(SQLSP_AVLGPRS_RANGO_IDS_COMPLETED);
        } else {
            executeSP(SQLSP_AVLGPRS_RANGO_IDS_UNCOMPLETED);
        }
    }

    public String getSQLSP_DBINTERMEDIA_TO_DBFIMPETISA() {
        return SQLSP_DBINTERMEDIA_TO_DBFIMPETISA;
    }

    public String getSQLFN_AVL_REG_COUNT() {
        return SQLFN_AVL_REG_COUNT;
    }

    public String getSQLSP_CREATE_DEBIT_TMP_TABLE() {
        return SQLSP_CREATE_DEBIT_TMP_TABLE;
    }

    public String getSQLSP_SELECT_DEBITOS() {
        return SQLSP_SELECT_DEBITOS;
    }

    public String getSQLSP_AVLGPRS_FALTANTES() {
        return SQLSP_AVLGPRS_FALTANTES;
    }

    public String getSQLFN_AVLGPRS_FALTANTES_COUNTS() {
        return SQLFN_AVLGPRS_FALTANTES_COUNTS;
    }

    public String getSQLSP_AVLGPRS_FALTANTES_SELECTS() {
        return SQLSP_AVLGPRS_FALTANTES_SELECTS;
    }

    public String getSQLSP_AVLGPRS_FALTANTES2() {
        return SQLSP_AVLGPRS_FALTANTES2;
    }

    public String getParameterizedFor_SQLSP_AVLGPRS_FALTANTES2(String id_primero, String id_ultimo) {
        String sb = SQLSP_AVLGPRS_FALTANTES2.replace("@id_primero", id_primero);
        return sb.replace("@id_ultimo", id_ultimo);
    }
 
    
    public String getSQL_SELECT_COUNT_RANGOS_PROCESO_INCOMPLETO() {
        return SQL_SELECT_COUNT_RANGOS_PROCESO_INCOMPLETO;
    }

    public String getSQL_SELECT_RANGOS_PROCESO_INCOMPLETO() {
        return SQL_SELECT_RANGOS_PROCESO_INCOMPLETO;
    }

    public String getSQL_TRUNCATE_TABLE_AVL_IDS_FALTANTES() {
        return SQL_TRUNCATE_TABLE_AVL_IDS_FALTANTES;
    }
    
    

}
