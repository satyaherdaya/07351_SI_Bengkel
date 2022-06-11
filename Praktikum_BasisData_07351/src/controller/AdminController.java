package controller;

import entity.AdminEntity;

public class AdminController {
    public int loginAdmin(String username, String password){
        return ModelObjController.adminModel.loginAdmin(username, password);
    }
}
