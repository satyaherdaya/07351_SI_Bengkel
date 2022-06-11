package entity;

import java.sql.Timestamp;

public class TransaksiEntity {
    protected int id_transaksi;
    protected Timestamp tgl_transaksi;
    protected int total_harga;
    protected CustomerEntity customer;
    protected KasirEntity kasir;
    protected DetailTransaksiEntity detailTrx;
    protected ProdukEntity produk;

    public TransaksiEntity(Timestamp tgl_transaksi, int total_harga, CustomerEntity customer, KasirEntity kasir, DetailTransaksiEntity detailTrx, ProdukEntity produk) {
        this.tgl_transaksi = tgl_transaksi;
        this.total_harga = total_harga;
        this.customer = customer;
        this.kasir = kasir;
        this.detailTrx = detailTrx;
        this.produk = produk;
    }
    
    public TransaksiEntity(int id_transaksi, Timestamp tgl_transaksi, int total_harga, CustomerEntity customer, KasirEntity kasir) {
        this.id_transaksi = id_transaksi;
        this.tgl_transaksi = tgl_transaksi;
        this.total_harga = total_harga;
        this.customer = customer;
        this.kasir = kasir;
    }

    public TransaksiEntity(int id_transaksi, Timestamp tgl_transaksi, int total_harga, CustomerEntity customer, KasirEntity kasir, DetailTransaksiEntity detailTrx, ProdukEntity produk) {
        this.id_transaksi = id_transaksi;
        this.tgl_transaksi = tgl_transaksi;
        this.total_harga = total_harga;
        this.customer = customer;
        this.kasir = kasir;
        this.detailTrx = detailTrx;
        this.produk = produk;
    }

    public int getIdTransaksi() {
        return id_transaksi;
    }

    public void setIdTransaksi(int id_transaksi) {
        this.id_transaksi = id_transaksi;
    }

    public Timestamp getTglTransaksi() {
        return tgl_transaksi;
    }

    public void setTglTransaksi(Timestamp tgl_transaksi) {
        this.tgl_transaksi = tgl_transaksi;
    }

    public int getTotalHarga() {
        return total_harga;
    }

    public void setTotalHarga(int total_harga) {
        this.total_harga = total_harga;
    }

    public CustomerEntity getCustomer() {
        return customer;
    }

    public void setCustomer(CustomerEntity customer) {
        this.customer = customer;
    }

    public KasirEntity getKasir() {
        return kasir;
    }

    public void setKasir(KasirEntity kasir) {
        this.kasir = kasir;
    }

    public DetailTransaksiEntity getDetailTrx() {
        return detailTrx;
    }

    public void setDetailTrx(DetailTransaksiEntity detailTrx) {
        this.detailTrx = detailTrx;
    }

    public ProdukEntity getProduk() {
        return produk;
    }

    public void setProduk(ProdukEntity produk) {
        this.produk = produk;
    }
}
