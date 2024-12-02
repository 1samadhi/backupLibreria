package modelo;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioDAO {
    private static final Logger LOGGER = Logger.getLogger(UsuarioDAO.class.getName());
    private final Connection connection;

    public UsuarioDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para insertar un usuario
    public boolean insertarUsuario(Usuario usuario) {
        String sql = "INSERT INTO usuarios (username, password, email, rol) VALUES (?, ?, ?, ?)";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, usuario.getUsername());
            ps.setString(2, usuario.getPassword());
            ps.setString(3, usuario.getEmail());
            ps.setString(4, usuario.getRol());
            int filasInsertadas = ps.executeUpdate();
            return filasInsertadas > 0;
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al insertar usuario", e);
            return false;
        }
    }

    // Método para buscar un usuario por username y password
    public Usuario buscarUsuario(String username, String password) {
        String sql = "SELECT * FROM usuarios WHERE username = ? AND password = ?";

        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, username);
            ps.setString(2, password);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Usuario(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("rol"),
                        rs.getString("created_at")
                    );
                }
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al buscar usuario", e);
        }
        return null; // Si no se encuentra el usuario
    }
}
