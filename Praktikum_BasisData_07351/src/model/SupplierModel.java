package model;

import entity.SupplierEntity;
import helper.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;

public class SupplierModel {
    private Connection con = KoneksiDB.dbConnection();
    private String sql;
    
    public ArrayList<SupplierEntity> dataSupplier(){
        ArrayList<SupplierEntity> data = new ArrayList();
        try{
            sql = "select * from supplier";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                data.add(new SupplierEntity(rs.getInt("id_supplier"),rs.getString("nama_supplier"),rs.getString("notelp_supplier"),rs.getString("alamat_supplier")));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    public SupplierEntity dataSatuSupplier(int id){
        try{
            sql = "select * from supplier where id_supplier = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                SupplierEntity data = new SupplierEntity(rs.getInt("id_supplier"),rs.getString("nama_supplier"),rs.getString("notelp_supplier"),rs.getString("alamat_supplier"));
                return data;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public int insertDataSupplier(SupplierEntity supplier){
        try{
            sql = "insert into supplier values(null,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, supplier.getNamaSupplier());
            ps.setString(2, supplier.getNotelpSupplier());
            ps.setString(3, supplier.getAlamatSupplier());
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int ubahNamaSupplier(String nama, int id){
        try{
            sql = "update kasir set nama_supplier = ? where id_supplier = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int ubahNotelpSupplier(String notelp, int id){
        try{
            sql = "update kasir set notelp_supplier = ? where id_supplier = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, notelp);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int ubahAlamatSupplier(String alamat, int id){
        try{
            sql = "update kasir set alamat_supplier = ? where id_supplier = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, alamat);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int hapusSatuDataSupplier(int id){
        try{
            sql = "delete from supplier where id_supplier = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
}
