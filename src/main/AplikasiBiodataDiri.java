/*
 * Aplikasi Biodata Diri.
 */
package main;

/**
 *
 * @author fajar
 */

import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class AplikasiBiodataDiri extends JFrame {
    
    
    public AplikasiBiodataDiri() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        

        
        this.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e) {
                int confirm = JOptionPane.showOptionDialog(
                null, "Anda yakin ingin keluar?", "Konfirmasi Keluar", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, null, null);
                
                if (confirm == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
                
            }
        });
        
        JLabel lInput1 = new JLabel("Nama :");
        lInput1.setBounds(15, 40, 350, 10);
        
        JTextField tField1 = new JTextField();
        tField1.setBounds(15, 60, 350, 30);
        
        JLabel lInput2 = new JLabel("No HP :");
        lInput2.setBounds(15, 100, 350, 10);
        
        JTextField tField2 = new JTextField();
        tField2.setBounds(15, 120, 350, 30);
        
        JLabel lRadio1 = new JLabel("Jenis Kelamin :");
        lRadio1.setBounds(15, 160, 350, 10);
        
        JRadioButton rButton1 = new JRadioButton("Laki-laki", true);
        rButton1.setBounds(15, 175, 350, 30);
        
        JRadioButton rButton2 = new JRadioButton("Perempuan");
        rButton2.setBounds(15, 200, 350, 30);
        
        ButtonGroup bg = new ButtonGroup();
        bg.add(rButton1);
        bg.add(rButton2);
        
        JLabel lInput3 = new JLabel("Alamat :");
        lInput3.setBounds(15, 230, 350, 10);

        JTextField tField3 = new JTextField();
        tField3.setBounds(15, 250, 350, 100);
        
        JButton button1 = new JButton("Simpan");
        button1.setBounds(15, 360, 120, 40);
        
        JButton button2 = new JButton("Edit");
        button2.setBounds(140, 360, 120, 40);
        
        JButton button3 = new JButton("Hapus");
        button3.setBounds(265, 360, 120, 40);
        
        JButton button4 = new JButton("Simpan Ke File");
        button4.setBounds(390, 360, 160, 40);
        
        javax.swing.JTable table = new JTable();
        JScrollPane scrollableTable = new JScrollPane(table);
        scrollableTable.setBounds(15, 410, 580, 300);
        
        TableModel tableModel = new TableModel();
        table.setModel(tableModel);
        
        button1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisKelamin = "";
                if (rButton1.isSelected()) {
                    jenisKelamin = rButton1.getText();
                }
                if (rButton2.isSelected()) {
                    jenisKelamin = rButton2.getText();
                }
                
                String nama = tField1.getText();
                String noHp = tField2.getText();
                String alamat = tField3.getText();
                
                if (nama.isEmpty() || noHp.isEmpty() || alamat.isEmpty() || jenisKelamin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Ada field yang belum diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    int confirm = JOptionPane.showConfirmDialog(
                    null, "Apakah anda yakin ingin menyimpan data?", "Konfirmasi SIMPAN", JOptionPane.YES_NO_OPTION);
                    if (confirm == JOptionPane.YES_OPTION) {
                       tableModel.add(new ArrayList<>(Arrays.asList(nama, noHp, jenisKelamin, alamat)));
                       tField1.setText(""); 
                       tField2.setText("");
                       tField3.setText("");
                       rButton1.setSelected(true);  
                    }
                }
                
            }
        });
        
        button2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang akan diedit", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    String JenisKelamin = "";
                    if (rButton1.isSelected()) {
                        JenisKelamin = rButton1.getText();
                    }
                    if (rButton2.isSelected()) {
                        JenisKelamin = rButton2.getText();
                    }
                    
                    String nama = tField1.getText();
                    String noHp = tField2.getText();
                    String alamat = tField3.getText();
                    
                    if (nama.isEmpty() || noHp.isEmpty() || alamat.isEmpty() || JenisKelamin.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Ada field yang belum diisi", "Peringatan", JOptionPane.WARNING_MESSAGE);
                    } else {
                        int confirm = JOptionPane.showConfirmDialog(
                                null, "Apakah Anda yakin ingin mengedit data?", "Konfirmasi Edit", JOptionPane.YES_NO_OPTION);
                        
                        if (confirm == JOptionPane.YES_OPTION) {
                            DefaultTableModel model = (DefaultTableModel) table.getModel();
                            
                            Vector rowData = new Vector();
                            rowData.add(nama);
                            rowData.add(noHp);
                            rowData.add(JenisKelamin);
                            rowData.add(alamat);
                            
                            model.removeRow(selectedRow);
                            model.insertRow(selectedRow, rowData);
                            
                            tField1.setText("");
                            tField2.setText("");
                            tField3.setText("");
                            rButton1.setSelected(true);
                        }
                    }
                    
                }
            }
        });
        
        button3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = table.getSelectedRow();
                if (selectedRow == -1) {
                    JOptionPane.showMessageDialog(null, "Pilih baris yang akan dihapus", "Peringatan", JOptionPane.WARNING_MESSAGE);
                } else {
                    int confirm = JOptionPane.showConfirmDialog(
                    null, "Apakah Anda yakin ingin menghapus data?", "Konfirmasi Hapus", JOptionPane.YES_NO_OPTION);
                    
                    if (confirm == JOptionPane.YES_OPTION) {
                        DefaultTableModel model = (DefaultTableModel) table.getModel();
                        model.removeRow(selectedRow);
                    }
                }
            }
        });
        
        this.add(lInput1);
        this.add(lInput2);
        this.add(lInput3);
        this.add(lRadio1);
        this.add(tField1);
        this.add(tField2);
        this.add(tField3);
        this.add(rButton1);
        this.add(rButton2);
        this.add(button1);
        this.add(button2);
        this.add(button3);
        this.add(button4);
        this.add(scrollableTable);
        
        this.setSize(900, 1000);
        this.setLayout(null);
    }
    
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run() {
                AplikasiBiodataDiri h = new AplikasiBiodataDiri();
                h.setVisible(true);
            }
        });
        
    }
    
}
