package controller;

import entity.TransaksiEntity;
import java.util.HashMap;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class TransaksiController {
    
    public int insertDataTransaksi(TransaksiEntity trx){
        return ModelObjController.transaksiModel.insertDataTransaksi(trx);
    }
    
    public TransaksiEntity satuDataTransaksi(int id){
        return ModelObjController.transaksiModel.dataSatuTransaksi(id);
    }
    
    public ArrayList<TransaksiEntity> dataTransaksi(){
        return ModelObjController.transaksiModel.dataTransaksi();
    }
    
    public HashMap<String,String> notaTransaksi(int id){
        return ModelObjController.transaksiModel.notaTransaksi(id);
    }
    
    public DefaultTableModel notaTransaksiCustomer(int id){
        return ModelObjController.transaksiModel.notaTransaksiCustomer(id);
    }
    
    public DefaultTableModel listTransaksi(){
        return ModelObjController.transaksiModel.listTransaksi();
    }
    
    public int getIdTransaksi(int idcustomer){
        return ModelObjController.transaksiModel.idTransaksi(idcustomer);
    }
    
    public int ubahTotalHarga(int harga, int id){
        return ModelObjController.transaksiModel.ubahTotalHarga(harga, id);
    }
}
