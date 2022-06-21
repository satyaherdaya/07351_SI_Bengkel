package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.HashMap;

public class ViewNota extends JFrame{
    private int kode;
    JButton btnback = new JButton("<<Back");
    JButton btnpilih = new JButton("Pilih Kasir");
    JTable tabelKasir = new JTable();
    JScrollPane sptrx = new JScrollPane(tabelKasir);
    JTextField textpilih = new JTextField();
    
    JLabel labeljudul = new JLabel("Nota SI Bengkel");
    JLabel labelid = new JLabel("No Transaksi");
    JLabel labelnamacustomer = new JLabel("Nama Customer");
    JLabel labeltgltrx = new JLabel("Tanggal Transaksi");
    JLabel labelnamakasir = new JLabel("Nama Kasir");
    JLabel labeltotalharga = new JLabel("Total Harga");
    JTextField tfid = new JTextField();
    JTextField tfnamacustomer = new JTextField();
    JTextField tftgltrx = new JTextField();
    JTextField tfnamakasir = new JTextField();
    JTextField tftotalharga = new JTextField();

    
    public ViewNota(int cek, int id) {
        initComponent(cek, id);
    }
    
    void initComponent(int cek,int idtrx){
        setTitle("VIEW CUSTOMER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700,700);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        HashMap<String,String> tx = ControllerObject.transaksiController.notaTransaksi(idtrx);
        
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
//        }
        
        labeljudul.setBounds(300, 30, 200, 100);
        labeljudul.setFont(new Font(null,1,20));
        add(labeljudul);
        
        labelid.setBounds(30,120,150,25);
        add(labelid);
        tfid.setBounds(180,120,200,25);
        tfid.setText(tx.get("no_transaksi"));
        tfid.setEditable(false);
        add(tfid);
        
        labelnamacustomer.setBounds(30,170,150,25);
        add(labelnamacustomer);
        tfnamacustomer.setBounds(180,170,200,25);
        tfnamacustomer.setText(tx.get("nama_customer"));
        tfnamacustomer.setEditable(false);
        add(tfnamacustomer);
        
        labeltgltrx.setBounds(30,220,150,25);
        add(labeltgltrx);
        tftgltrx.setBounds(180,220,200,25);
        tftgltrx.setText(tx.get("tgl_transaksi"));
        tftgltrx.setEditable(false);
        add(tftgltrx);
        
        sptrx.setBounds(30, 270, 600, 150);
        tabelKasir.setModel(ControllerObject.transaksiController.notaTransaksiCustomer2(idtrx));
        tabelKasir.setDefaultEditor(Object.class, null);
        add(sptrx);
        
        labeltotalharga.setBounds(30,440,150,25);
        add(labeltotalharga);
        tftotalharga.setBounds(180,440,200,25);
        tftotalharga.setText(tx.get("total_harga"));
        tftotalharga.setEditable(false);
        add(tftotalharga);
        
        labelnamakasir.setBounds(30,490,150,25);
        add(labelnamakasir);
        tfnamakasir.setBounds(180,490,200,25);
        tfnamakasir.setText(tx.get("nama_kasir"));
        tfnamakasir.setEditable(false);
        add(tfnamakasir);
        
        btnback.setBounds(30, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setCursor(new Cursor(12));
        btnback.setBorder(null);
        add(btnback);
        
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
                new MenuKasir(cek).setVisible(true);
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
    }
}
