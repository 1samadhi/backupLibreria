package modelo;

public class Libro {
    private int id;
    private String titulo;
    private String autor;
    private String genero;
    private String publicado;
    private int cantidad;
    private int precio;

    // Constructor para libros nuevos (sin ID)
    public Libro(String titulo, String autor, String genero, String publicado, int cantidad, int precio) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.publicado = publicado;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Constructor para libros existentes (con ID)
    public Libro(int id, String titulo, String autor, String genero, String publicado, int cantidad, int precio) {
        this.id = id;
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.publicado = publicado;
        this.cantidad = cantidad;
        this.precio = precio;
    }

    // Getters y Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getPublicado() {
        return publicado;
    }

    public void setPublicado(String publicado) {
        this.publicado = publicado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
}


