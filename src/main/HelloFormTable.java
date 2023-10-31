/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
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

public class HelloFormTable extends JFrame {
    
    private boolean checkBoxSelected;
    
    public HelloFormTable() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Label untuk nama
        JLabel labelNama = new JLabel("Nama :");
        labelNama.setBounds(15, 40, 350, 15);
        
        // Label untuk nomor
        JLabel labelNomor = new JLabel("Nomor :");
        labelNomor.setBounds(15, 100, 350, 15);
        
        // Label untuk jenis kelamin
        JLabel labelRadio = new JLabel("Jenis Kelamin :");
        labelRadio.setBounds(15, 160, 350, 15);
        
        // Kotak teks untuk Nama
        JTextField textNama = new JTextField();
        textNama.setBounds(15, 60, 200, 30);
         
        // Kotak teks untuk Nomor
        JTextField textNomor = new JTextField();
        textNomor.setBounds(15, 120, 200, 30);
            
        // Tombol "Simpan"
        JButton button = new JButton("Simpan");
        button.setBounds(15, 260, 100, 40);
         
        // Checkbox "Warga Negara Asing"
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        checkBox.setBounds(15, 230, 200, 30);
        
        // RadioButton "Laki-laki" (dipilih sebagai default)
        JRadioButton rButton1 = new JRadioButton("Laki-laki", true);
        rButton1.setBounds(15, 180, 200, 30);
        
        // RadioButton "Perempuan"
        JRadioButton rButton2 = new JRadioButton("Perempuan");
        rButton2.setBounds(15, 200, 200, 30);
         
        javax.swing.JTable table = new JTable();
        JScrollPane scrollAbleTable = new JScrollPane(table);
        scrollAbleTable.setBounds(15, 320, 350, 200);
        
        FormInputTable formTable = new FormInputTable();
        table.setModel(formTable);
        
        // grup tombol untuk radio
        ButtonGroup bg = new ButtonGroup();
        bg.add(rButton1);
        bg.add(rButton2);
        
        // item listener untuk checkboxselected
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() ==1;
            }
        });
        
        // action listener untuk simpan
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jeniskelamin = "", nama = textNama.getText(), nomor = textNomor.getText(), wna;
                if (rButton1.isSelected()) jeniskelamin = rButton1.getText();
                if (rButton2.isSelected()) jeniskelamin = rButton2.getText();
                wna = checkBoxSelected ? "Ya" : "Bukan";
                
                textNama.setText("");
                textNomor.setText("");
                
                formTable.add(new ArrayList<>(Arrays.asList(nama, nomor, jeniskelamin, wna)));
                
            }
        });
        
        // menambahkan komponen ke JFRame
        this.add(labelNama);
        this.add(labelNomor);
        this.add(labelRadio);
        this.add(rButton1);
        this.add(rButton2);
        this.add(textNama);
        this.add(textNomor);
        this.add(button);
        this.add(checkBox);
        this.add(scrollAbleTable);
        this.setSize(400, 700);
        this.setLayout(null);         
    }
    
    // main
    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
              new HelloFormTable().setVisible(true);
            }
        });
    }
    
}
