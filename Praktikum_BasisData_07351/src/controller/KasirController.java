package controller;

import entity.KasirEntity;
import java.util.ArrayList;

public class KasirController {
    
    public int insertDataKasir(KasirEntity kasir){
        return ModelObjController.kasirModel.insertDataKasir(kasir);
    }
    
    public int loginKasir(String username,String password){
        return ModelObjController.kasirModel.loginKasir(username, password);
    }
    
    public KasirEntity satuDataKasir(int id){
        return ModelObjController.kasirModel.dataSatuKasir(id);
    }
    
    public ArrayList<KasirEntity> dataKasir(){
        return ModelObjController.kasirModel.dataKasir();
    }
    
    public int ubahAlamatKasir(String alamat,int id){
        return ModelObjController.kasirModel.ubahAlamatKasir(alamat, id);
    }
    
    public int ubahNoTelpKasir(String noTelp,int id){
        return ModelObjController.kasirModel.ubahNotelpKasir(noTelp, id);
    }
    
    public int ubahPasswordKasir(String password,int id){
        return ModelObjController.kasirModel.ubahNotelpKasir(password, id);
    }
    
    public int hapusDataKasir(int id){
        return ModelObjController.kasirModel.hapusSatuDataKasir(id);
    }
}
