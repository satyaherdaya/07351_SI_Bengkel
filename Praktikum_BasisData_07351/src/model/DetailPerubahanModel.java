package model;

import entity.DetailPerubahanEntity;
import helper.KoneksiDB;
import java.sql.*;

public class DetailPerubahanModel {
    private Connection con = KoneksiDB.dbConnection();
    private String sql;
    
    public int insertDetailPerubahan(DetailPerubahanEntity rubah){
        try{
            sql = "insert into detail_perubahan values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, rubah.getKategori());
            ps.setString(2, rubah.getDataSebelum());
            ps.setString(3, rubah.getDataSesudah());
            ps.setInt(4, rubah.getProduk().getIdProduk());
            ps.setInt(5, rubah.getPegawai().getIdPegawai());
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
}
