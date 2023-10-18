/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pojos;

/**
 *
 * @author n6y
 */
public class DatabaseConfiguration {
    private int id;
    private String database_alias;
    private String database_name;
    private String username;
    private String password;
    private String server;
    private int port;
    private int synchronization_frec_segs;
    private int records_quantity;
    private String sgbd;

    public DatabaseConfiguration(int id, String database_alias, String database_name, String username, String password, String server, int port, int synchronization_frec_segs, int records_quantity, String sgbd) {
        this.id = id;
        this.database_alias = database_alias;
        this.database_name = database_name;
        this.username = username;
        this.password = password;
        this.server = server;
        this.port = port;
        this.synchronization_frec_segs = synchronization_frec_segs;
        this.records_quantity = records_quantity;
        this.sgbd = sgbd;
    }

    public DatabaseConfiguration(String database_alias, String database_name, String username, String password, String server, int port, int synchronization_frec_segs, int records_quantity, String sgbd) {
        this.database_alias = database_alias;
        this.database_name = database_name;
        this.username = username;
        this.password = password;
        this.server = server;
        this.port = port;
        this.synchronization_frec_segs = synchronization_frec_segs;
        this.records_quantity = records_quantity;
        this.sgbd = sgbd;
    }
    

    public String getSgbd() {
        return sgbd;
    }

    public void setSgbd(String sgbd) {
        this.sgbd = sgbd;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDatabase_alias() {
        return database_alias;
    }

    public void setDatabase_alias(String database_alias) {
        this.database_alias = database_alias;
    }

    public String getDatabase_name() {
        return database_name;
    }

    public void setDatabase_name(String database_name) {
        this.database_name = database_name;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public int getSynchronization_frec_segs() {
        return synchronization_frec_segs;
    }

    public void setSynchronization_frec_segs(int synchronization_frec_segs) {
        this.synchronization_frec_segs = synchronization_frec_segs;
    }

    public int getRecords_quantity() {
        return records_quantity;
    }

    public void setRecords_quantity(int records_quantity) {
        this.records_quantity = records_quantity;
    }
    
}
