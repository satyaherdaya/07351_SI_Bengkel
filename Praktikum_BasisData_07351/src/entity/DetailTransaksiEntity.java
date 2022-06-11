package entity;

public class DetailTransaksiEntity {
    protected int jumlah_produk;
    protected int jumlah_harga;
    protected ProdukEntity produk;
    protected TransaksiEntity transaksi;

    public DetailTransaksiEntity(int jumlah_produk, int jumlah_harga, ProdukEntity produk, TransaksiEntity transaksi) {
        this.jumlah_produk = jumlah_produk;
        this.jumlah_harga = jumlah_harga;
        this.produk = produk;
        this.transaksi = transaksi;
    }

    public int getJumlahProduk() {
        return jumlah_produk;
    }

    public void setJumlahProduk(int jumlah_produk) {
        this.jumlah_produk = jumlah_produk;
    }

    public int getJumlahHarga() {
        return jumlah_harga;
    }

    public void setJumlahHarga(int jumlah_harga) {
        this.jumlah_harga = jumlah_harga;
    }

    public ProdukEntity getProduk() {
        return produk;
    }

    public void setProduk(ProdukEntity produk) {
        this.produk = produk;
    }

    public TransaksiEntity getTransaksi() {
        return transaksi;
    }

    public void setTransaksi(TransaksiEntity transaksi) {
        this.transaksi = transaksi;
    }
}
