package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuAdmin extends JFrame{
    JLabel labeljudul = new JLabel("MENU ADMIN");
    JButton btviewperubahan = new JButton("Update History");
    JButton btnviewkasir = new JButton("View Kasir");
    JButton btnviewsupplier = new JButton("View Supplier");
    JButton btnviewproduk = new JButton("View Product");
    JButton btnlogout = new JButton("<<Logout");
    
    
    public MenuAdmin(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("MENU ADMIN");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(640,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        labeljudul.setBounds(240, 60, 200, 25);
        labeljudul.setFont(new Font("Segoe Print",1,20));
        add(labeljudul);
        
        btviewperubahan.setBounds(140, 150, 140, 100);
        btviewperubahan.setCursor(new Cursor(12));
        btviewperubahan.setBackground(Color.black);
        btviewperubahan.setForeground(Color.white);
        add(btviewperubahan);
        
        btnviewkasir.setBounds(320, 150, 140, 100);
        btnviewkasir.setCursor(new Cursor(12));
        btnviewkasir.setBackground(Color.black);
        btnviewkasir.setForeground(Color.white);
        add(btnviewkasir);
        
        btnviewproduk.setBounds(140, 270, 140, 100);
        btnviewproduk.setCursor(new Cursor(12));
        btnviewproduk.setBackground(Color.black);
        btnviewproduk.setForeground(Color.white);
        add(btnviewproduk);
        
        btnviewsupplier.setBounds(320, 270, 140, 100);
        btnviewsupplier.setCursor(new Cursor(12));
        btnviewsupplier.setBackground(Color.black);
        btnviewsupplier.setForeground(Color.white);
        add(btnviewsupplier);
        
        btnlogout.setBounds(25, 20, 80, 25);
        btnlogout.setBackground(Color.white);
        btnlogout.setCursor(new Cursor(12));
        btnlogout.setBorder(null);
        add(btnlogout);
        
        btnviewsupplier.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewSupplier(cek).setVisible(true);
                dispose();
            }
        });
        
        btviewperubahan.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewPerubahan(cek).setVisible(true);
                dispose();                
            }
        });
        
        btnlogout.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnlogout.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnlogout.setForeground(Color.black);
            }
        });
        
        btnlogout.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                LoginAdmin loginAdmin = new LoginAdmin();
                loginAdmin.setVisible(true);
                dispose();
            }
        });
        
        btnviewkasir.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewKasir(cek).setVisible(true);
                dispose();
            }
        });
        
        btnviewproduk.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewProduk(cek).setVisible(true);
                dispose();
            }
        });
    
        btnviewsupplier.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnviewsupplier.setBackground(Color.white);
                btnviewsupplier.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnviewsupplier.setBackground(Color.black);
                btnviewsupplier.setForeground(Color.white);
            }
        });
        
        btviewperubahan.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btviewperubahan.setBackground(Color.white);
                btviewperubahan.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btviewperubahan.setBackground(Color.black);
                btviewperubahan.setForeground(Color.white);
            }
        });
        
        btnviewkasir.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnviewkasir.setBackground(Color.white);
                btnviewkasir.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnviewkasir.setBackground(Color.black);
                btnviewkasir.setForeground(Color.white);
            }
        });
        
        btnviewproduk.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnviewproduk.setBackground(Color.white);
                btnviewproduk.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnviewproduk.setBackground(Color.black);
                btnviewproduk.setForeground(Color.white);
            }
        });
    }
}
