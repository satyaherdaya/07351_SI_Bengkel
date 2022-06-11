package model;

import java.sql.*;
import entity.AdminEntity;
import helper.KoneksiDB;
import java.util.ArrayList;

public class AdminModel {
    private Connection con = KoneksiDB.dbConnection();
    private String sql;
    
    public AdminEntity dataSatuAdmin(int id){
        try{
            sql = "select * from admin where id_admin=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                AdminEntity data = new AdminEntity(rs.getInt("id_admin"),rs.getString("nama_admin"),rs.getString("username"),rs.getString("password"));
                return data;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public int loginAdmin(String username,String password){
        int cek=0;
        try{
            sql = "select * from admin where username=? and password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cek = rs.getInt("id_admin");
            }
            return cek;
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public ArrayList<AdminEntity> dataAdmin(){
        ArrayList<AdminEntity> data = new ArrayList();
        try{
            sql = "select * from admin";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                data.add(new AdminEntity(rs.getInt("id_admin"),rs.getString("nama_admin"),rs.getString("username"),rs.getString("password")));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    public int insertDataAdmin(AdminEntity admin){
        try{
            sql = "insert into admin values(null,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, admin.getNamaAdmin());
            ps.setString(2, admin.getUsername());
            ps.setString(3, admin.getPasswrod());
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int updateNamaAdmin(String nama, int id){
        try{
            sql = "update admin set nama_admin=? where id_admin=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int updateUsernameAdmin(String username, int id){
        try{
            sql = "update admin set username=? where id_admin=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int updatePasswordAdmin(String password, int id){
        try{
            sql = "update admin set password=? where id_admin=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int deleteSatuAdmin(int id){
        try{
            sql = "delete from admin where id_admin = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
}
