package gui;

import entity.CustomerEntity;
import entity.TransaksiEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class TambahCustomer extends JFrame{
    JButton btnadduser = new JButton("Tambah Customer");
    JButton btnback = new JButton("<<back");
    JLabel labeljudul = new JLabel("Tambah Customer");
    JLabel labelnama = new JLabel("Nama");
    JLabel labelnotelp = new JLabel("NoTelp");
    JTextField tfnama = new JTextField();
    JTextField tfnotelp = new JTextField();

    public TambahCustomer(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("Tambah Customer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(320,350);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labeljudul.setBounds(120, 50, 130, 25);
        add(labeljudul);
        
        labelnama.setBounds(30, 100, 80, 25);
        add(labelnama);
        tfnama.setBounds(130, 100, 130, 25);
        add(tfnama);
        
        labelnotelp.setBounds(30, 150, 80, 25);
        add(labelnotelp);
        tfnotelp.setBounds(130, 150, 130, 25);
        add(tfnotelp);
        
        btnadduser.setBounds(150, 250, 140, 25);
        btnadduser.setBackground(Color.black);
        btnadduser.setForeground(Color.white);
        btnadduser.setCursor(new Cursor(12));
        add(btnadduser);
        
        btnback.setBounds(30, 50, 70, 25);
        btnback.setBorder(null);
        btnback.setCursor(new Cursor(12));
        btnback.setBackground(Color.white);
        btnback.setForeground(Color.black);
        add(btnback);
        
        btnadduser.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnadduser.setForeground(Color.blue);
                btnadduser.setBackground(Color.white);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnadduser.setForeground(Color.white);
                btnadduser.setBackground(Color.black);
            }
        });
        
        btnadduser.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = tfnama.getText();
                String noTelp = tfnotelp.getText();
                
                if(nama.length()!=0 && noTelp.length()!=0){
                    ControllerObject.customerController.insertDataCustomer(new CustomerEntity(nama,noTelp));
                    JOptionPane.showMessageDialog(null, "Customer Berhasil Ditambahkan");
                    int idcustomer = ControllerObject.customerController.getIdCustomer(nama);
                    int idkasir = cek;
                    ControllerObject.transaksiController.insertDataTransaksi(new TransaksiEntity(0,ControllerObject.customerController.dataSatuCustomer(idcustomer),ControllerObject.kasirController.satuDataKasir(idkasir)));
                    int idtransaksi = ControllerObject.transaksiController.getIdTransaksi(idcustomer);
                    new RincianTransaksi(cek,idcustomer,idkasir,idtransaksi).setVisible(true);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null, "Customer Gagal Ditambahkan");
                    kosong();
                }
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
        tfnama.setText(null);
        tfnotelp.setText(null);
    }
}
