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
    JButton btnpilih = new JButton("Pilih Kasir");
    JTable tabelKasir = new JTable();
    JScrollPane sptrx = new JScrollPane(tabelKasir);
    JTextField textpilih = new JTextField();
    JTextField textpilih2 = new JTextField();
    
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
        tabelKasir.setModel(ControllerObject.produkController.listProduk());
        tabelKasir.setDefaultEditor(Object.class, null);
        add(sptrx);
        
        btnpilih.setBounds(650, 50, 120, 25);
        btnpilih.setCursor(new Cursor(12));
        btnpilih.setBackground(Color.black);
        btnpilih.setForeground(Color.white);
        add(btnpilih);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setCursor(new Cursor(12));
        btnback.setBorder(null);
        add(btnback);
        
        tabelKasir.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelKasir.getSelectedRow();
                textpilih.setText(ControllerObject.produkController.listProduk().getValueAt(i, 0).toString());
                textpilih2.setText(ControllerObject.produkController.listProduk().getValueAt(i, 2).toString());
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
                new RincianTransaksi(cek,idcustomer,idkasir,idtransaksi).setVisible(true);
                dispose();
            }
        });
    }
}
