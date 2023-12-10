package net.oprekoprek.javaswing;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class SimpleBrowser {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Simple Browser");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(800, 600);

            JEditorPane editorPane = new JEditorPane();
            editorPane.setEditable(false);

            JScrollPane scrollPane = new JScrollPane(editorPane);
            frame.add(scrollPane, BorderLayout.CENTER);

            try {
                // Ganti URL di bawah dengan URL yang ingin Anda tampilkan
                editorPane.setPage(new URL("https://example.com"));
            } catch (IOException e) {
                e.printStackTrace();
            }

            frame.setVisible(true);
        });
    }
}
