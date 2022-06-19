package gui;

import entity.TransaksiEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class belumditentukan extends JFrame{
    private int kode;
    JButton btnback = new JButton("<<Back");
    JButton btnpilih = new JButton("Pilih Kasir");
    JTable tabelKasir = new JTable();
    JScrollPane sptrx = new JScrollPane(tabelKasir);
    JTextField textpilih = new JTextField();

    public belumditentukan(int cek,int idcustomer) {
        initComponent(cek,idcustomer);
    }
    
    void initComponent(int cek,int idcustomer){
        setTitle("VIEW CUSTOMER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        sptrx.setBounds(20, 50, 600, 350);
        tabelKasir.setModel(ControllerObject.kasirController.viewKasir());
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
                textpilih.setText(ControllerObject.kasirController.viewKasir().getValueAt(i, 0).toString());
            }
        });
        
        tabelKasir.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelKasir.getSelectedRow();
                textpilih.setText(ControllerObject.transaksiController.listTransaksi().getValueAt(i, 0).toString());
                kode = Integer.parseInt(textpilih.getText());
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
                
            }
        });
    }
}
