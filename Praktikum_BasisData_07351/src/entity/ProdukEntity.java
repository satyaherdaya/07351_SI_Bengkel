package entity;

public class ProdukEntity {
    protected int id_produk;
    protected String deskripsi_produk;
    protected int stok;
    protected int harga;
    protected KategoriEntity kategori;
    protected SupplierEntity supplier;

    public ProdukEntity(String deskripsi_produk, int stok, int harga, KategoriEntity kategori, SupplierEntity supplier) {
        this.deskripsi_produk = deskripsi_produk;
        this.stok = stok;
        this.harga = harga;
        this.kategori = kategori;
        this.supplier = supplier;
    }

    public ProdukEntity(int id_produk, String deskripsi_produk, int stok, int harga, KategoriEntity kategori, SupplierEntity supplier) {
        this.id_produk = id_produk;
        this.deskripsi_produk = deskripsi_produk;
        this.stok = stok;
        this.harga = harga;
        this.kategori = kategori;
        this.supplier = supplier;
    }

    public int getIdProduk() {
        return id_produk;
    }

    public void setIdProduk(int id_produk) {
        this.id_produk = id_produk;
    }

    public String getDeskripsiProduk() {
        return deskripsi_produk;
    }

    public void setDeskripsiProduk(String deskripsi_produk) {
        this.deskripsi_produk = deskripsi_produk;
    }

    public int getStok() {
        return stok;
    }

    public void setStok(int stok) {
        this.stok = stok;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public KategoriEntity getKategori() {
        return kategori;
    }

    public void setKategori(KategoriEntity kategori) {
        this.kategori = kategori;
    }

    public SupplierEntity getSupplier() {
        return supplier;
    }

    public void setSupplier(SupplierEntity supplier) {
        this.supplier = supplier;
    }
    
    
}
