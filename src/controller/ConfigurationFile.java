package controller;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Juan Pablo
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Properties;

public class ConfigurationFile {
    public void createConfigurationFile(String database, String username, char[] password, String server, int port, int frecuency, int records_amount, String sgbd) throws IOException{
        Properties proper = new Properties();
        BufferedWriter bw = Files.newBufferedWriter(Path.of("config.properties"));
        proper.setProperty("database", database);
        proper.setProperty("username", username);
        proper.setProperty("password", String.valueOf(password));
        proper.setProperty("server", server);
        proper.setProperty("port", String.valueOf(port));
        proper.setProperty("syncronization_frec", String.valueOf(frecuency));
        proper.setProperty("records_amount", String.valueOf(records_amount));
        proper.setProperty("sgbd", sgbd);
        proper.store(bw, "archivo de configuración de conexión a la base de datos");
    }
    
    public HashMap readConfigurationFile() throws IOException{
        System.out.println("leer archivo de configuracion...");
        Properties proper = new Properties();
        BufferedReader br = Files.newBufferedReader(Path.of("config.properties"));
        proper.load(br);
        HashMap<String, Object> hashMap = new HashMap();
        hashMap.put("database", proper.get("database"));
        hashMap.put("username", proper.get("username"));
        hashMap.put("password", proper.get("password"));
        hashMap.put("server", proper.get("server"));
        hashMap.put("port", proper.get("port"));
        hashMap.put("syncronization_frec", proper.get("syncronization_frec"));
        hashMap.put("records_amount", proper.get("records_amount"));
        hashMap.put("sgbd", proper.get("sgbd"));
        return hashMap;
    }
}
