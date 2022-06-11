package controller;

import entity.DetailTransaksiEntity;

public class DetailTransaksiController {
    public int insertDataTransaksi(DetailTransaksiEntity detailTrx){
        return ModelObjController.detailTrxModel.insertDetailTransaksi(detailTrx);
    }
}
