package net.oprekoprek.javaswing;

import javax.swing.*;
import java.awt.*;

public class FlowLayoutExample extends JFrame {
    public FlowLayoutExample() {
        setTitle("FlowLayout Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new FlowLayout());

        add(new JButton("Button 1"));
        add(new JButton("Button 2"));
        add(new JButton("Button 3"));
        add(new JButton("Button 4"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlowLayoutExample example = new FlowLayoutExample();
            example.setVisible(true);
        });
    }
}
