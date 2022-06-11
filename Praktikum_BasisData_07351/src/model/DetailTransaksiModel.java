package model;

import helper.KoneksiDB;
import java.sql.*;
import entity.DetailTransaksiEntity;
import java.util.ArrayList;

public class DetailTransaksiModel {
    private Connection con = KoneksiDB.dbConnection();
    private String sql;
    
    public int insertDetailTransaksi(DetailTransaksiEntity detailTrx){
        try{
            sql = "insert into detail_transaksi values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, detailTrx.getJumlahProduk());
            ps.setInt(2, detailTrx.getJumlahHarga());
            ps.setInt(3, detailTrx.getProduk().getIdProduk());
            ps.setInt(4, detailTrx.getTransaksi().getIdTransaksi());
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
}
