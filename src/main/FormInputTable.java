/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main;

/**
 *
 * @author fajar
 */

import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class FormInputTable extends AbstractTableModel {

    // Mendefinisikan nama kolom tabel
    private String[] columnNames = {"Nama", "Nomor", "Jenis Kelamin", "WNA"};
    
    // Menyimpan data tabel dalam ArrayList
    private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>();
    
    // Mendapatkan jumlah baris dalam tabel
    public int getRowCount() {
        return data.size();
    }
    
    // Mendapatkan jumlah kolom dalam tabel
    public int getColumnCount() {
        return columnNames.length;
    }
    
    // Mendapatkan nama kolom berdasarkan indeks kolom
    public String getColumnName(int col) {
        return columnNames[col];
    }
    
    // Mendapatkan nilai sel dalam tabel berdasarkan indeks baris dan kolom
    public Object getValueAt(int rowIndex, int columnIndex) {
        List<String> rowData = data.get(rowIndex);
        return rowData.get(columnIndex);
    }
    
    // Menentukan apakah sel dalam tabel dapat diedit
    public boolean isCellEditable(int row, int col) {
        return false;
    }
    
    // Menambahkan data baru ke dalam tabel
    public void add(ArrayList<String> value) {
        data.add(value);
        // Memberi tahu model bahwa baris telah ditambahkan
        fireTableRowsInserted(data.size() - 1, data.size() - 1);
    }
}

