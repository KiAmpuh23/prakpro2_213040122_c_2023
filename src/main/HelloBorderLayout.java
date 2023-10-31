/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author fajar
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HelloBorderLayout extends JFrame {
    
    public HelloBorderLayout(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Label untuk pertanyaan dan hasil
        JLabel labelPertanyaan = new JLabel("Apakah ibukota Indonesia?");
        JLabel labelHasil = new JLabel("Jawab pertanyaan di atas");
        
        // RadioButton untuk menjawab pertanyaan
        JButton buttonA = new JButton("Jakarta");
        JButton buttonB = new JButton("Bandung");
        JButton buttonC = new JButton("Surabaya");
        
        // action listener untuk buttonA berisi jawaban benar
        buttonA.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                labelHasil.setText("Jawaban anda benar");
            }
        });
        
        // action listener untuk buttonB berisi jawaban salah
        buttonB.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                labelHasil.setText("Jawaban anda salah");
            }
        });
        
        // action listener untuk buttonC berisi jawaban salah
        buttonC.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                labelHasil.setText("Jawaban anda salah");
            }
        });
        
        // menambahkan komponen komponen ke frame dan posisi borderlayout nya
        this.add(labelPertanyaan, BorderLayout.NORTH);
        this.add(labelHasil, BorderLayout.SOUTH);
        this.add(buttonA, BorderLayout.WEST);
        this.add(buttonB, BorderLayout.CENTER);
        this.add(buttonC, BorderLayout.EAST);
        
        // menentukan ukuran frame
        this.setSize(400,200);
        
    }
    
    public static void main (String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
            public void run(){
                HelloBorderLayout h = new HelloBorderLayout();
                h.setVisible(true);
            }
        });
    }
    
}
