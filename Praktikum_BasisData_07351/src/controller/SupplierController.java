package controller;

import entity.SupplierEntity;
import java.util.ArrayList;

public class SupplierController {
    
    public int insertDataSupplier(SupplierEntity supplier){
        return ModelObjController.supplierModel.insertDataSupplier(supplier);
    }
    
    public SupplierEntity satuDataSupplier(int id){
        return ModelObjController.supplierModel.dataSatuSupplier(id);
    }
    
    public ArrayList<SupplierEntity> dataSupplier(){
        return ModelObjController.supplierModel.dataSupplier();
    }
    
    public int ubahAlamatSupplier(String alamat,int id){
        return ModelObjController.supplierModel.ubahAlamatSupplier(alamat, id);
    }
    
    public int ubahNotelpSupplier(String notelp,int id){
        return ModelObjController.supplierModel.ubahNotelpSupplier(notelp, id);
    }
    
    public int ubahNamaSupplier(String nama,int id){
        return ModelObjController.supplierModel.ubahNamaSupplier(nama, id);
    }
    
    public int hapusDataSupplier(int id){
        return ModelObjController.supplierModel.hapusSatuDataSupplier(id);
    }
}
