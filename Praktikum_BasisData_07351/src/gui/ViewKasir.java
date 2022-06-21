package gui;

import entity.KasirEntity;
import entity.TransaksiEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ViewKasir extends JFrame{
    private int kode;
    JButton btnback = new JButton("<<Back");
    JButton btnadd = new JButton("Tambah Kasir");
    JButton btndelete = new JButton("Hapus Kasir");
//    JButton btnupdate = new JButton("Delete Supplier");
    JTable tabelKasir = new JTable();
    JScrollPane sptrx = new JScrollPane(tabelKasir);
    JTextField textpilih = new JTextField();

    public ViewKasir(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("VIEW KASIR");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        sptrx.setBounds(20, 50, 600, 350);
        tabelKasir.setModel(ControllerObject.kasirController.viewKasir());
        tabelKasir.setDefaultEditor(Object.class, null);
        add(sptrx);
        
        btnadd.setBounds(650, 50, 150, 25);
        btnadd.setCursor(new Cursor(12));
        btnadd.setBackground(Color.black);
        btnadd.setForeground(Color.white);
        add(btnadd);
//        
//        btnupdate.setBounds(650, 90, 120, 25);
//        btnupdate.setCursor(new Cursor(12));
//        btnupdate.setBackground(Color.black);
//        btnupdate.setForeground(Color.white);
//        add(btnupdate);
        
        btndelete.setBounds(650, 90, 150, 25);
        btndelete.setCursor(new Cursor(12));
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
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
                new MenuAdmin(cek).setVisible(true);
                dispose();
            }
        });
        
        btnadd.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnadd.setForeground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnadd.setForeground(Color.white);
            }
        });
        
        btnadd.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField nama = new JTextField();
                JTextField alamat = new JTextField();
                JTextField notelp = new JTextField();
                JTextField username = new JTextField();
                JTextField password = new JTextField();
                Object[] message = {
                    "Nama : ", nama,
                    "Alamat : ", alamat,
                    "Notelp : ", notelp,
                    "Username : ", username,
                    "Password : ", password
                };
                JOptionPane.showInputDialog(message);
                if(JOptionPane.showInputDialog(message).length()>0){
                    ControllerObject.kasirController.insertDataKasir(new KasirEntity(nama.getText(),alamat.getText(),notelp.getText(),username.getText(),password.getText()));
                    if(ControllerObject.kasirController.insertDataKasir(new KasirEntity(nama.getText(),alamat.getText(),notelp.getText(),username.getText(),password.getText()))>0){
                        JOptionPane.showMessageDialog(null, "kasir berhasil ditambahkan");
                    }else{
                        JOptionPane.showMessageDialog(null, "kasir gagal ditambahkan");
                    }
                }
            }
        });
        
//        btnupdate.addMouseListener(new MouseAdapter(){
//            @Override
//            public void mouseEntered(MouseEvent e){
//                btnupdate.setForeground(Color.yellow);
//            }
//            
//            @Override
//            public void mouseExited(MouseEvent e){
//                btnupdate.setForeground(Color.white);
//            }
//        });
//        
//        btnupdate.addActionListener(new ActionListener(){
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                kode = Integer.parseInt(textpilih.getText());
//                ControllerObject.kasirController.hapusDataKasir(kode);
//                if(ControllerObject.kasirController.hapusDataKasir(kode)>0){
//                    JOptionPane.showMessageDialog(null, "Kasir Berhasil Dihapus");
//                }else{
//                    JOptionPane.showMessageDialog(null, "Kasir Gagal Dihapus");
//                }
//            }
//        });
        
        btndelete.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btndelete.setForeground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btndelete.setForeground(Color.white);
            }
        });
        
        btndelete.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                kode = Integer.parseInt(textpilih.getText());
                ControllerObject.kasirController.hapusDataKasir(kode);
                if(ControllerObject.kasirController.hapusDataKasir(kode)>0){
                    JOptionPane.showMessageDialog(null, "Kasir Berhasil Dihapus");
                }else{
                    JOptionPane.showMessageDialog(null, "Kasir Gagal Dihapus");
                }
            }
        });
    }
}
