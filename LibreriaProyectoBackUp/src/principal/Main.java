package principal;

import modelo.Conexion;
import modelo.Usuario;
import modelo.UsuarioDAO;
import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        Conexion conexionDB = new Conexion();
        Connection connection = conexionDB.getConnection();

        if (connection != null) {
            System.out.println("Conexión exitosa a la base de datos 'libreria'");

            UsuarioDAO usuarioDAO = new UsuarioDAO(connection);

            // Insertar un usuario
            Usuario nuevoUsuario = new Usuario("nuevo_user", "password123", "nuevo_user@libreria.com", "user");
            if (usuarioDAO.insertarUsuario(nuevoUsuario)) {
                System.out.println("Usuario insertado correctamente.");
            } else {
                System.out.println("Error al insertar el usuario.");
            }

            // Buscar un usuario
            Usuario usuarioEncontrado = usuarioDAO.buscarUsuario("nuevo_user", "password123");
            if (usuarioEncontrado != null) {
                System.out.println("Usuario encontrado: " + usuarioEncontrado.getUsername() + ", Email: " + usuarioEncontrado.getEmail());
            } else {
                System.out.println("Usuario no encontrado.");
            }
        } else {
            System.out.println("Error al conectar a la base de datos.");
        }
    }
}

