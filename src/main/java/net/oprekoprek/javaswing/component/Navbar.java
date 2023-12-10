package net.oprekoprek.javaswing.component;

import javax.swing.*;
import java.awt.*;

public class Navbar extends JFrame {

    public JPanel getNavbar() {
        // div
        JPanel divContainer = new JPanel();
        divContainer.setLayout(new BoxLayout(divContainer, BoxLayout.Y_AXIS));
        divContainer.setSize(1920, 100);

        // div
        JPanel divNav = new JPanel();
        divNav.setBackground(Color.decode("#e8d459"));

//
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setSize(1920, 1080);
//        this.setResizable(false);
//        this.setLayout(null);
//        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        // Component Logo
        JLabel logo = new JLabel("ADEANIMELIST");
        logo.setOpaque(true);
//        logo.setPreferredSize(new Dimension(200, 200));
//        logo.setLayout(null);
        logo.setBounds(10, 0, 400, 200);
        logo.setForeground(Color.BLACK);
        logo.setBackground(Color.decode("#e8d459"));
        logo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        // Component JTextField

        JTextField search = new JTextField();
//        search.setBounds(500, 0, 1000, 40);
        search.setPreferredSize(new Dimension(500, 40));
        search.setText("Cari anime...");
        search.setFont(new Font(null, Font.BOLD, 20));

        // Component Dasboard
        JLabel dashboard = new JLabel("Dashboard");
        dashboard.setOpaque(true);
        dashboard.setBounds(1000, 0, 100, 100);
        dashboard.setFont(new Font(null, Font.PLAIN, 20));
        dashboard.setForeground(Color.BLACK);
        dashboard.setBackground(Color.decode("#e8d459"));

        // listener
        search.addActionListener(e -> {
            if (e.getSource() == search ) {
                System.out.println(search.getText());
            }
        });

//        add(dashboard);
//        add(search);
//        add(logo);
//
        divNav.add(Box.createVerticalStrut(80));
        divNav.add(logo);
        divNav.add(Box.createHorizontalStrut(500));
        divNav.add(search);
        divNav.add(Box.createHorizontalStrut(500));
        divNav.add(dashboard);


        divContainer.add(divNav);
//        add(divContainer);

        return divContainer;
    }

    public static void main(String[] args) {
        Navbar navbar = new Navbar();
        navbar.add(navbar.getNavbar());
        navbar.setVisible(true);
    }

}
