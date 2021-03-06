package entity;

import java.sql.Timestamp;

public class DetailPerubahanEntity {
    protected String keterangan;
    protected String data_sebelum;
    protected String data_sesudah;
    protected ProdukEntity produk;
    protected AdminEntity admin;

    public DetailPerubahanEntity(String kategori, String data_sebelum, String data_sesudah, ProdukEntity produk, AdminEntity pegawai) {
        this.keterangan = kategori;
        this.data_sebelum = data_sebelum;
        this.data_sesudah = data_sesudah;
        this.produk = produk;
        this.admin = pegawai;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public String getDataSebelum() {
        return data_sebelum;
    }

    public void setDataSebelum(String data_sebelum) {
        this.data_sebelum = data_sebelum;
    }

    public String getDataSesudah() {
        return data_sesudah;
    }

    public void setDataSesudah(String data_sesudah) {
        this.data_sesudah = data_sesudah;
    }
    
    public ProdukEntity getProduk() {
        return produk;
    }

    public void setProduk(ProdukEntity produk) {
        this.produk = produk;
    }

    public AdminEntity getPegawai() {
        return admin;
    }

    public void setPegawai(AdminEntity admin) {
        this.admin = admin;
    }
}
