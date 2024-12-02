
package principal;

import modelo.Conexion;
import modelo.Usuario;
import modelo.UsuarioDAO;
import vista.LoginView;

import java.sql.Connection;

public class AppMain {
    public static void main(String[] args) {
        // Conectar a la base de datos
        Conexion conexionDB = new Conexion();
        Connection connection = conexionDB.getConnection();

        if (connection != null) {
            System.out.println("Conexión exitosa a la base de datos 'libreria'");
            
            // Crear la pantalla de login
            LoginView loginView = new LoginView(connection);
            loginView.setVisible(true);
        } else {
            System.out.println("Error al conectar a la base de datos. Revisa la configuración.");
        }
    }
}