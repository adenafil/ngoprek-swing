package net.oprekoprek.javaswing;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutWithGapExample extends JFrame {
    public FlowLayoutWithGapExample() {
        setTitle("FlowLayout with Gap Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        add(new JButton("Button 1"));
        add(Box.createHorizontalStrut(100)); // Menambahkan ruang horizontal sebesar 10 piksel
        add(new JButton("Button 2"));
        add(Box.createHorizontalStrut(10)); // Menambahkan ruang horizontal sebesar 10 piksel
        add(new JButton("Button 3"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlowLayoutWithGapExample example = new FlowLayoutWithGapExample();
            example.setVisible(true);
        });
    }
}
