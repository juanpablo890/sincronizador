/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Files;
import java.util.List;
import java.util.logging.Level;

/**
 *
 * @author n6y
 */
public class Logger {

    public List<String> readLoggerFile(Path path) throws IOException {
        return Files.readAllLines(path);
    }
}
