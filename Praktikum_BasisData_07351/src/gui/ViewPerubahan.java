package gui;

import entity.DetailPerubahanEntity;
import entity.ProdukEntity;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class ViewPerubahan extends JFrame{
    private int kode;
    JButton btnback = new JButton("<<Back");
    JButton btnadd = new JButton("Tambah Perubahan");    
    JTable tabelKasir = new JTable();
    JScrollPane sptrx = new JScrollPane(tabelKasir);
    JTextField textpilih = new JTextField();
    
    public ViewPerubahan(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("VIEW PERUBAHAN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        sptrx.setBounds(20, 50, 600, 350);
        tabelKasir.setModel(ControllerObject.detUbahController.listDetailPerubahan());
        tabelKasir.setDefaultEditor(Object.class, null);
        add(sptrx);
        
        btnadd.setBounds(650, 50, 150, 25);
        btnadd.setCursor(new Cursor(12));
        btnadd.setBackground(Color.black);
        btnadd.setForeground(Color.white);
        add(btnadd);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setCursor(new Cursor(12));
        btnback.setBorder(null);
        add(btnback);
        
        tabelKasir.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelKasir.getSelectedRow();
                textpilih.setText(ControllerObject.detUbahController.listDetailPerubahan().getValueAt(i, 0).toString());
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
                JTextField kategori = new JTextField();
                JTextField datasebelum = new JTextField();
                JTextField datasesudah = new JTextField();
                JTextField produkid = new JTextField();
                JTextField adminid = new JTextField();
                Object[] message = {
                    "Keterangan : ", kategori,
                    "Data Sebelum : ", datasebelum,
                    "Data Sesudah : ",datasesudah,
                    "id Produk : ",produkid,
                    "id Admin : ",adminid
                };
                JOptionPane.showInputDialog(message);
                if(JOptionPane.showInputDialog(message).length()>0){
                    ControllerObject.detUbahController.insertDataPerubahan(new DetailPerubahanEntity(kategori.getText(),datasebelum.getText(),datasesudah.getText(),ControllerObject.produkController.satuDataProduk(Integer.parseInt(produkid.getText())),ControllerObject.adminController.dataSatuAdmin(Integer.parseInt(adminid.getText()))));
                    if(ControllerObject.detUbahController.insertDataPerubahan(new DetailPerubahanEntity(kategori.getText(),datasebelum.getText(),datasesudah.getText(),ControllerObject.produkController.satuDataProduk(Integer.parseInt(produkid.getText())),ControllerObject.adminController.dataSatuAdmin(Integer.parseInt(adminid.getText()))))>0){
                        JOptionPane.showMessageDialog(null, "perubahan berhasil ditambahkan");
                    }else{
                        JOptionPane.showMessageDialog(null, "perubahan gagal ditambahkan");
                    }
                }
            }
        });
    }
}
