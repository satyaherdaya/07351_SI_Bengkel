package controller;

import entity.ProdukEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class ProdukController {
    
    public int insertDataProduk(ProdukEntity produk){
        return ModelObjController.produkModel.insertDataProduk(produk);
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
}
