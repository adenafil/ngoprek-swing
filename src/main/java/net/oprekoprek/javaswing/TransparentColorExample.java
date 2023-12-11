package net.oprekoprek.javaswing;

import javax.swing.*;
import java.awt.*;

public class TransparentColorExample {
    public static void main(String[] args) {
        JFrame frame = new JFrame("TransparentColor Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);

        // Warna dengan tingkat kejernihan (alpha) 0 (transparan)
//        Color transparentColor = new Color(255, 0, 0, 0);

        JPanel panel = new JPanel();
//        panel.setBackground(transparentColor);

        JLabel label = new JLabel("ade");
        label.setOpaque(true);
        label.setSize(new Dimension(100,100));
        label.setForeground(new Color(0, 0, 0));
        label.setFont(new Font(null, Font.PLAIN, 0));

        frame.add(label);
        frame.add(panel);
        frame.setVisible(true);
    }
}
