package modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Logger;
import java.util.logging.Level;

public class Conexion {
    private static final String URL = "jdbc:mysql://localhost:3306/libreria";
    private static final String USER = "root"; 
    private static final String PASSWORD = ""; 

    private static final Logger LOGGER = Logger.getLogger(Conexion.class.getName());

    public Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al conectar con la base de datos", e);
            return null;
        }
    }
}