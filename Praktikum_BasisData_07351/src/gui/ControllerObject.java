package gui;

import controller.*;

public class ControllerObject {
    public static AdminController adminController = new AdminController();
    public static CustomerController customerController = new CustomerController();
    public static KasirController kasirController = new KasirController();
    public static KategoriController kategoriController = new KategoriController();
    public static ProdukController produkController = new ProdukController();
    public static SupplierController supplierController = new SupplierController();
    public static TransaksiController transaksiController = new TransaksiController();
    public static DetailTransaksiController detTrxController = new DetailTransaksiController();
    public static DetailPerubahanController detUbahController = new DetailPerubahanController();

}
