package net.oprekoprek.javaswing.component;

import javax.swing.*;
import java.awt.*;

public class ScrollCard extends JFrame {
    public ScrollCard() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1920, 1080);
        this.setResizable(true);

        JPanel contentPanel = new JPanel();
        contentPanel.setLayout(null);
//        contentPanel.setLayout(new GridLayout(5, 100)); // Contoh GridLayout

        Card card = new Card();

        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 40; j++) {
                contentPanel.add(card.createCard(0, (j + 1) * 20));
            }
        }

        contentPanel.add(card.createCard(0, 0));

            JScrollPane scrollCard = new JScrollPane(contentPanel);
        scrollCard.setOpaque(true);
//        scrollCard.setBackground(Color.decode("#33383e"));
        scrollCard.setBackground(Color.YELLOW);
        scrollCard.setBounds(0, 0, 1920, 980);

        add(scrollCard);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ScrollCard();
    }
}
