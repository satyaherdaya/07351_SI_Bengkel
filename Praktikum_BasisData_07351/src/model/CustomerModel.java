package model;

import entity.CustomerEntity;
import java.util.ArrayList;
import java.sql.*;
import helper.KoneksiDB;

public class CustomerModel {
    private Connection con = KoneksiDB.dbConnection();
    private String sql;
    
    public CustomerEntity dataSatuCustomer(int id){
        try{
            sql = "select * from customer where id_customer = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                CustomerEntity data = new CustomerEntity(rs.getInt("id_customer"),rs.getString("nama_customer"),rs.getString("notelp_customer"));
                return data;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public ArrayList<CustomerEntity> dataCustomer(){
        ArrayList<CustomerEntity> data = new ArrayList<>();
        try{
            sql = "select * from customer";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                data.add(new CustomerEntity(rs.getInt("id_customer"),rs.getString("nama_customer"),rs.getString("notelp_customer")));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    public int insertDataCustomer(CustomerEntity customer){
        try{
            sql = "insert into customer values(null,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, customer.getNamaCustomer());
            ps.setString(2, customer.getNotelpCustomer());
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int ubahNamaCustomer(String nama, int id){
        try{
            sql = "update customer set nama_customer = ? where id_customer = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int ubaNotelpCustomer(String notelp, int id){
        try{
            sql = "update customer set notelp_customer = ? where id_customer = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, notelp);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int hapusSatuDataCustomer(int id){
        try{
            sql = "delete from customer where id_customer = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
}
