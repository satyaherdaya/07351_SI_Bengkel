package entity;

public class KasirEntity {
    protected int id_pegawai;
    protected String nama_pegawai;
    protected String notelp_pegawai;
    protected String alamat_pegawai;
    protected String username;
    protected String password;

    public KasirEntity(String nama_pegawai, String notelp_pegawai, String alamat_pegawai, String username, String password) {
        this.nama_pegawai = nama_pegawai;
        this.notelp_pegawai = notelp_pegawai;
        this.alamat_pegawai = alamat_pegawai;
        this.username = username;
        this.password = password;
    }

    public KasirEntity(int id_pegawai, String nama_pegawai, String notelp_pegawai, String alamat_pegawai, String username, String password) {
        this.id_pegawai = id_pegawai;
        this.nama_pegawai = nama_pegawai;
        this.notelp_pegawai = notelp_pegawai;
        this.alamat_pegawai = alamat_pegawai;
        this.username = username;
        this.password = password;
    }

    public int getIdPegawai() {
        return id_pegawai;
    }

    public void setIdPegawai(int id_pegawai) {
        this.id_pegawai = id_pegawai;
    }

    public String getNamaPegawai() {
        return nama_pegawai;
    }

    public void setNamaPegawai(String nama_pegawai) {
        this.nama_pegawai = nama_pegawai;
    }

    public String getNotelpPegawai() {
        return notelp_pegawai;
    }

    public void setNotelpPegawai(String notelp_pegawai) {
        this.notelp_pegawai = notelp_pegawai;
    }

    public String getAlamatPegawai() {
        return alamat_pegawai;
    }

    public void setAlamatPegawai(String alamat_pegawai) {
        this.alamat_pegawai = alamat_pegawai;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
