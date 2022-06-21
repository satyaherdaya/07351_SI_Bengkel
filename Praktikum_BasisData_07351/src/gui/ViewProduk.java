package gui;

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

public class ViewProduk extends JFrame{
    private int kode;
    JButton btnback = new JButton("<<Back");
    JButton btndelete = new JButton("Hapus Produk");
    JButton btnadd = new JButton("Tambah produk");    
    JTable tabelKasir = new JTable();
    JScrollPane sptrx = new JScrollPane(tabelKasir);
    JTextField textpilih = new JTextField();
    
    public ViewProduk(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("VIEW PRODUK");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(820,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        sptrx.setBounds(20, 50, 600, 350);
        tabelKasir.setModel(ControllerObject.produkController.listProduk());
        tabelKasir.setDefaultEditor(Object.class, null);
        add(sptrx);
        
        btnadd.setBounds(650, 50, 150, 25);
        btnadd.setCursor(new Cursor(12));
        btnadd.setBackground(Color.black);
        btnadd.setForeground(Color.white);
        add(btnadd);
        
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
                textpilih.setText(ControllerObject.produkController.listProduk().getValueAt(i, 0).toString());
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
                ControllerObject.produkController.hapusSatuDataProduk(kode);
                if(ControllerObject.produkController.hapusSatuDataProduk(kode)>0){
                    JOptionPane.showMessageDialog(null, "produk Berhasil Dihapus");
                }else{
                    JOptionPane.showMessageDialog(null, "Produk Gagal Dihapus");
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
                JTextField deskripsi = new JTextField();
                JTextField harga = new JTextField();
                JTextField stok = new JTextField();
                JTextField kategori = new JTextField();
                JTextField supplier = new JTextField();
                Object[] message = {
                    "Deskripsi Produk : ", deskripsi,
                    "Harga : ", harga,
                    "Stok : ",stok,
                    "id Kategori : ",kategori,
                    "id Supplier : ",supplier
                };
                int option = JOptionPane.showConfirmDialog(null,message,"Tambah Produk",JOptionPane.OK_CANCEL_OPTION);
                if(option==JOptionPane.OK_OPTION){
                    if(stok.getText()=="null"&&supplier.getText()=="null"){
                        ControllerObject.produkController.insertDataProdukJasa(deskripsi.getText(),Integer.parseInt(harga.getText()),ControllerObject.kategoriController.dataSatuKategori(Integer.parseInt(kategori.getText())));
                    }else{
                        ControllerObject.produkController.insertDataProduk(new ProdukEntity(deskripsi.getText(),Integer.parseInt(harga.getText()),Integer.parseInt(stok.getText()),ControllerObject.kategoriController.dataSatuKategori(Integer.parseInt(kategori.getText())),ControllerObject.supplierController.satuDataSupplier(Integer.parseInt(supplier.getText()))));
                    }
                    if(ControllerObject.produkController.insertDataProduk(new ProdukEntity(deskripsi.getText(),Integer.parseInt(harga.getText()),Integer.parseInt(stok.getText()),ControllerObject.kategoriController.dataSatuKategori(Integer.parseInt(kategori.getText())),ControllerObject.supplierController.satuDataSupplier(Integer.parseInt(supplier.getText()))))>0){
                        JOptionPane.showMessageDialog(null, "produk berhasil ditambahkan");
                    }else{
                        JOptionPane.showMessageDialog(null, "produk gagal ditambahkan");
                    }
                }
            }
        });
    }
}
