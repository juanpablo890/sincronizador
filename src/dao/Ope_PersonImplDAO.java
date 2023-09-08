/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.io.IOException;
import pojos.Ope_Person;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author n6y
 */
public class Ope_PersonImplDAO extends DAOFactory<Ope_Person>{
    private static final String SQL_INSERT
            = " INSERT INTO sfx_sch_pry_tisa.prueba (prueba)"
            + " VALUES ( :nombre)";

    private static final String SQL_UPDATE
            = " UPDATE SCU.CUBUID "
            + " SET  "
            + " UID_FK_CREDALUM = :credalum, "
            + " UID_FIRM = :firm, "
            + " UID_MOV_USER = :movuser, "
            + " UID_MOV_IP = :movip, "
            + " UID_MOV_DATE = :movdate, "
            + " UID_MOV_DML = :movdml "
            + " WHERE UID_PK_UNIQUE_ID = :unique_id ";
    private static final String SQL_DELETE
            = "DELETE FROM SCU.CUBUID WHERE UID_PK_UNIQUE_ID = :unique_id ";

    private static final String SQL_ALL
            = "SELECT * FROM sfx_sch_pry_tisa.ope_person";

    private static final String SQL_FIND_BY_UNIQUE_ID
            = "SELECT curp FROM sfx_sch_pry_tisa.ope_person WHERE curp = :name ";
    
    public Ope_PersonImplDAO() {
        super(SQL_ALL, SQL_INSERT, SQL_UPDATE, SQL_DELETE);
    }
    
    public int create(Ope_Person person) throws DAOException, IOException {
        return super.insert(person);
    }

    public int edit(Ope_Person person) throws DAOException, IOException {
        return super.update(person);
    }

    public int remove(Ope_Person person) throws DAOException, IOException {
        return super.delete(person);
    }

    public Ope_Person find(Object id) throws DAOException, IOException {
        return find(SQL_FIND_BY_UNIQUE_ID, id);
    }


    public List<Ope_Person> findAll() throws DAOException, IOException {
        return list(SQL_ALL);
    }

    //Construye un HashMap (Clave, Valor) a partir de un objeto CubUid que será insertado como un registro en la Base de Datos
    Map<String, Object> convertObjToParam(Ope_Person object) {
        Map<String, Object> params = new HashMap<>();
        
        params.put("person_id", object.getId());
        params.put("name", object.getName());
        params.put("first_last_name", object.getFirst_last_name());
        params.put("second_last_name", object.getSecond_last_name());
        params.put("curp", object.getCurp());
        params.put("gender", object.getGender());
        params.put("created_at", object.getCreated_at());
        params.put("updated_at", object.getUpdated_at());
        params.put("status", object.isStatus());
        params.put("birth_date", object.getBirth_date());
        return params;
    }

    //Construye un objeto Ope_Person a partir de un registro existente en la Base de Datos
    Ope_Person convertDbToOjb(ResultSet resultSet) throws SQLException {
        Ope_Person person = new Ope_Person(resultSet.getLong("id"),
                resultSet.getString("name"),
                resultSet.getString("first_last_name"),
                resultSet.getString("second_last_name"),
                resultSet.getString("curp"),
                resultSet.getString("gender"),
                resultSet.getDate("created_at"),
        resultSet.getDate("updated_at"), resultSet.getBoolean("status"),resultSet.getDate("birth_date"));

        return person;
    }

    @Override
    String modifyQuery(String sql) {
        if(sql.equalsIgnoreCase("SELECT")){
            return sql.replaceFirst("select".toUpperCase(), "SELECT");
        }
        return sql;
    }
}
