package model;

import java.sql.*;
import java.util.ArrayList;
import helper.KoneksiDB;
import entity.KategoriEntity;

public class KategoriModel {
    private Connection con = KoneksiDB.dbConnection();
    private String sql;
    
    public ArrayList<KategoriEntity> dataKategori(){
        ArrayList<KategoriEntity> data = new ArrayList();
        try{
            sql = "select * from kategori";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                data.add(new KategoriEntity(rs.getInt("id_kategori"),rs.getString("nama_kategori")));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    public KategoriEntity satuDataKategori(int id){
        try{
            sql = "select * from kategori where id_kategori=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KategoriEntity data= new KategoriEntity(rs.getInt("id_kategori"),rs.getString("nama_kategori"));
                return data;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public int insertDataKategori(KategoriEntity kategori){
        try{
            sql = "insert into kategori values(?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, kategori.getIdKategori());
            ps.setString(2, kategori.getNamaKategori());
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int updateNamaKategori(String nama, int id){
        try{
            sql = "update kategori set nama_kategori = ? where id_kategori = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int deleteSatuKategori(int id){
        try{
            sql = "delete from kategori where id_kategori=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
}
