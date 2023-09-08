package dao;

import controller.ConnectionDB;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.naming.NamingException;

public abstract class DAOFactory<T> {

    private final String SQL_ALL;
    private final String SQL_INSERT;
    private final String SQL_UPDATE;
    private final String SQL_DELETE;

    public DAOFactory(String sql_all, String sql_insert, String sql_update, String sql_delete) {
        this.SQL_ALL = sql_all;
        this.SQL_INSERT = sql_insert;
        this.SQL_UPDATE = sql_update;
        this.SQL_DELETE = sql_delete;
    }

    public int insert(T object) throws DAOException, IOException {
        System.out.println("insertar...");
        try {
            return executeUpdate(SQL_INSERT, convertObjToParam(object));
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    public int update(T object) throws DAOException, IOException {
        try {
            return executeUpdate(SQL_UPDATE, convertObjToParam(object));
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    public int delete(T object) throws DAOException, IOException {
        try {
            return executeUpdate(SQL_DELETE, convertObjToParam(object));
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
    }

    public T find(String sql, Object... values) throws DAOException, IOException {
        T object = null;
        try {
            System.out.println("sql: " + sql);
            System.out.println("values: ");
//            for (Object value : values) {
//                System.out.println(value);
//            }
            object = executeQuery(sql, values);
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
        return object;
    }

    public List<T> findAll() throws DAOException, IOException {
        return list(SQL_ALL);
    }

    public List<T> list(String sql, Object... values) throws DAOException, IOException {
        List<T> list = null;
        try {
            list = executeQueryList(sql, values);
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
        return list;
    }

    public Object singleResult(String sql, Object... values) throws DAOException, IOException {
        Object object = null;
        try {
            object = executeQuerySingleResult(sql, values);
        } catch (NamingException | SQLException e) {
            throw new DAOException(e);
        }
        return object;
    }

    public int executeUpdate(String sql, Map<String, Object> params) throws SQLException, NamingException, IOException {
        Connection connection = null;
//        CallableStatement statement = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
//            statement = connection.prepareCall(sql); //procedimientos almacenados
            statement = connection.prepareStatement(sql);
            setParams(statement, params, sql);
            return statement.executeUpdate();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    public int executeUpdate(String sql, Object... params) throws SQLException, NamingException, IOException {
        Connection connection = null;
//        CallableStatement statement = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;

        try {
            connection = getConnection();
//            statement = connection.prepareCall(sql);
            statement = connection.prepareStatement(sql);
//            setParams(statement, params, sql);
            setValues(statement, params);
            return statement.executeUpdate();
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }

    private T executeQuery(String sql, Object... values) throws SQLException, NamingException, IOException {
        List<T> list = executeQueryList(sql, values);
        return list.size() > 0 ? list.get(0) : null;
    }

    private List<T> executeQueryList(String sql, Object... values) throws SQLException, NamingException, IOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<T> list = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(modifyQuery(sql));
            System.out.println("sql modified: " + modifyQuery(sql));
//            Statement cs = connection.createStatement();
            System.out.println("statement: " + statement.toString());
            System.out.println("values... " + Arrays.toString(values));
            System.out.println();
            setValues(statement, values);
            resultSet = statement.executeQuery();
//pasar nombres de columnas en query como parámetros
            list = new ArrayList<>();
            while (resultSet.next()) {
                T object = convertDbToOjb(resultSet);
                list.add(object);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }

    public List<Object> singleList(String sql, Object... values) throws DAOException, IOException {
        List<Object> list = null;
        try {
            list = executeQuerySingleList(sql, values);
        } catch (SQLException | NamingException e) {
            throw new DAOException(e);
        }
        return list;
    }

    private List<Object> executeQuerySingleList(String sql, Object... values) throws SQLException, NamingException, IOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        List<Object> list = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setValues(statement, values);
            resultSet = statement.executeQuery();

            list = new ArrayList<>();
            while (resultSet.next()) {
                Object object = (Object) resultSet.getObject(0);
                list.add(object);
            }
        } finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return list;
    }

    private Object executeQuerySingleResult(String sql, Object... values) throws SQLException, NamingException, IOException {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        Object object = null;
        try {
            connection = getConnection();
            statement = connection.prepareStatement(sql);
            setValues(statement, values);
            resultSet = statement.executeQuery();

            if (resultSet.next()) {
                object = resultSet.getObject(1);
            }

        } finally {
            if (resultSet != null) {
                resultSet.close();
            }

            if (statement != null) {
                statement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
        return object;
    }

    private Connection getConnection() throws NamingException, SQLException, IOException {
        ConnectionDB connect;
        connect = new ConnectionDB();
        Connection conn = connect.DBConnection();
        return conn;
    }

    public String buildXMLQuery(String sql, String rowTagName) {
        String tableName;
        sql = sql.toLowerCase();
        Pattern pfrom = Pattern.compile("from [a-z0-9_.]+ *(join [a-z0-9_.]+ on [a-z0-9_.]+ = [0-9a-z_.]+ )*");
        Pattern pwhere = Pattern.compile("where [a-z0-9_.]+ (=|like) [a-z0-9_.'\\? %]+ *(and|or [a-z0-9_.]+ = [a-z0-9_.\\?'% ]+)*");
        Matcher matcherFrom = pfrom.matcher(sql);
        Matcher matcherWhere = pwhere.matcher(sql);
        String query = null;
        boolean findFrom = matcherFrom.find();
        boolean findWhere = matcherWhere.find();
        if (findFrom) {
            try {

                tableName = (matcherFrom.group().replace("from ", ""));
                System.out.println(tableName);
                if (rowTagName == null) {
                    rowTagName = "registro";
                } else if (rowTagName.equals("")) {
                    rowTagName = "registro";
                }
                query = "SELECT concat(E'\\t\\t',xmlelement(\n"
                        + "\tname " + rowTagName + "\n"
                        + //nombre del registro obtenido
                        "\t,E'\\n'\n"
                        + "\t,E'\\t\\t\t'\n";
                // +                         "	,xmlelement(name c1, p1)\n" +
                //                        "	,E'\\n'\n" +
                //                        "	,E'\\t\\t\t'\n" +
                //                        "	,xmlelement(name c2, p2)\n" +
                //                        "	,E'\\n'\n" +
                //                        "	,E'\\t\\t\t'\n" +
                //                        "	,xmlelement(name c3, p3)\n" +
//                "	,E'\\n', E'\\t\\t')) as xmlelement\n"
//                + "FROM sfx_sch_pry_tisa.ope_person";
                List<String> nameParams = new ArrayList<>();
                Pattern p = Pattern.compile("select [a-z_,* ]+ from");
                Matcher matcher = p.matcher(sql);
                matcher.find();
                String[] split = matcher.group().replace("select ", "").replace(" from", "").split(",");
                for (String string : split) {
                    nameParams.add(string.trim());
                }

                int i = 1;
                for (String nameParam : nameParams) {
                    String fragment = "\t,xmlelement(name c1, p1)\n";
                    System.out.println(nameParam);
                    query += fragment.replace("c1", "c" + i).replace("p1", nameParam);

                    if (i == nameParams.size()) {
                        query += "\t,E'\\n'\n";
                    } else {
                        query += "\t,E'\\n'\n\t,E'\\t\\t\\t'" + "\n";
                    }
                    i++;
                }
                query += "\t,E'\\t\\t')) as xmlelement\n"
                        + "FROM " + tableName;
                if (findWhere) {
                    System.out.println("where: " + matcherWhere.group());
                    query += "\n" + matcherWhere.group().replace("where", "WHERE");
                }
                System.out.println("sql construido: \n" + query);
            } catch (IllegalStateException ise) {
                ise.printStackTrace();
                System.out.println("query invalida");
            }
        }
        return query;
    }

    private void setValues(PreparedStatement statement, Object... values) throws SQLException {
        System.out.println("imprimir valores:");
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);
            statement.setObject(i + 1, values[i]);
        }
    }

    private void setParams(PreparedStatement statement, Map<String, Object> values, String sql) throws SQLException {
        //String[] split = sql.replaceAll(",", " ").split(" ");
        sql = sql.toLowerCase();
        List<String> nameParams = new ArrayList<>();
        Set<String> keySet = values.keySet(); //obtener nombres de llaves del HashMap
        if (sql.startsWith("insert")) {
            int j = 0;
            for (String keyName : keySet) {
                j++;
                Object value = values.get(keyName);
                System.out.println(keyName + "=" + value);
                statement.setObject(j, value);
            }
        } else {
            Pattern p = Pattern.compile("[a-z_]+ =|like \\?");
            Matcher matcher = p.matcher(sql.toLowerCase());
            while (matcher.find()) {
                nameParams.add(matcher.group().replace("like", "").replace(" =", ""));
                System.out.println("Cant params:" + values.size());
                int i = 0;
                for (String nameParam : nameParams) {
                    Object value = values.get(nameParam);
                    statement.setObject(i + 1, value);
                    i++;
                }
            }
        }

//
//        for (String string : split) {
//            
//            if (string.startsWith(":")) {
//                nameParams.add(
//                        string.
//                        replaceAll(",", "").
//                        replaceAll(":", "").
//                        replaceAll("\\)", "").
//                        replaceAll(";", ""));
//            }
//        }
//        //System.out.println(nameParams.toString());
//        int j=0;
//        for (String keyName : keySet) {
//            j++;
//            Object value = values.get(keyName);
//            System.out.println(keyName+"="+value);
//            statement.setObject(j, value);
//        }
//        int i=0;
//        for (String string : nameParams) {
//            i++;
//            Object object = values.get(string);
//            System.out.println("string"+string);
////            if(object!=null){
////                System.out.println("Key:" + string + "->Value:" + object.toString());
////            }
//            
//            statement.setObject(i, object);
//        }
    }

    public java.sql.Date convertDate(java.util.Date dateUtil) {
        if (dateUtil == null) {
            return null;
        }
        return new java.sql.Date(dateUtil.getTime());
    }

    abstract Map<String, Object> convertObjToParam(T object);

    abstract T convertDbToOjb(ResultSet resultSet) throws SQLException;

    abstract String modifyQuery(String sql);

}
