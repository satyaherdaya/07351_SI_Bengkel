package gui;

import entity.DetailTransaksiEntity;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PilihProduk extends JFrame{
    private int kode;
    JButton btnback = new JButton("<<Back");
    JButton btnrefresh = new JButton("Refresh");
    JButton btnpilih = new JButton("Pilih Produk");
    JButton btnadd2 = new JButton("Tambah jasa"); 
    JTable tabelPilihProduk = new JTable();
    JScrollPane sptrx = new JScrollPane(tabelPilihProduk);
    JTextField textpilih = new JTextField();
    JTextField textpilih2 = new JTextField();
    JTextField textpilih3 = new JTextField();
    
    public PilihProduk(int cek,int idcustomer,int idkasir,int idtransaksi) {
        initComponent(cek, idcustomer, idkasir, idtransaksi);
    }
    
    void initComponent(int cek,int idcustomer,int idkasir,int idtransaksi){
        setTitle("PILIH PRODUK");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        sptrx.setBounds(20, 50, 600, 350);
        tabelPilihProduk.setModel(ControllerObject.produkController.listProduk());
        tabelPilihProduk.setDefaultEditor(Object.class, null);
        add(sptrx);
        
        btnpilih.setBounds(650, 50, 120, 25);
        btnpilih.setCursor(new Cursor(12));
        btnpilih.setBackground(Color.black);
        btnpilih.setForeground(Color.white);
        add(btnpilih);
        
        btnadd2.setBounds(650, 90, 120, 25);
        btnadd2.setCursor(new Cursor(12));
        btnadd2.setBackground(Color.black);
        btnadd2.setForeground(Color.white);
        add(btnadd2);
        
        btnrefresh.setBounds(550, 20, 80, 25);
        btnrefresh.setBackground(Color.white);
        btnrefresh.setCursor(new Cursor(12));
        btnrefresh.setBorder(null);
        add(btnrefresh);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setCursor(new Cursor(12));
        btnback.setBorder(null);
        add(btnback);
        
        tabelPilihProduk.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelPilihProduk.getSelectedRow();
                textpilih.setText(ControllerObject.produkController.listProduk().getValueAt(i, 0).toString());
                textpilih2.setText(ControllerObject.produkController.listProduk().getValueAt(i, 2).toString());
                textpilih3.setText(ControllerObject.produkController.listProduk().getValueAt(i, 3).toString());
            }
        });
        
        btnback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnback.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnback.setForeground(Color.black);
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new PilihCustomer(cek).setVisible(true);
                dispose();
            }
        });
        
        btnrefresh.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnrefresh.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnrefresh.setForeground(Color.black);
            }
        });
        
        btnrefresh.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                tabelPilihProduk.setModel(ControllerObject.produkController.listProduk());                
            }
        });
        
        btnpilih.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnpilih.setForeground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnpilih.setForeground(Color.white);
            }
        });
        
        btnpilih.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String jmlprdk = JOptionPane.showInputDialog("masukkan jumlah produk yang dibeli : ");
                int jmlProduk = Integer.parseInt(jmlprdk);
                int jmlHarga = Integer.parseInt(textpilih2.getText()) * jmlProduk;
                kode = Integer.parseInt(textpilih.getText());
                ControllerObject.detTrxController.insertDataTransaksi(new DetailTransaksiEntity(jmlProduk,jmlHarga,ControllerObject.produkController.satuDataProduk(kode),ControllerObject.transaksiController.satuDataTransaksi(idtransaksi)));
                if(textpilih3.getText().equals("alat")){
                    ControllerObject.produkController.kurangiSatuStock(idtransaksi, kode);
                }
                new RincianTransaksi(cek,idcustomer,idkasir,idtransaksi).setVisible(true);
                dispose();
            }
        });
        
        btnadd2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnadd2.setForeground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnadd2.setForeground(Color.white);
            }
        });
        
        btnadd2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField deskripsi = new JTextField();
                JTextField harga = new JTextField();
                JTextField stok = new JTextField();
                JTextField kategori = new JTextField();
                JTextField supplier = new JTextField();
                Object[] message = {
                    "Deskripsi Produk : ", deskripsi,
                    "Harga : ", harga,
                    "id Kategori : ",kategori
                };
                int option = JOptionPane.showConfirmDialog(null,message,"Tambah Jasa",JOptionPane.OK_CANCEL_OPTION);
                if(option==JOptionPane.OK_OPTION){
                    if(ControllerObject.produkController.insertDataProdukJasa(deskripsi.getText(),Integer.parseInt(harga.getText()),ControllerObject.kategoriController.dataSatuKategori(Integer.parseInt(kategori.getText())))>0){
                        JOptionPane.showMessageDialog(null, "produk berhasil ditambahkan");
                    }else{
                        JOptionPane.showMessageDialog(null, "produk gagal ditambahkan");
                    }
                }
            }
        });
    }
}
