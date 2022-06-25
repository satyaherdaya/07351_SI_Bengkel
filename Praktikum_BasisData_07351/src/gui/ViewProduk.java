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

public class ViewProduk extends JFrame{
    private int kode;
    JButton btnback = new JButton("<<Back");
    JButton btndelete = new JButton("Hapus Produk");
    JButton btnadd = new JButton("Tambah produk");
    JButton btnadd2 = new JButton("Tambah jasa");
    JButton btnubahstock= new JButton("ubah stock");
    JButton btnubahharga= new JButton("ubah harga");
    JButton btnrefresh = new JButton("Refresh");    
    JTable tabelViewProduk = new JTable();
    JScrollPane sptrx = new JScrollPane(tabelViewProduk);
    JTextField textpilih = new JTextField();
    JTextField textpilih2 = new JTextField();
    JTextField textpilih3 = new JTextField();
    
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
        tabelViewProduk.setModel(ControllerObject.produkController.listProdukLengkap());
        tabelViewProduk.setDefaultEditor(Object.class, null);
        add(sptrx);
        
        btnadd.setBounds(650, 50, 150, 25);
        btnadd.setCursor(new Cursor(12));
        btnadd.setBackground(Color.black);
        btnadd.setForeground(Color.white);
        add(btnadd);
        
        btnadd2.setBounds(650, 90, 150, 25);
        btnadd2.setCursor(new Cursor(12));
        btnadd2.setBackground(Color.black);
        btnadd2.setForeground(Color.white);
        add(btnadd2);
        
        btnubahstock.setBounds(650, 130, 150, 25);
        btnubahstock.setCursor(new Cursor(12));
        btnubahstock.setBackground(Color.black);
        btnubahstock.setForeground(Color.white);
        add(btnubahstock);
        
        btnubahharga.setBounds(650, 170, 150, 25);
        btnubahharga.setCursor(new Cursor(12));
        btnubahharga.setBackground(Color.black);
        btnubahharga.setForeground(Color.white);
        add(btnubahharga);
        
        btndelete.setBounds(650, 210, 150, 25);
        btndelete.setCursor(new Cursor(12));
        btndelete.setBackground(Color.black);
        btndelete.setForeground(Color.white);
        add(btndelete);
        
        btnrefresh.setBounds(550, 20, 80, 25);
        btnrefresh.setBackground(Color.white);
        btnrefresh.setCursor(new Cursor(12));
        btnrefresh.setBorder(null);
        add(btnrefresh);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setCursor(new Cursor(12));
        btnback.setBorder(null);
        add(btnback);
        
        tabelViewProduk.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelViewProduk.getSelectedRow();
                textpilih.setText(ControllerObject.produkController.listProdukLengkap().getValueAt(i, 0).toString());
                textpilih2.setText(ControllerObject.produkController.listProdukLengkap().getValueAt(i, 2).toString());
                textpilih3.setText(ControllerObject.produkController.listProdukLengkap().getValueAt(i, 3).toString());
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
                //ControllerObject.produkController.hapusSatuDataProduk(kode);
                if(ControllerObject.produkController.hapusSatuDataProduk(kode)>0){
                    JOptionPane.showMessageDialog(null, "produk Berhasil Dihapus");
                    tabelViewProduk.setModel(ControllerObject.produkController.listProdukLengkap());
                }else{
                    JOptionPane.showMessageDialog(null, "Produk Gagal Dihapus");
                }
            }
        });
        
        btnubahstock.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnubahstock.setForeground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnubahstock.setForeground(Color.white);
            }
        });
        
        btnubahstock.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                kode = Integer.parseInt(textpilih.getText());
                String datasebelum = textpilih3.getText();
                int stock = Integer.parseInt(JOptionPane.showInputDialog("masukkan stock baru"));
                ControllerObject.produkController.ubahStokProduk(stock,kode);
                ControllerObject.detUbahController.insertDataPerubahan(new DetailPerubahanEntity("Ubah Stock",datasebelum,String.valueOf(stock),ControllerObject.produkController.satuDataProduk(kode),ControllerObject.adminController.dataSatuAdmin(cek)));
                if(ControllerObject.produkController.ubahStokProduk(stock,kode)>0){
                    JOptionPane.showMessageDialog(null, "produk Berhasil Diubah");
                }else{
                    JOptionPane.showMessageDialog(null, "Produk Gagal Diubah");
                }
            }
        });
        
        btnubahharga.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnubahharga.setForeground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnubahharga.setForeground(Color.white);
            }
        });
        
        btnubahharga.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                kode = Integer.parseInt(textpilih.getText());
                String datasebelum = textpilih3.getText();
                int harga = Integer.parseInt(JOptionPane.showInputDialog("masukkan harga baru"));
                ControllerObject.produkController.ubahHargaProduk(harga,kode);
                ControllerObject.detUbahController.insertDataPerubahan(new DetailPerubahanEntity("Ubah Harga",datasebelum,String.valueOf(harga),ControllerObject.produkController.satuDataProduk(kode),ControllerObject.adminController.dataSatuAdmin(cek)));
                if(ControllerObject.produkController.ubahHargaProduk(harga,kode)>0){
                    JOptionPane.showMessageDialog(null, "produk Berhasil Diubah");
                }else{
                    JOptionPane.showMessageDialog(null, "Produk Gagal Diubah");
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
                    if(ControllerObject.produkController.insertDataProduk(new ProdukEntity(deskripsi.getText(),Integer.parseInt(stok.getText()),Integer.parseInt(harga.getText()),ControllerObject.kategoriController.dataSatuKategori(Integer.parseInt(kategori.getText())),ControllerObject.supplierController.satuDataSupplier(Integer.parseInt(supplier.getText()))))>0){
                        JOptionPane.showMessageDialog(null, "produk berhasil ditambahkan");
                    }else{
                        JOptionPane.showMessageDialog(null, "produk gagal ditambahkan");
                    }
                }
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
                tabelViewProduk.setModel(ControllerObject.produkController.listProdukLengkap());                
            }
        });
        
        btnadd2.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnadd2.setForeground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnadd2.setForeground(Color.white);
            }
        });
        
        btnadd2.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                JTextField deskripsi = new JTextField();
                JTextField harga = new JTextField();
                JTextField kategori = new JTextField();
                Object[] message = {
                    "Deskripsi Produk : ", deskripsi,
                    "Harga : ", harga,
                    "id Kategori : ",kategori
                };
                int option = JOptionPane.showConfirmDialog(null,message,"Tambah Jasa",JOptionPane.OK_CANCEL_OPTION);
                if(option==JOptionPane.OK_OPTION){
                    if(ControllerObject.produkController.insertDataProdukJasa(deskripsi.getText(),Integer.parseInt(harga.getText()),ControllerObject.kategoriController.dataSatuKategori(Integer.parseInt(kategori.getText())))>0){
                        JOptionPane.showMessageDialog(null, "produk berhasil ditambahkan");
                    }else{
                        JOptionPane.showMessageDialog(null, "produk gagal ditambahkan");
                    }
                }
            }
        });
    }
}
