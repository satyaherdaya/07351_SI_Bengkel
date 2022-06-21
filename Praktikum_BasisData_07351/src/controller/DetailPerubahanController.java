package controller;

import entity.DetailPerubahanEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class DetailPerubahanController{
    
    public int insertDataPerubahan(DetailPerubahanEntity rubah){
        return ModelObjController.detailPrbModel.insertDetailPerubahan(rubah);
    }
    
    public ArrayList<DetailPerubahanEntity> dataDetailPerubahan(){
        return ModelObjController.detailPrbModel.dataDetailPerubahan();
    }
    
    public DefaultTableModel listDetailPerubahan(){
        return ModelObjController.detailPrbModel.listProduk();
    }
}
