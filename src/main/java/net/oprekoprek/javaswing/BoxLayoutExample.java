package net.oprekoprek.javaswing;

import javax.swing.*;
import java.awt.*;

public class BoxLayoutExample extends JFrame {
    public BoxLayoutExample() {
        setTitle("BoxLayout Example");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BoxLayout(getContentPane(), BoxLayout.X_AXIS));

        add(new JButton("Button 1"));
        add(new JButton("Button 2"));
        add(new JButton("Button 3"));
        add(new JButton("Button 4"));
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BoxLayoutExample example = new BoxLayoutExample();
            example.setVisible(true);
        });
    }
}
