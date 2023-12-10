package net.oprekoprek.javaswing;

import javax.swing.*;

public class SearchTextFieldExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Search TextField Example");

        // Membuat JTextField
        JTextField searchField = new JTextField();

        // Mengatur teks informasi (placeholder)
        searchField.setToolTipText("Cari...");

        // Menambah JTextField ke frame
        frame.getContentPane().add(searchField);

        // Mengatur properti frame
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
