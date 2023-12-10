package net.oprekoprek.javaswing;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutWithGapExample extends JFrame {
    public BoxLayoutWithGapExample() {
        setTitle("BoxLayout with Gap Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        add(new JButton("Button 1"));
        add(Box.createVerticalStrut(10)); // Menambahkan ruang vertikal sebesar 10 piksel
        add(new JButton("Button 2"));
        add(Box.createVerticalStrut(10)); // Menambahkan ruang vertikal sebesar 10 piksel
        add(new JButton("Button 3"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BoxLayoutWithGapExample example = new BoxLayoutWithGapExample();
            example.setVisible(true);
        });
    }
}
