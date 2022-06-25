package gui;

import entity.SupplierEntity;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

public class ViewSupplier extends JFrame{
    private int kode;
    JButton btnback = new JButton("<<Back");
    JButton btnadd = new JButton("Tambah Supplier");
    JButton btndelete = new JButton("Hapus Supplier");
    JButton btnrefresh = new JButton("Refresh");
//    JButton btnupdate = new JButton("Delete Supplier");
    JTable tabelSupplier = new JTable();
    JScrollPane sptrx = new JScrollPane(tabelSupplier);
    JTextField textpilih = new JTextField();

    public ViewSupplier(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("VIEW SUPPLIER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        sptrx.setBounds(20, 50, 600, 350);
        tabelSupplier.setModel(ControllerObject.supplierController.listSupplier());
        tabelSupplier.setDefaultEditor(Object.class, null);
        add(sptrx);
        
        btnadd.setBounds(650, 50, 150, 25);
        btnadd.setCursor(new Cursor(12));
        btnadd.setBackground(Color.black);
        btnadd.setForeground(Color.white);
        add(btnadd);
        
        btnrefresh.setBounds(550, 20, 80, 25);
        btnrefresh.setBackground(Color.white);
        btnrefresh.setCursor(new Cursor(12));
        btnrefresh.setBorder(null);
        add(btnrefresh);
        
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
        
        tabelSupplier.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelSupplier.getSelectedRow();
                textpilih.setText(ControllerObject.supplierController.listSupplier().getValueAt(i, 0).toString());
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
                tabelSupplier.setModel(ControllerObject.supplierController.listSupplier());
            }
        });
        
        btnback.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new MenuAdmin(cek).setVisible(true);
                dispose();
            }
        });
        
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
                ControllerObject.supplierController.hapusDataSupplier(kode);
                if(ControllerObject.supplierController.hapusDataSupplier(kode)>0){
                    JOptionPane.showMessageDialog(null, "Supplier Berhasil Dihapus");
                }else{
                    JOptionPane.showMessageDialog(null, "Supplier Gagal Dihapus");
                }
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
                Object[] message = {
                    "Nama : ", nama,
                    "Alamat : ", alamat,
                    "Notelp : ",notelp
                };
                int option = JOptionPane.showConfirmDialog(null,message,"Tambah Supplier",JOptionPane.OK_CANCEL_OPTION);
                if(option==JOptionPane.OK_OPTION){
                    if(ControllerObject.supplierController.insertDataSupplier(new SupplierEntity(nama.getText(),alamat.getText(),notelp.getText()))>0){
                        JOptionPane.showMessageDialog(null, "supplier berhasil ditambahkan");
                    }else{
                        JOptionPane.showMessageDialog(null, "supplier gagal ditambahkan");
                    }
                }
            }
        });
    }
}
