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
import pojos.DescargaAVL;
import pojos.Prueba;
/**
 *
 * @author n6y
 */
public class DescargaAVLImplDAO extends DAOFactory<DescargaAVL>{
    private static final String SQL_INSERT
            = "INSERT INTO tblDescargasAVL"
            + " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

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
    
    public DescargaAVLImplDAO() {
        super(SQL_ALL, SQL_INSERT, SQL_UPDATE, SQL_DELETE);
    }
    
    public int create(DescargaAVL d) throws DAOException, IOException {
        return super.insert(d);
    }

    public int edit(DescargaAVL d) throws DAOException, IOException {
        return super.update(d);
    }

    public int remove(DescargaAVL d) throws DAOException, IOException {
        return super.delete(d);
    }

    public DescargaAVL find(Object id) throws DAOException, IOException {
        return find(SQL_FIND_BY_ID, id);
    }


    public List<DescargaAVL> findAll() throws DAOException, IOException {
        return list(SQL_ALL);
    }

    //Construye un HashMap (Clave, Valor) a partir de un objeto que será insertado como un registro en la Base de Datos
    HashMap<String, Object> convertObjToParam(DescargaAVL object) {
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
       //insertar parametros en el orden que aparecen en la consulta SQL
        params.put("id", object.getId());
        params.put("tipoAVL", object.getTipoAVL());
        params.put("modemID", object.getModemID());
        params.put("fLongitud_grad", object.getfLongitud_grad());
        params.put("fLalitud_grad", object.getfLalitud_grad());
        params.put("velocidad", object.getVelocidad());
        params.put("altitud", object.getAltitud());
        params.put("num_Sat", object.getNum_Sat());
        params.put("heading", object.getHeading());
        params.put("dFecha_hora_Sat", object.getdFecha_hora_Sat());
        params.put("tipo_evento", object.getTipo_evento());
        params.put("variable1", object.getVariable1());
        params.put("variable2", object.getVariable2());
        params.put("variable3", object.getVariable3());
        params.put("variable4", object.getVariable4());
        params.put("dFechaHoraComputadora", object.getdFechaHoraComputadora());
        params.put("varControl", object.getVarControl());
        params.put("status", object.getStatus());
        return params;
    }

    //Construye un objeto DescargaAVL a partir de un registro existente en la Base de Datos
    DescargaAVL convertDbToOjb(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        ArrayList<String> columnNames = new ArrayList();
        System.out.println("columnas resultset");
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            columnNames.add(metaData.getColumnName(i+1));
            metaData.getColumnType(i+1);
        }
        
        DescargaAVL d = new DescargaAVL(resultSet.getLong("id"), 
                resultSet.getInt("intTipoAVL"), 
                resultSet.getString("strModemID"), 
                resultSet.getFloat("fLongitud_grad"), 
                resultSet.getFloat("fLatitud_grad"), 
                resultSet.getInt("intVelocidad"), 
                resultSet.getInt("intAltitud"), 
                resultSet.getInt("intNum_Sat"), 
                resultSet.getInt("intHeading"), 
                resultSet.getTimestamp("dFecha_Hora_SAT"), 
                resultSet.getInt("intTipo_Evento"), 
                resultSet.getInt("intVariable1"), 
                resultSet.getInt("intVariable2"), 
                resultSet.getInt("intVariable3"), 
                resultSet.getInt("intVariable4"), 
                resultSet.getTimestamp("dFechaHoraComputadora"), 
                resultSet.getInt("intVarControl"), 
                resultSet.getInt("intStatus"));

        return d;
    }


}
