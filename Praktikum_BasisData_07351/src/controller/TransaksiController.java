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
    
    public HashMap<String,String> notaTransaksiCustomer(int id){
        return ModelObjController.transaksiModel.notaTransaksi(id);
    }
    
    public DefaultTableModel listTransaksi(){
        return ModelObjController.transaksiModel.listTransaksi();
    }
}
