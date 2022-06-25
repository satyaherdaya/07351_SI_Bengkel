package controller;

import entity.KategoriEntity;
import entity.ProdukEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ProdukController {
    
    public int insertDataProduk(ProdukEntity produk){
        return ModelObjController.produkModel.insertDataProduk(produk);
    }
    
    public int insertDataProdukJasa(String deskripsi,int harga,KategoriEntity kategori){
        return ModelObjController.produkModel.insertDataProdukJasa(deskripsi, harga, kategori);
    }
    
    public ProdukEntity satuDataProduk(int id){
        return ModelObjController.produkModel.dataSatuProduk(id);
    }
    
    public ArrayList<ProdukEntity> dataPorduk(){
        return ModelObjController.produkModel.dataProduk();
    }
    
    public int ubahDeskripsiProduk(String des,int id){
        return ModelObjController.produkModel.ubahDeskripsiProduk(des, id);
    }
    
    public int ubahStokProduk(int stok,int id){
        return ModelObjController.produkModel.ubahStokProduk(stok, id);
    }
    
    public int ubahHargaProduk(int harga,int id){
        return ModelObjController.produkModel.ubahHargaProduk(harga, id);
    }
    
    public int hapusSatuDataProduk(int id){
        return ModelObjController.produkModel.hapusSatuDataProduk(id);
    }
    
    public DefaultTableModel listProduk(){
        return ModelObjController.produkModel.listProduk();
    }
    
    public DefaultTableModel listProdukLengkap(){
        return ModelObjController.produkModel.listProdukLengkap();
    }
    
    public int kurangiSatuStock(int idTransaksi,int idProduk){
        return ModelObjController.produkModel.kurangiSatuStock(idTransaksi, idProduk);
    }
}
