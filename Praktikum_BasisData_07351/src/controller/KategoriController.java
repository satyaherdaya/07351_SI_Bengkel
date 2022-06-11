package controller;

import entity.KategoriEntity;
import java.util.ArrayList;

public class KategoriController {
    public ArrayList<KategoriEntity> dataKategori(){
        return ModelObjController.kategoriModel.dataKategori();
    }
    
    public KategoriEntity dataKategori(int id){
        return ModelObjController.kategoriModel.satuDataKategori(id);
    }
    
    public int insertKategori(KategoriEntity kategori){
        return ModelObjController.kategoriModel.insertDataKategori(kategori);
    }
}
