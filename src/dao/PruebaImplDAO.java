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
import pojos.Prueba;
import org.postgresql.jdbc.PgResultSet;
/**
 *
 * @author n6y
 */
public class PruebaImplDAO extends DAOFactory<Prueba>{
    private static final String SQL_INSERT
            = "INSERT INTO sfx_sch_pry_tisa.prueba"
            + " VALUES (?,?,?)";

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
    
    public PruebaImplDAO() {
        super(SQL_ALL, SQL_INSERT, SQL_UPDATE, SQL_DELETE);
    }
    
    public int create(Prueba p) throws DAOException, IOException {
        return super.insert(p);
    }

    public int edit(Prueba p) throws DAOException, IOException {
        return super.update(p);
    }

    public int remove(Prueba p) throws DAOException, IOException {
        return super.delete(p);
    }

    public Prueba find(Object id) throws DAOException, IOException {
        return find(SQL_FIND_BY_ID, id);
    }


    public List<Prueba> findAll() throws DAOException, IOException {
        return list(SQL_ALL);
    }

    //Construye un HashMap (Clave, Valor) a partir de un objeto que será insertado como un registro en la Base de Datos
    HashMap<String, Object> convertObjToParam(Prueba object) {
        LinkedHashMap<String, Object> params = new LinkedHashMap<>();
       //insertar parametros en el orden que aparecen en la consulta SQL
        params.put("id", object.getId());
        params.put("nombre", object.getNombre());
        params.put("created_at", object.getCreated_at()); 
        return params;
    }

    //Construye un objeto Ope_Person a partir de un registro existente en la Base de Datos
    Prueba convertDbToOjb(ResultSet resultSet) throws SQLException {
        ResultSetMetaData metaData = resultSet.getMetaData();
        ArrayList<String> columnNames = new ArrayList();
        System.out.println("columnas resultset");
        for (int i = 0; i < metaData.getColumnCount(); i++) {
            columnNames.add(metaData.getColumnName(i+1));
            metaData.getColumnType(i+1);
        }
        
            System.out.println("no existe la columna nombre");
        Prueba p = new Prueba(
                resultSet.getLong("id"),
                resultSet.getString("nombre"), 
                resultSet.getDate("created_at"));

        return p;
    }

    @Override
    String modifyQuery(String sql) {
        if(sql.toLowerCase().contains("select")){
            return sql.toLowerCase().replaceAll("select [a-z_]+,* *[a-z,_ ]* from", "select * from");
        }
        return sql;
    }
}
