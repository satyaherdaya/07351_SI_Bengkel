package model;

import java.sql.*;
import java.util.ArrayList;
import helper.KoneksiDB;
import entity.TransaksiEntity;
import java.util.HashMap;
import javax.swing.table.DefaultTableModel;

public class TransaksiModel {
    private Connection con = KoneksiDB.dbConnection();
    private String sql;
    private CustomerModel customer = new CustomerModel();
    private KasirModel kasir = new KasirModel();
     
    public TransaksiEntity dataSatuTransaksi(int id){
        try{
            sql = "select * from transaksi where id_transaksi = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                TransaksiEntity data = new TransaksiEntity(rs.getInt("id_transaksi"),rs.getTimestamp("tgl_transaksi"),rs.getInt("total_harga"),customer.dataSatuCustomer(rs.getInt("customerID")),kasir.dataSatuKasir(rs.getInt("kasirID")));
                return data;
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return null;
    }
    
    public ArrayList<TransaksiEntity> dataTransaksi(){
        ArrayList<TransaksiEntity> data = new ArrayList<>();
        try{
            sql = "select * from transaksi";
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                data.add(new TransaksiEntity(rs.getInt("id_transaksi"),rs.getTimestamp("tgl_transaksi"),rs.getInt("total_harga"),customer.dataSatuCustomer(rs.getInt("customerID")),kasir.dataSatuKasir(rs.getInt("kasirID"))));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return data;
    }
    
    public int insertDataTransaksi(TransaksiEntity trx){
        try{
            sql = "insert into transaksi(total_harga,CustomerID,KasirID) values(?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, trx.getTotalHarga());
            ps.setInt(2, trx.getCustomer().getIdCustomer());
            ps.setInt(3, trx.getKasir().getIdPegawai());
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int idTransaksi(int idcustomer){
        ArrayList<Integer> id = new ArrayList<>();
        int idtrx = 0;
        try{
            sql = "select id_transaksi from transaksi where customerID=?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idcustomer);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                id.add(rs.getInt("id_transaksi"));
            }
            for(Integer i : id){
                idtrx=id.indexOf(i);
                if(idtrx<i){
                    idtrx=i;
                }
            }
            return idtrx;
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int insertDataTransaksitimestamp(TransaksiEntity trx){
        try{
            sql = "insert into transaksi values(null,?,?,?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setTimestamp(1, trx.getTglTransaksi());
            ps.setInt(2, trx.getTotalHarga());
            ps.setInt(3, trx.getCustomer().getIdCustomer());
            ps.setInt(2, trx.getKasir().getIdPegawai());
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int ubahTotalHarga(int harga, int id){
        try{
            sql = "update transaksi set total_harga = ? where id_transaksi = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, harga);
            ps.setInt(2, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public int hapusSatuDataTransaksi(int id){
        try{
            sql = "delete from transaksi where id_transaksi = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            return ps.executeUpdate();
        }catch(SQLException e){
            System.out.println(e);
            return -1;
        }
    }
    
    public HashMap<String,String> notaTransaksi(int id){
        HashMap<String,String> trx = new HashMap();
        try{
            sql = "select transaksi.id_transaksi as no_transaksi,transaksi.tgl_transaksi,customer.nama_customer,produk.deskripsi_produk,produk.harga_produk,detail_transaksi.jumlah_produk,detail_transaksi.jumlah_harga,transaksi.total_harga,kasir.nama_kasir from transaksi inner join detail_transaksi on(transaksi.id_transaksi=detail_transaksi.transaksiID) inner join produk on(detail_transaksi.produkID=produk.id_produk) inner join customer on(customer.id_customer=transaksi.customerID) inner join kasir on(kasir.id_kasir=transaksi.kasirID) where detail_transaksi.transaksiID like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                trx.put("no_transaksi", String.valueOf(rs.getInt("no_transaksi")));
                trx.put("tgl_transaksi", String.valueOf(rs.getTimestamp("tgl_transaksi")));
                trx.put("nama_customer", rs.getString("nama_customer"));
                trx.put("deskripsi_produk", rs.getString("deskripsi_produk"));
                trx.put("harga_produk", String.valueOf(rs.getInt("harga_produk")));
                trx.put("jumlah_produk", String.valueOf(rs.getInt("jumlah_produk")));
                trx.put("jumlah_harga", String.valueOf(rs.getInt("jumlah_harga")));
                trx.put("total_harga", String.valueOf(rs.getInt("total_harga")));
                trx.put("nama_kasir", rs.getString("nama_kasir"));
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return trx;
    }
    
    public HashMap<String,ArrayList<String>> notaTransaksiBanyakPorduct(int id){
        HashMap<String,ArrayList<String>> trx = new HashMap();
        ArrayList<String> data1 = new ArrayList<>();
        ArrayList<String> data2 = new ArrayList<>();
        ArrayList<String> data3 = new ArrayList<>();
        ArrayList<String> data4 = new ArrayList<>();
        ArrayList<String> data5 = new ArrayList<>();
        ArrayList<String> data6 = new ArrayList<>();
        ArrayList<String> data7 = new ArrayList<>();
        ArrayList<String> data8 = new ArrayList<>();
        ArrayList<String> data9 = new ArrayList<>();
        try{
            sql = "select transaksi.id_transaksi as no_transaksi,transaksi.tgl_transaksi,customer.nama_customer,produk.deskripsi_produk,produk.harga_produk,detail_transaksi.jumlah_produk,detail_transaksi.jumlah_harga,transaksi.total_harga,kasir.nama_kasir from transaksi inner join detail_transaksi on(transaksi.id_transaksi=detail_transaksi.transaksiID) inner join produk on(detail_transaksi.produkID=produk.id_produk) inner join customer on(customer.id_customer=transaksi.customerID) inner join kasir on(kasir.id_kasir=transaksi.kasirID) where detail_transaksi.transaksiID like ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                data1.add(String.valueOf(rs.getInt("no_transaksi")));
                data2.add(String.valueOf(rs.getTimestamp("tgl_transaksi")));
                data3.add(rs.getString("nama_customer"));
                data4.add(rs.getString("deskripsi_produk"));
                data5.add(String.valueOf(rs.getInt("harga_produk")));
                data6.add(String.valueOf(rs.getInt("jumlah_produk")));
                data7.add(String.valueOf(rs.getInt("jumlah_harga")));
                data8.add(String.valueOf(rs.getInt("total_harga")));
                data9.add(rs.getString("nama_kasir"));
                
                trx.put("no_transaksi", data1);
                trx.put("tgl_transaksi", data2);
                trx.put("nama_customer", data3);
                trx.put("deskripsi_produk", data4);
                trx.put("harga_produk", data5);
                trx.put("jumlah_produk", data6);
                trx.put("jumlah_harga", data7);
                trx.put("total_harga", data8);
                trx.put("nama_kasir", data9);
            }
        }catch(SQLException e){
            System.out.println(e);
        }
        return trx;
    }
    
    public DefaultTableModel listTransaksi(){
        DefaultTableModel listDataTransaksi = new DefaultTableModel();
        Object[] kolom = {"ID TRANSAKSI","TANGGAL TRANSAKSI","TOTAL HARGA","NAMA CUSTOMER","NAMA KASIR"};
        listDataTransaksi.setColumnIdentifiers(kolom);
        
        int size = dataTransaksi().size();
        for(int i = 0;i<size;i++){
            Object[] data = new Object[5];
            data[0] = dataTransaksi().get(i).getIdTransaksi();
            data[1] = dataTransaksi().get(i).getTglTransaksi();
            data[2] = dataTransaksi().get(i).getTotalHarga();
            data[3] = dataTransaksi().get(i).getCustomer().getNamaCustomer();
            data[4] = dataTransaksi().get(i).getKasir().getNamaPegawai();
            listDataTransaksi.addRow(data);
        }
        return listDataTransaksi;
    }
    
    public DefaultTableModel notaTransaksiCustomer(int id){
        DefaultTableModel notaTransaksiCustomer = new DefaultTableModel();
        Object[] kolom = {"DESKRIPSI PRODUK","HARGA PRODUK","JUMLAH PRODUK","JUMLAH HARGA"};
        notaTransaksiCustomer.setColumnIdentifiers(kolom);
        
        int size = notaTransaksi(id).size();
        for(int i = 0;i<size/9;i++){
            Object[] data = new Object[4];
            data[0] = notaTransaksi(id).get("deskripsi_produk");
            data[1] = notaTransaksi(id).get("harga_produk");
            data[2] = notaTransaksi(id).get("jumlah_produk");
            data[3] = notaTransaksi(id).get("jumlah_harga");
            notaTransaksiCustomer.addRow(data);
        }
        return notaTransaksiCustomer;
    }
    
    public DefaultTableModel notaTransaksiCustomer2(int id){
        DefaultTableModel notaTransaksiCustomer = new DefaultTableModel();
        Object[] kolom = {"DESKRIPSI PRODUK","HARGA PRODUK","JUMLAH PRODUK","JUMLAH HARGA"};
        notaTransaksiCustomer.setColumnIdentifiers(kolom);
        
        int size = notaTransaksiBanyakPorduct(id).size()*notaTransaksiBanyakPorduct(id).get("deskripsi_produk").size();
        for(int i = 0;i<size/9;i++){
            Object[] data = new Object[4];
            data[0] = notaTransaksiBanyakPorduct(id).get("deskripsi_produk").get(i);
            data[1] = notaTransaksiBanyakPorduct(id).get("harga_produk").get(i);
            data[2] = notaTransaksiBanyakPorduct(id).get("jumlah_produk").get(i);
            data[3] = notaTransaksiBanyakPorduct(id).get("jumlah_harga").get(i);
            notaTransaksiCustomer.addRow(data);
        }
        return notaTransaksiCustomer;
    }
}
