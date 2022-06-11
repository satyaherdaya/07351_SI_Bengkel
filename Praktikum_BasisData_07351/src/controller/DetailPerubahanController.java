package controller;

import entity.DetailPerubahanEntity;

public class DetailPerubahanController{
    
    public int insertDataPerubahan(DetailPerubahanEntity rubah){
        return ModelObjController.detailPrbModel.insertDetailPerubahan(rubah);
    }
}
