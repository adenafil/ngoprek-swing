package net.oprekoprek.javaswing;

import javax.swing.*;
import java.awt.*;

public class JScrollPaneExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("JScrollPane Example");

        // Membuat JPanel yang akan ditempatkan di dalam JScrollPane
        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(new GridLayout(20, 20)); // Contoh GridLayout

        // Menambahkan beberapa komponen ke dalam JPanel
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                contentPanel.add(new JButton("Button " + (i * 20 + j + 1)));
            }
        }

        // Membuat JScrollPane dan menetapkan JPanel sebagai kontennya
        JScrollPane scrollPane = new JScrollPane(contentPanel);

        // Menambahkan JScrollPane ke dalam frame
        frame.getContentPane().add(scrollPane);

        // Mengatur properti frame
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
