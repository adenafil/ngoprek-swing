package net.oprekoprek.javaswing;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class CustomScrollPaneExample {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Custom ScrollPane Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JTextArea textArea = new JTextArea(10, 30);
            textArea.setText("Lorem ipsum dolor sit amet, consectetur adipiscing elit. " +
                    "Pellentesque ac massa nec libero facilisis fringilla.");

            JScrollPane scrollPane = new JScrollPane(textArea) {
                @Override
                protected void paintComponent(Graphics g) {
                    // Menggambar latar belakang sesuai dengan kebutuhan
                    g.setColor(new Color(255, 255, 200)); // Warna latar belakang yang diinginkan
                    g.fillRect(0, 0, getWidth(), getHeight());

                    // Melanjutkan dengan menggambar komponen lainnya
                    super.paintComponent(g);
                }
            };

            scrollPane.getVerticalScrollBar().setBackground(Color.BLACK);
            scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
                @Override
                protected void configureScrollBarColors() {
                    this.thumbColor = Color.BLACK;
                }
            });


            frame.getContentPane().add(scrollPane);
            frame.setSize(300, 200);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
