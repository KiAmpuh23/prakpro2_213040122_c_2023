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

public class AplikasiBiodata extends JFrame {
    
   private boolean checkBoxSelected;
   private String wnaStatus;
    
   public AplikasiBiodata(){
       this.checkBoxSelected = false;
       this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       this.wnaStatus = "Bukan";
       
       // labelinput dan textfield untuk nama
       JLabel labelInput1 = new JLabel("Nama:");
       labelInput1.setBounds(15,40,350,10);
       
       JTextField textField1 = new JTextField();
       textField1.setBounds(15,60,350,30);
       
       // label input dan textfield untuk no HP
       JLabel labelInput2 = new JLabel("Nomor HP:");
       labelInput2.setBounds(15,100,350,10);
       
       JTextField textField2 = new JTextField();
       textField2.setBounds(15,120,350,30);
       
       // label untuk jenis kelamin
       JLabel labelRadio = new JLabel("Jenis Kelamin:");
       labelRadio.setBounds(15,160,350,10);
       
       // radiobutton untuk pilihan laki laki dan perempuan
       JRadioButton rButton1 = new JRadioButton("Laki-Laki", true);
       rButton1.setBounds(15,175,350,30);
       
       JRadioButton rButton2 = new JRadioButton("Perempuan");
       rButton2.setBounds(15,205,350,30);
       
       // mengelompokan radiobutton
       ButtonGroup bg = new ButtonGroup();
       bg.add(rButton1);
       bg.add(rButton2);
       
       // checkbox untuk WNA
       JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
       checkBox.setBounds(15, 235, 350, 30);
       
       // tombol simpan
       JButton button = new JButton("Simpan");
       button.setBounds(15,265,100,40);
      
       // textarea untuk output
       JTextArea txtOutput = new JTextArea("");
       txtOutput.setBounds(15,315,700,100);
       
       // item listener untuk perubahan status checkbox
       checkBox.addItemListener(new ItemListener(){
           public void itemStateChanged(ItemEvent e){
               checkBoxSelected= e.getStateChange()==1;
               wnaStatus = checkBoxSelected ? "Ya" : "Bukan";
           }
       });
       
       // action listener untuk klik tombol simpan
       button.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
               String jenisKelamin = "";
               if(rButton1.isSelected()){
                   jenisKelamin = rButton1.getText();
               }
               if(rButton2.isSelected()){
                   jenisKelamin = rButton2.getText();
               }
               
               String nama = textField1.getText();
               String nomorHp = textField2.getText();
               txtOutput.append("Nama:  "+nama+"\n");
               txtOutput.append("No HP:  "+nomorHp+"\n");
               txtOutput.append("Jenis Kelamin:  "+jenisKelamin+"\n");
               txtOutput.append("WNA: " + wnaStatus + "\n");
               txtOutput.append("===============================");
               textField1.setText("");
               textField2.setText("");
           }
       });
       
       // menambahkan komponen komponen ke frame
       this.add(button);
       this.add(textField1);
       this.add(textField2);
       this.add(checkBox);
       this.add(labelInput1);
       this.add(labelInput2);
       this.add(labelRadio);
       this.add(rButton1);
       this.add(rButton2);
       this.add(txtOutput);
       
       this.setSize(800,1280); // menentukan ukuran frame
       this.setLayout(null); 
       
   } 
   
       public static void main(String[] args){
        javax.swing.SwingUtilities.invokeLater(new Runnable(){
           public void run(){
               AplikasiBiodata h = new AplikasiBiodata();
               h.setVisible(true);
           } 
        });
    }
            
}
