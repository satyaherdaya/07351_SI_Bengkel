package controller;

import entity.DetailTransaksiEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DetailTransaksiController {
    public int insertDataTransaksi(DetailTransaksiEntity detailTrx){
        return ModelObjController.detailTrxModel.insertDetailTransaksi(detailTrx);
    }
    
    public ArrayList<DetailTransaksiEntity> dataDetailTansasiByIdtrx(int idTransaksi){
        return ModelObjController.detailTrxModel.dataDetailTansasiByIdtrx(idTransaksi);
    }
    
    public DefaultTableModel listProdukDibeli(int idtransaksi){
        return ModelObjController.detailTrxModel.listProdukDibeli(idtransaksi);
    }
}
