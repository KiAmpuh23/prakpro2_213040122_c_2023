import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 *
 * @author fajar
 */
public class BiodataDiri extends JFrame {

    private boolean checkBoxSelected;

    public BiodataDiri() {
        this.checkBoxSelected = false;
        // Mengatur operasi yang akan dijalankan ketika tombol keluar di klik
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Membuat label header
        JLabel headerLabel = new JLabel("Form Biodata", JLabel.CENTER);
        
        // Membuat panel kontrol
        JPanel controPanel = new JPanel();
        controPanel.setLayout(new FlowLayout());
        
        // Membuat panel utama
        JPanel panel = new JPanel();
        panel.setSize(800, 800);
        GridBagLayout layout = new GridBagLayout();
        panel.setLayout(layout);
        GridBagConstraints gbc = new GridBagConstraints();
        
        // Membuat komponen-komponen input dan tombol
        JLabel labelInputNama = new JLabel("Nama:");
        JTextField textFieldNama = new JTextField();
        JLabel labelInputNotelp = new JLabel("Nomor HP:");
        JTextField textFieldNotelp = new JTextField();
        JLabel labelJenisKelamin = new JLabel("Jenis Kelamin:");
        JRadioButton radioButtonL = new JRadioButton("Laki-Laki", true);
        JRadioButton radioButtonP = new JRadioButton("Perempuan");
        JCheckBox checkBox = new JCheckBox("Warga Negara Asing");
        JButton button = new JButton("Simpan");
        JTextArea txtOutput = new JTextArea("");
        
        // Mengatur tata letak komponen dengan GridBagLayout
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 0;
        gbc.gridy = 0;
        panel.add(labelInputNama, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panel.add(textFieldNama, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panel.add(labelInputNotelp, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        panel.add(textFieldNotelp, gbc);

        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.gridx = 1;
        gbc.gridy = 0;
        panel.add(labelJenisKelamin, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        panel.add(radioButtonL, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        panel.add(radioButtonP, gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        panel.add(checkBox, gbc);

        gbc.fill = GridBagConstraints.CENTER;
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        panel.add(button, gbc);
        
        // Mengelompokkan radio button
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButtonL);
        bg.add(radioButtonP);
        
        // item listener untuk perubahan status checkbox
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                checkBoxSelected = e.getStateChange() == 1;
            }
        });
        
        // action listener klik tombol "Simpan"
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textFieldNama.getText();
                String noTelp = textFieldNotelp.getText();
                String jenisKelamin = "";
                String WNA = "";

                if (radioButtonL.isSelected()) {
                    jenisKelamin = radioButtonL.getText();
                }
                if (radioButtonP.isSelected()) {
                    jenisKelamin = radioButtonP.getText();
                }

                if (checkBoxSelected) {
                    WNA = "Ya";
                } else {
                    WNA = "Tidak";
                }
                
                // Menampilkan hasil input di textarea
                txtOutput.append("Nama  :" + nama + "\n" +
                        "Nomor HP   :" + noTelp + "\n" +
                        "Jenis Kelamin  :" + jenisKelamin + "\n" +
                        "WNA    :" + WNA + "\n" + "Caprio Parlindungan Sinaga 203040036");
                
                // Mengosongkan input
                textFieldNama.setText("");
                textFieldNotelp.setText("");
            }
        });
        // Menambahkan panel kontrol ke frame
        controPanel.add(panel);
        
        // Mengatur layout frame dengan GridLayout
        this.setSize(800, 800);
        this.setLayout(new GridLayout(6, 2));
        // Menambahkan label header dan panel kontrol ke frame
        this.add(headerLabel);
        this.add(controPanel);
        
        // Menambahkan textarea ke frame
        this.add(txtOutput);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BiodataDiri b = new BiodataDiri();
                b.setVisible(true);
            }
        });
    }
}