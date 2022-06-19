package gui;

import entity.TransaksiEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class PilihCustomer extends JFrame{
    private int kode;
    JButton btnaback = new JButton("<<Back");
    JButton btnpilih = new JButton("Pilih Customer");
    JTable tabelCustomer = new JTable();
    JScrollPane sptrx = new JScrollPane(tabelCustomer);
    JTextField textpilih = new JTextField();
    
    public PilihCustomer(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("PILIH CUSTOMER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        sptrx.setBounds(20, 50, 600, 350);
        tabelCustomer.setModel(ControllerObject.customerController.viewCustomer());
        tabelCustomer.setDefaultEditor(Object.class, null);
        add(sptrx);
        
        btnpilih.setBounds(650, 50, 120, 25);
        btnpilih.setCursor(new Cursor(12));
        btnpilih.setBackground(Color.black);
        btnpilih.setForeground(Color.white);
        add(btnpilih);
        
        btnaback.setBounds(25, 20, 80, 25);
        btnaback.setBackground(Color.white);
        btnaback.setCursor(new Cursor(12));
        btnaback.setBorder(null);
        add(btnaback);
        
        tabelCustomer.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelCustomer.getSelectedRow();
                textpilih.setText(ControllerObject.customerController.viewCustomer().getValueAt(i, 0).toString());
            }
        });
        
        btnaback.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnaback.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnaback.setForeground(Color.black);
            }
        });
        
        btnaback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuTambahCustomer(cek).setVisible(true);
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
                int idcustomer = Integer.parseInt(textpilih.getText());
                int idkasir = cek;
                ControllerObject.transaksiController.insertDataTransaksi(new TransaksiEntity(0,ControllerObject.customerController.dataSatuCustomer(idcustomer),ControllerObject.kasirController.satuDataKasir(idkasir)));
                int idtransaksi = ControllerObject.transaksiController.getIdTransaksi(idcustomer);
                new RincianTransaksi(cek,idcustomer,idkasir,idtransaksi).setVisible(true);
                dispose();
            }
        });
    }
}
