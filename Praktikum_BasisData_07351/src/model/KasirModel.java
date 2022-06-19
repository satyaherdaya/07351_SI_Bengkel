package model;

import entity.KasirEntity;
import helper.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class KasirModel {
    private Connection con = KoneksiDB.dbConnection();
    private String sql;
    
    public ArrayList<KasirEntity> dataKasir(){
        ArrayList<KasirEntity> data = new ArrayList();
        try{
            sql = "select * from kasir";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                data.add(new KasirEntity(rs.getInt("id_kasir"),rs.getString("nama_kasir"),rs.getString("notelp_kasir"),rs.getString("alamat_kasir"),rs.getString("username"),rs.getString("password")));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    public KasirEntity dataSatuKasir(int id){
        try{
            sql = "select * from kasir where id_kasir = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                KasirEntity data = new KasirEntity(rs.getInt("id_kasir"),rs.getString("nama_kasir"),rs.getString("notelp_kasir"),rs.getString("alamat_kasir"),rs.getString("username"),rs.getString("password"));
                return data;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public int insertDataKasir(KasirEntity kasir){
        try{
            sql = "insert into kasir values(null,?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, kasir.getNamaPegawai());
            ps.setString(2, kasir.getNotelpPegawai());
            ps.setString(3, kasir.getAlamatPegawai());
            ps.setString(4, kasir.getUsername());
            ps.setString(5, kasir.getPassword());
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int loginKasir(String username,String password){
        int cek=0;
        try{
            sql = "select * from kasir where username=? and password=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                cek = rs.getInt("id_kasir");
            }
            return cek;
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int ubahNamaKasir(String nama, int id){
        try{
            sql = "update kasir set nama_kasir = ? where id_kasir = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nama);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int ubahNotelpKasir(String notelp, int id){
        try{
            sql = "update kasir set notelp_kasir = ? where id_kasir = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, notelp);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int ubahAlamatKasir(String alamat, int id){
        try{
            sql = "update kasir set alamat_kasir = ? where id_kasir = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, alamat);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int updateUsernameKasir(String username, int id){
        try{
            sql = "update kasir set username=? where id_kasir=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int updatePasswordKasir(String password, int id){
        try{
            sql = "update kasir set password=? where id_kasir=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, password);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int hapusSatuDataKasir(int id){
        try{
            sql = "delete from kasir where id_kasir = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public DefaultTableModel viewKasir(){
        DefaultTableModel notaTransaksiCustomer = new DefaultTableModel();
        Object[] kolom = {"ID KASIR","NAMA KASIR"};
        notaTransaksiCustomer.setColumnIdentifiers(kolom);
        
        int size = dataKasir().size();
        for(int i = 0;i<size;i++){
            Object[] data = new Object[2];
            data[0] = dataKasir().get(i).getIdPegawai();
            data[1] = dataKasir().get(i).getNamaPegawai();
            notaTransaksiCustomer.addRow(data);
        }
        return notaTransaksiCustomer;
    }
}
