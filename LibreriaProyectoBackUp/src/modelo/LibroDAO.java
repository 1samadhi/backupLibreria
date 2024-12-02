package modelo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LibroDAO {
    private static final Logger LOGGER = Logger.getLogger(LibroDAO.class.getName());
    private final Connection connection;

    // Constructor que recibe la conexión
    public LibroDAO(Connection connection) {
        this.connection = connection;
    }

    // Método para obtener todos los libros
    public List<Libro> obtenerLibros() {
        List<Libro> libros = new ArrayList<>();
        String sql = "SELECT * FROM libros";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                libros.add(new Libro(
                    rs.getInt("id"),
                    rs.getString("titulo"),
                    rs.getString("autor"),
                    rs.getString("genero"),
                    rs.getString("publicado"),
                    rs.getInt("cantidad"),
                    rs.getInt("precio")
                ));
            }
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al obtener libros de la base de datos", e);
        }
        return libros;
    }

    // Método para insertar un libro en la base de datos
    public boolean insertarLibro(Libro libro) {
        String sql = "INSERT INTO libros (titulo, autor, genero, publicado, cantidad, precio) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getGenero());
            ps.setString(4, libro.getPublicado());
            ps.setInt(5, libro.getCantidad());
            ps.setInt(6, libro.getPrecio());
            return ps.executeUpdate() > 0; // Devuelve true si la inserción fue exitosa
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al insertar libro en la base de datos", e);
            return false;
        }
    }

    // Método para actualizar un libro en la base de datos
    public boolean actualizarLibro(Libro libro) {
        String sql = "UPDATE libros SET titulo = ?, autor = ?, genero = ?, publicado = ?, cantidad = ?, precio = ? WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getAutor());
            ps.setString(3, libro.getGenero());
            ps.setString(4, libro.getPublicado());
            ps.setInt(5, libro.getCantidad());
            ps.setInt(6, libro.getPrecio());
            ps.setInt(7, libro.getId());
            return ps.executeUpdate() > 0; // Devuelve true si la actualización fue exitosa
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al actualizar libro en la base de datos", e);
            return false;
        }
    }

    // Método para eliminar un libro en la base de datos
    public boolean eliminarLibro(int id) {
        String sql = "DELETE FROM libros WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0; // Devuelve true si la eliminación fue exitosa
        } catch (SQLException e) {
            LOGGER.log(Level.SEVERE, "Error al eliminar libro de la base de datos", e);
            return false;
        }
    }
}
