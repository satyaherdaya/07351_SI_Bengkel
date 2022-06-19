package gui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;


public class MenuTambahCustomer extends JFrame{
    JLabel labeljudul = new JLabel("MENU ADMIN");
    JButton btncustomerlama = new JButton("Customer Lama");
    JButton btncustomerbaru = new JButton("Customer Baru");
    JButton btnback = new JButton("<<Kembali");
    
    public MenuTambahCustomer(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("PILIH CUSTOMER");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(440,380);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        btncustomerlama.setBounds(50, 150, 140, 100);
        btncustomerlama.setCursor(new Cursor(12));
        btncustomerlama.setBackground(Color.black);
        btncustomerlama.setForeground(Color.white);
        add(btncustomerlama);
        
        btncustomerbaru.setBounds(250, 150, 140, 100);
        btncustomerbaru.setCursor(new Cursor(12));
        btncustomerbaru.setBackground(Color.black);
        btncustomerbaru.setForeground(Color.white);
        add(btncustomerbaru);
        
        btnback.setBounds(25, 20, 80, 25);
        btnback.setBackground(Color.white);
        btnback.setCursor(new Cursor(12));
        btnback.setBorder(null);
        add(btnback);
        
        btncustomerlama.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new PilihCustomer(cek).setVisible(true);
                dispose();                
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
                new MenuKasir(cek).setVisible(true);
                dispose();
            }
        });
        
        btncustomerbaru.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                new TambahCustomer(cek).setVisible(true);
                dispose();
            }
        });
        
        btncustomerlama.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btncustomerlama.setBackground(Color.white);
                btncustomerlama.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btncustomerlama.setBackground(Color.black);
                btncustomerlama.setForeground(Color.white);
            }
        });
        
        btncustomerbaru.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btncustomerbaru.setBackground(Color.white);
                btncustomerbaru.setForeground(Color.blue);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btncustomerbaru.setBackground(Color.black);
                btncustomerbaru.setForeground(Color.white);
            }
        });
    }
    
}
