package model;

import helper.KoneksiDB;
import java.sql.*;
import entity.DetailTransaksiEntity;
import java.util.ArrayList;
import javax.swing.table.DefaultTableModel;

public class DetailTransaksiModel {
    private Connection con = KoneksiDB.dbConnection();
    private String sql;
    ProdukModel produk = new ProdukModel();
    TransaksiModel transaksi = new TransaksiModel();
    
    public int insertDetailTransaksi(DetailTransaksiEntity detailTrx){
        try{
            sql = "insert into detail_transaksi values(?,?,?,?)";
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
    
    public ArrayList<DetailTransaksiEntity> dataDetailTansasiByIdtrx(int id){
        ArrayList<DetailTransaksiEntity> data = new ArrayList<>();
        try{
            sql="select * from detail_transaksi where transaksiID like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                data.add(new DetailTransaksiEntity(rs.getInt("jumlah_produk"),rs.getInt("jumlah_harga"),produk.dataSatuProduk(rs.getInt("produkID")),transaksi.dataSatuTransaksi(rs.getInt("transaksiID"))));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    public DefaultTableModel listProdukDibeli(int id){
        DefaultTableModel listDataTransaksi = new DefaultTableModel();
        Object[] kolom = {"ID PRODUK","JUMLAH BARANG","JUMLAH HARGA"};
        listDataTransaksi.setColumnIdentifiers(kolom);
        
        int size = dataDetailTansasiByIdtrx(id).size();
        for(int i = 0;i<size;i++){
            Object[] data = new Object[3];
            data[0] = dataDetailTansasiByIdtrx(id).get(i).getProduk().getIdProduk();
            data[1] = dataDetailTansasiByIdtrx(id).get(i).getJumlahProduk();
            data[2] = dataDetailTansasiByIdtrx(id).get(i).getJumlahHarga();
            listDataTransaksi.addRow(data);
        }
        return listDataTransaksi;
    }
}
