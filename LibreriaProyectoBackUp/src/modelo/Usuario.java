package modelo;

public class Usuario {
    private int id;
    private String username;
    private String password;
    private String email;
    private String rol;
    private String createdAt;

    // Constructor completo
    public Usuario(int id, String username, String password, String email, String rol, String createdAt) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.rol = rol;
        this.createdAt = createdAt;
    }

    // Constructor para inserciones (sin ID y fecha)
    public Usuario(String username, String password, String email, String rol) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.rol = rol;
    }

    // Getters y Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }

    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getRol() { return rol; }
    public void setRol(String rol) { this.rol = rol; }

    public String getCreatedAt() { return createdAt; }
    public void setCreatedAt(String createdAt) { this.createdAt = createdAt; }
}
