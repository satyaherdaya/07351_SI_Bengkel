package entity;

public class KategoriEntity {
    protected int id_kategori;
    protected String nama_kategori;

    public KategoriEntity(int id_kategori, String nama_kategori) {
        this.id_kategori = id_kategori;
        this.nama_kategori = nama_kategori;
    }

    public int getIdKategori() {
        return id_kategori;
    }

    public void setIdKategori(int id_kategori) {
        this.id_kategori = id_kategori;
    }

    public String getNamaKategori() {
        return nama_kategori;
    }

    public void setNamaKategori(String nama_kategori) {
        this.nama_kategori = nama_kategori;
    }    
}
