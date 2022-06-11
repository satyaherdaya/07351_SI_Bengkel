package gui;

import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class MenuKasir extends JFrame{
    private int kode;
    JButton btnviewnota = new JButton("View Nota");
    JButton btnlogout = new JButton("Logout");
    JTable tabelTrx = new JTable();
    JScrollPane sptrx = new JScrollPane(tabelTrx);
    JTextField textpilih = new JTextField();
    
    public MenuKasir(int cek) {
        initComponent(cek);
    }
    
    void initComponent(int cek){
        setTitle("VERIFIKASI TRANSAKSI");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1200,480);
        setLocationRelativeTo(null);
        getContentPane().setBackground(Color.white);
        setLayout(null);
        setVisible(true);
        
        sptrx.setBounds(20, 50, 1000, 350);
        tabelTrx.setModel(ControllerObject.transaksiController.listTransaksi());
        tabelTrx.setDefaultEditor(Object.class, null);
        add(sptrx);
        
        btnviewnota.setBounds(1050, 50, 120, 25);
        btnviewnota.setCursor(new Cursor(12));
        btnviewnota.setBackground(Color.black);
        btnviewnota.setForeground(Color.white);
        add(btnviewnota);
        
        btnlogout.setBounds(25, 20, 80, 25);
        btnlogout.setBackground(Color.white);
        btnlogout.setCursor(new Cursor(12));
        btnlogout.setBorder(null);
        add(btnlogout);
        
        tabelTrx.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelTrx.getSelectedRow();
                textpilih.setText(ControllerObject.transaksiController.listTransaksi().getValueAt(i, 0).toString());
            }
        });
        
        tabelTrx.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseClicked(MouseEvent e){
                int i = tabelTrx.getSelectedRow();
                textpilih.setText(ControllerObject.transaksiController.listTransaksi().getValueAt(i, 0).toString());
                kode = Integer.parseInt(textpilih.getText());
                if(e.getClickCount()==2){
                    kode = Integer.parseInt(textpilih.getText());
                    new ViewNota(cek,kode).setVisible(true);
                    dispose();                    
                }
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
                new LoginKasir().setVisible(true);
                dispose();
            }
        });
        
        btnviewnota.addMouseListener(new MouseAdapter(){
            @Override
            public void mouseEntered(MouseEvent e){
                btnviewnota.setForeground(Color.yellow);
            }
            
            @Override
            public void mouseExited(MouseEvent e){
                btnviewnota.setForeground(Color.white);
            }
        });
        
        btnviewnota.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                kode = Integer.parseInt(textpilih.getText());
                new ViewNota(cek,kode).setVisible(true);
                dispose();
            }
        });
    }
}
