package praktikum_basisdata_07351;
import helper.KoneksiDB;
import java.util.HashMap;
import model.TransaksiModel;
import gui.LoginKasir;

public class Praktikum_BasisData_07351 {
//    static KoneksiDB con = new KoneksiDB();
//    static TransaksiModel trx = new TransaksiModel();
    public static void main(String[] args) {
//        HashMap<String,String> tx = trx.notaTransaksi(1);
//        
//        for(int i=0;i<(tx.size()/9);i++){
//            System.out.println("nomor transaksi   : "+tx.get("no_transaksi"));
//            System.out.println("tanggal transaksi : "+tx.get("tgl_transaksi"));
//            System.out.println("nama customer     : "+tx.get("nama_customer"));
//            System.out.println("deskripsi produk  : "+tx.get("deskripsi_produk"));
//            System.out.println("harga satuan      : "+tx.get("harga_produk"));
//            System.out.println("jumlah produk     : "+tx.get("jumlah_produk"));
//            System.out.println("jumlah harga      : "+tx.get("jumlah_harga"));
//            System.out.println("total harga       : "+tx.get("total_harga"));
//            System.out.println("nama kasir        : "+tx.get("nama_kasir"));
//            
//        }
        new LoginKasir().setVisible(true);
    }
    
}
