package net.oprekoprek.javaswing.Main;

import net.oprekoprek.javaswing.component.Navbar;

import javax.swing.*;

public class Main {
    static Navbar navbar = new Navbar();

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1920, 1080);
        frame.setResizable(false);

        frame.add(navbar.getNavbar());
        frame.setVisible(true);

    }
}
