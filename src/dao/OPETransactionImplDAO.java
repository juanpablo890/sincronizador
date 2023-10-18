/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import pojos.OpeTransaction;
/**
 *
 * @author n6y
 */
public class OPETransactionImplDAO extends DAOFactory<OpeTransaction>{
    private static final String SQL_INSERT
            = "INSERT INTO sfinx.ope_transaction"
            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

    private static final String SQL_UPDATE
            = "UPDATE sfx_sch_pry_tisa.prueba "
            + " SET  "
            + " nombre = ?, "
            + " created_at = ? "
            + " WHERE id = ? ";
    private static final String SQL_DELETE
            = "DELETE FROM sfx_sch_pry_tisa.prueba WHERE id = ?";

    private static final String SQL_ALL
            = "SELECT * FROM sfx_sch_pry_tisa.prueba";

    private static final String SQL_FIND_BY_ID
            = "SELECT * FROM sfx_sch_pry_tisa.prueba WHERE id = ? ";
    
    public OPETransactionImplDAO() {
        super(SQL_ALL, SQL_INSERT, SQL_UPDATE, SQL_DELETE);
    }

    
    public int create(OpeTransaction t) throws DAOException, IOException {
        return super.insert(t);
    }

    public int edit(OpeTransaction t) throws DAOException, IOException {
        return super.update(t);
    }

    public int remove(OpeTransaction t) throws DAOException, IOException {
        return super.delete(t);
    }

    public OpeTransaction find(Object id) throws DAOException, IOException {
        return find(SQL_FIND_BY_ID, id);
    }


    public List<OpeTransaction> findAll() throws DAOException, IOException {
        return list(SQL_ALL);
    }

    //Construye un HashMap (Clave, Valor) a partir de un objeto que será insertado como un registro en la Base de Datos
    HashMap<String, Object> convertObjToParam(OpeTransaction object) {
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
       //insertar parametros en el orden que aparecen en la consulta SQL
        params.put("id", object.getId());
        params.put("collection_id", object.getCollection_id());
        params.put("transaction_type", object.getTransaction_type());
        params.put("transaction_folio", object.getTransaction_folio());
        params.put("event_date", object.getEvent_date());
        params.put("car_uid", object.getCard_uid());
        params.put("product", object.getProduct());
        params.put("ruta", object.getRuta());
        params.put("amount", object.getAmount());
        params.put("ini_vig_prod", object.getIni_vig_prod());
        params.put("fin_vig_prod", object.getFin_vig_prod());
        params.put("ini_val_day", object.getIni_val_day());
        params.put("fin_val_day", object.getFin_val_day());
        params.put("initial_balance", object.getInitial_balance());
        params.put("final_balance", object.getFinal_balance());
        params.put("station_id", object.getStation_id());
        params.put("uid_sam", object.getUid_sam());
        params.put("consecutive_sam", object.getConsecutive_sam());
        params.put("consecutive_app", object.getConsecutive_app());
        params.put("latitude", object.getLatitude());
        params.put("longitude", object.getLongitude());
        params.put("recharge_type", object.getRecharge_type());
        params.put("debit_type", object.getDebit_type());
        params.put("sign_parameters", object.getSign_parameters());
        params.put("sign_transaction", object.getSign_transaction());
        params.put("consecutive_sam", object.getConsecutive_sam());
        params.put("device_id", object.getConsecutive_app());
        params.put("profile_code", object.getProfile_code());
        params.put("created_at", object.getCreated_at());
        params.put("updated_at", object.getUpdated_at());
        params.put("status", object.getStatus());
        params.put("previous_card", object.getPrevious_card());
        return params;
    }

    //Construye un objeto OPETrancaction a partir de un registro existente en la Base de Datos
    OpeTransaction convertDbToOjb(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        ArrayList<String> columnNames = new ArrayList();
        System.out.println("columnas resultset");
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            columnNames.add(metaData.getColumnName(i+1));
            metaData.getColumnType(i+1);
        }
        
        OpeTransaction t = new OpeTransaction(resultSet.getLong("id"), 
                resultSet.getLong("intTipoAVL"), 
                resultSet.getString("strModemID"), 
                resultSet.getString("fLongitud_grad"), 
                resultSet.getString("fLatitud_grad"), 
                resultSet.getString("intVelocidad"), 
                resultSet.getString("intAltitud"), 
                resultSet.getString("intNum_Sat"), 
                resultSet.getBigDecimal("intHeading"), 
                resultSet.getString("dFecha_Hora_SAT"), 
                resultSet.getString("intTipo_Evento"), 
                resultSet.getString("intVariable1"), 
                resultSet.getString("intVariable2"), 
                resultSet.getDouble("intVariable3"), 
                resultSet.getDouble("intVariable4"), 
                resultSet.getString("dFechaHoraComputadora"), 
                resultSet.getString("intVarControl"),
                resultSet.getLong("intVarControl"), 
                resultSet.getLong("intVarControl"), 
                resultSet.getDouble("intVarControl"), 
                resultSet.getDouble("intVarControl"), 
                resultSet.getString("intVarControl"), 
                resultSet.getString("intVarControl"), 
                resultSet.getString("intVarControl"), 
                resultSet.getString("intVarControl"), 
                resultSet.getString("intVarControl"), 
                resultSet.getLong("intVarControl"), 
                resultSet.getString("intVarControl"), 
                resultSet.getString("intVarControl"), 
                resultSet.getBoolean("intVarControl"),  
                resultSet.getString("intStatus"));

        return t;
    }


}
