package entity;

public class SupplierEntity {
    protected int id_supplier;
    protected String nama_supplier;
    protected String notelp_supplier;
    protected String alamat_supplier;

    public SupplierEntity(String nama_supplier, String notelp_supplier, String alamat_supplier) {
        this.nama_supplier = nama_supplier;
        this.notelp_supplier = notelp_supplier;
        this.alamat_supplier = alamat_supplier;
    }

    public SupplierEntity(int id_supplier, String nama_supplier, String notelp_supplier, String alamat_supplier) {
        this.id_supplier = id_supplier;
        this.nama_supplier = nama_supplier;
        this.notelp_supplier = notelp_supplier;
        this.alamat_supplier = alamat_supplier;
    }

    public int getIdSupplier() {
        return id_supplier;
    }

    public void setIdSupplier(int id_supplier) {
        this.id_supplier = id_supplier;
    }

    public String getNamaSupplier() {
        return nama_supplier;
    }

    public void setNamaSupplier(String nama_supplier) {
        this.nama_supplier = nama_supplier;
    }

    public String getNotelpSupplier() {
        return notelp_supplier;
    }

    public void setNotelpSupplier(String notelp_supplier) {
        this.notelp_supplier = notelp_supplier;
    }

    public String getAlamatSupplier() {
        return alamat_supplier;
    }

    public void setAlamatSupplier(String alamat_supplier) {
        this.alamat_supplier = alamat_supplier;
    }
}
