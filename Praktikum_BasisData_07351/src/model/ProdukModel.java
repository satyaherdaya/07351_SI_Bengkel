package model;

import java.sql.*;
import java.util.ArrayList;
import helper.KoneksiDB;
import entity.ProdukEntity;

public class ProdukModel {
    private Connection con = KoneksiDB.dbConnection();
    private String sql;
    private KategoriModel kategori = new KategoriModel();
    private SupplierModel supplier = new SupplierModel();
    
    public ProdukEntity dataSatuProduk(int id){
        try{
            sql = "select * from produk where id_produk = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ProdukEntity data = new ProdukEntity(rs.getInt("id_produk"),rs.getString("deskripsi_produk"),rs.getInt("harga_produk"),rs.getInt("stok"),kategori.satuDataKategori(rs.getInt("kategoriID")),supplier.dataSatuSupplier(rs.getInt("supplierID")));
                return data;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public ArrayList<ProdukEntity> dataProduk(){
        ArrayList<ProdukEntity> data = new ArrayList<>();
        try{
            sql = "select * from produk";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                data.add(new ProdukEntity(rs.getInt("id_produk"),rs.getString("deskripsi_produk"),rs.getInt("harga_produk"),rs.getInt("stok"),kategori.satuDataKategori(rs.getInt("kategoriID")),supplier.dataSatuSupplier(rs.getInt("supplierID"))));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    public int insertDataProduk(ProdukEntity produk){
        try{
            sql = "insert into produk values(null,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, produk.getDeskripsiProduk());
            ps.setInt(2, produk.getHarga());
            ps.setInt(3, produk.getStok());
            ps.setInt(4, produk.getKategori().getIdKategori());
            ps.setInt(5, produk.getSupplier().getIdSupplier());
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int ubahDeskripsiProduk(String deskripsi, int id){
        try{
            sql = "update produk set nama_produk = ? where id_produk = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, deskripsi);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int ubahHargaProduk(int harga, int id){
        try{
            sql = "update produk set harga_produk = ? where id_produk = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, harga);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int ubahStokProduk(int stok, int id){
        try{
            sql = "update produk set stok = ? where id_produk = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, stok);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int hapusSatuDataProduk(int id){
        try{
            sql = "delete from ptoduk where id_produk = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
}