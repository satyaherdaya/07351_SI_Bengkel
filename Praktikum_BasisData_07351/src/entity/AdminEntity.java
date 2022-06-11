package entity;

public class AdminEntity {
    protected int id_admin;
    protected String nama_admin;
    protected String username;
    protected String passwrod;

    public AdminEntity(String nama_admin, String username, String passwrod) {
        this.nama_admin = nama_admin;
        this.username = username;
        this.passwrod = passwrod;
    }
    
    public AdminEntity(int id_admin, String nama_admin, String username, String passwrod) {
        this.id_admin = id_admin;
        this.nama_admin = nama_admin;
        this.username = username;
        this.passwrod = passwrod;
    }

    public int getIdAdmin() {
        return id_admin;
    }

    public void setIdAdmin(int id_admin) {
        this.id_admin = id_admin;
    }

    public String getNamaAdmin() {
        return nama_admin;
    }

    public void setNamaAdmin(String nama_admin) {
        this.nama_admin = nama_admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswrod() {
        return passwrod;
    }

    public void setPasswrod(String passwrod) {
        this.passwrod = passwrod;
    }
}
