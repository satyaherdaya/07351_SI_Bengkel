package model;

import entity.DetailPerubahanEntity;
import helper.KoneksiDB;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DetailPerubahanModel {
    private Connection con = KoneksiDB.dbConnection();
    private String sql;
    private ProdukModel produk = new ProdukModel();
    private AdminModel admin = new AdminModel();
    
    public int insertDetailPerubahan(DetailPerubahanEntity rubah){
        try{
            sql = "insert into detail_perubahan values(?,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, rubah.getKategori());
            ps.setString(2, rubah.getDataSebelum());
            ps.setString(3, rubah.getDataSesudah());
            ps.setInt(4, rubah.getProduk().getIdProduk());
            ps.setInt(5, rubah.getPegawai().getIdAdmin());
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public ArrayList<DetailPerubahanEntity> dataDetailPerubahan(){
        ArrayList<DetailPerubahanEntity> data = new ArrayList<>();
        try{
            sql = "select * from detail_perubahan";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                data.add(new DetailPerubahanEntity(rs.getString("keterangan"),rs.getString("data_Sebelum"),rs.getString("data_sesudah"),produk.dataSatuProduk(rs.getInt("produk_id")),admin.dataSatuAdmin(rs.getInt("admin_id"))));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    public DefaultTableModel listProduk(){
        DefaultTableModel listDataTransaksi = new DefaultTableModel();
        Object[] kolom = {"KETERANGAN","DATA SEBELUM","DATA SESUDAH","DESKRIPSI PRODUK","NAMA PERUBAH"};
        listDataTransaksi.setColumnIdentifiers(kolom);
        
        int size = dataDetailPerubahan().size();
        for(int i = 0;i<size;i++){
            Object[] data = new Object[5];
            data[0] = dataDetailPerubahan().get(i).getKategori();
            data[1] = dataDetailPerubahan().get(i).getDataSebelum();
            data[2] = dataDetailPerubahan().get(i).getDataSesudah();
            data[3] = dataDetailPerubahan().get(i).getProduk().getDeskripsiProduk();
            data[4] = dataDetailPerubahan().get(i).getPegawai().getNamaAdmin();
            listDataTransaksi.addRow(data);
        }
        return listDataTransaksi;
    }
}
