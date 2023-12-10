package net.oprekoprek.javaswing;

import javax.swing.*;
import java.awt.*;

public class FlexBoxLayoutExample extends JFrame {

    public FlexBoxLayoutExample() {
        setTitle("FlexBoxLayout Example");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set layout manager to FlowLayout
        setLayout(new FlowLayout(FlowLayout.LEFT));

        // Add components with some padding
        add(createButton("Button 1"));
        add(createButton("Button 2"));
        add(createButton("Button 3"));
        add(createButton("Button 4"));

        // Center the frame on the screen
        setLocationRelativeTo(null);
    }

    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(100, 30));
        return button;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            FlexBoxLayoutExample example = new FlexBoxLayoutExample();
            example.setVisible(true);
        });
    }
}
