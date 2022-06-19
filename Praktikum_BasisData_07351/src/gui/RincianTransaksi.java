package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class RincianTransaksi extends JFrame{
    int kode;
    JButton btntambahproduk = new JButton("Tambah Produk");
    JButton btntambahtrx = new JButton("Tambah Transaksi");
    JButton btnback = new JButton("<<back");
    JLabel labeljudul = new JLabel("Tambah Transaksi");
    JLabel labeltotalharga = new JLabel("Total Harga");
    JTextField tftotalharga = new JTextField();
    JTable tabelDetailTransaksi = new JTable();
    JScrollPane sptrx = new JScrollPane(tabelDetailTransaksi);
    JTextField textpilih = new JTextField();
    
    public RincianTransaksi(int cek,int idcustomer,int idkasir,int idtransaksi) {
        initComponent(cek, idcustomer, idkasir, idtransaksi);
    }
        
    void initComponent(int cek,int idcustomer,int idkasir,int idtransaksi){
        setTitle("RINCIAN TRANSAKSI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(850,550);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        sptrx.setBounds(20, 50, 600, 350);
        tabelDetailTransaksi.setModel(ControllerObject.detTrxController.listProdukDibeli(idtransaksi));
        tabelDetailTransaksi.setDefaultEditor(Object.class, null);
        add(sptrx);
        
        labeljudul.setBounds(120, 50, 130, 25);
        add(labeljudul);
        
        labeltotalharga.setBounds(30, 420, 80, 25);
        add(labeltotalharga);
        tftotalharga.setBounds(120, 420, 130, 25);
        add(tftotalharga);
        
        btntambahproduk.setBounds(650, 50, 140, 25);
        btntambahproduk.setBackground(Color.black);
        btntambahproduk.setForeground(Color.white);
        btntambahproduk.setCursor(new Cursor(12));
        add(btntambahproduk);
        
        btntambahtrx.setBounds(650, 420, 140, 25);
        btntambahtrx.setBackground(Color.black);
        btntambahtrx.setForeground(Color.white);
        btntambahtrx.setCursor(new Cursor(12));
        add(btntambahtrx);
        
        btnback.setBounds(20, 20, 70, 25);
        btnback.setBorder(null);
        btnback.setCursor(new Cursor(12));
        btnback.setBackground(Color.white);
        btnback.setForeground(Color.black);
        add(btnback);
        
        tabelDetailTransaksi.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelDetailTransaksi.getSelectedRow();
                textpilih.setText(ControllerObject.detTrxController.listProdukDibeli(idtransaksi).getValueAt(i, 0).toString());
            }
        });
        
        btntambahproduk.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btntambahproduk.setForeground(Color.blue);
                btntambahproduk.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btntambahproduk.setForeground(Color.white);
                btntambahproduk.setBackground(Color.black);
            }
        });
        
        btntambahproduk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new PilihProduk(cek,idcustomer,idkasir,idtransaksi).setVisible(true);
                dispose();
            }
        });
        
        btntambahtrx.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btntambahtrx.setForeground(Color.blue);
                btntambahtrx.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btntambahtrx.setForeground(Color.white);
                btntambahtrx.setBackground(Color.black);
            }
        });
        
        btntambahtrx.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                int totalHarga = Integer.parseInt(tftotalharga.getText());
                ControllerObject.transaksiController.ubahTotalHarga(totalHarga, idtransaksi);
                if(ControllerObject.transaksiController.ubahTotalHarga(totalHarga, idtransaksi)>0){
                    JOptionPane.showMessageDialog(null, "transaksi berhasil ditambahkan");
                    new MenuKasir(cek).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "terjadi kesalahan");
                }
                dispose();
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
                new MenuTambahCustomer(cek).setVisible(true);
                dispose();
            }
        });
    }
    
    void kosong(){
        tftotalharga.setText(null);
    }
}
