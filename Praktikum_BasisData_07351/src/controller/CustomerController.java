package controller;

import entity.CustomerEntity;
import java.util.ArrayList;

public class CustomerController {
    
    public int insertDataCustomer(CustomerEntity customer){
        return ModelObjController.customerModel.insertDataCustomer(customer);
    }
    
    public CustomerEntity dataSatuCustomer(int id){
        return ModelObjController.customerModel.dataSatuCustomer(id);
    }
    
    public ArrayList<CustomerEntity> dataCustomer(){
        return ModelObjController.customerModel.dataCustomer();
    }
}
