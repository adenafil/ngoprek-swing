package net.oprekoprek.javaswing.Main;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;

public class Card extends JFrame {
    private static final int CARD_WIDTH = 300;
    private static final int CARD_HEIGHT = 400;
    private static int[] x = {20, 350, 700, 1050, 1400};
    private static int index = 0;
    // will up constantly when index ==4 do 20 + 300;
    private static int normalY = 20;

    static JPanel cardPanel;

    static {
        cardPanel = new JPanel();
        cardPanel.setLayout(new GridBagLayout());

    }


    public void updateAnimeCollection(String name) {
        System.out.println(normalY);
        addCard(cardPanel, x[index],  normalY);
        index++;
        if (index > 4) {
            index = 0;
            normalY += 300;
        }
    }

    public JScrollPane getMyAnimeCollection() {
        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new GridBagLayout());





        JScrollPane scrollPane = new JScrollPane(cardPanel);
//        scrollPane.setPreferredSize(new Dimension(1920, 1000));
//        scrollPane.setBounds(0, 30, 1000, 1000);
        scrollPane.setOpaque(true);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
//        scrollPane.getViewport().getView().setBackground(Color.decode("#333b48"));

        return scrollPane;
    }

    public Card() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1920, 1080);
        setResizable(false);
        setBackground(Color.black);
        setLayout(new FlowLayout());

        JPanel cardPanel = new JPanel();
        cardPanel.setLayout(new GridBagLayout());

        addCard(cardPanel, 20, 20);
        addCard(cardPanel, 350, 20);
        addCard(cardPanel, 700, 20);
        addCard(cardPanel, 1050, 20);
        addCard(cardPanel, 1400, 20);

        addCard(cardPanel, 20, 300);
        addCard(cardPanel, 350, 300);
        addCard(cardPanel, 700, 300);
        addCard(cardPanel, 1050, 300);
        addCard(cardPanel, 1400, 300);

        addCard(cardPanel, 20, 600);
        addCard(cardPanel, 350, 600);
        addCard(cardPanel, 700, 600);
        addCard(cardPanel, 1050, 600);
        addCard(cardPanel, 1400, 600);
//
//        addCard(cardPanel, 20, 900);
//        addCard(cardPanel, 350, 900);
//        addCard(cardPanel, 700, 900);
//        addCard(cardPanel, 1050, 900);
//        addCard(cardPanel, 1400, 900);
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");
//        updateAnimeCollection("ade");





        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setPreferredSize(new Dimension(1920, 1000));
        scrollPane.setOpaque(true);
        scrollPane.getViewport().getView().setBackground(Color.decode("#333b48"));
//        scrollPane.setBackground(Color.BLACK);
//        scrollPane.setForeground(Color.YELLOW);
//        scrollPane.setBackground(Color.RED);
        System.out.println(scrollPane.getBackground());
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(1920, 1000));
        panel.setBackground(Color.YELLOW);
//        panel.setLayout(null);
//        panel.setBounds(20, 20, 1000, 1000);
        panel.add(scrollPane);

        add(panel);

        setVisible(true);
    }


    public void addCard(JPanel panel, int x, int y) {
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));
        card.setBackground(Color.ORANGE);

        JLabel img = new JLabel();
        img.setOpaque(true);
        img.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT - 100));
        img.setBackground(Color.gray);

        JLabel title = new JLabel("<html><p>Sousou No Frieren</p></html>");
        title.setPreferredSize(new Dimension(CARD_WIDTH, 60));
        title.setBackground(Color.ORANGE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font(Font.SERIF, Font.PLAIN, 22));

        card.add(img);
        card.add(title);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(card, gbc);
    }

//    public static void addCard(int x, int y) {
//        JPanel card = new JPanel();
//        card.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));
//        card.setBackground(Color.ORANGE);
//
//        JLabel img = new JLabel();
//        img.setOpaque(true);
//        img.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT - 100));
//        img.setBackground(Color.gray);
//
//        JLabel title = new JLabel("<html><p>Sousou No Frieren</p></html>");
//        title.setPreferredSize(new Dimension(CARD_WIDTH, 60));
//        title.setBackground(Color.ORANGE);
//        title.setHorizontalAlignment(SwingConstants.CENTER);
//        title.setFont(new Font(Font.SERIF, Font.PLAIN, 22));
//
//        card.add(img);
//        card.add(title);
//
//        GridBagConstraints gbc = new GridBagConstraints();
//        gbc.gridx = x;
//        gbc.gridy = y;
//        gbc.insets = new Insets(10, 10, 10, 10);
//        cardPanel.add(card, gbc);
//    }
//

    public static void addCardStatic(JPanel panel, int x, int y) {
        JPanel card = new JPanel();
        card.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT));
        card.setBackground(Color.ORANGE);

        JLabel img = new JLabel();
        img.setOpaque(true);
        img.setPreferredSize(new Dimension(CARD_WIDTH, CARD_HEIGHT - 100));
        img.setBackground(Color.gray);

        JLabel title = new JLabel("<html><p>Sousou No Frieren</p></html>");
        title.setPreferredSize(new Dimension(CARD_WIDTH, 60));
        title.setBackground(Color.ORANGE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font(Font.SERIF, Font.PLAIN, 22));

        card.add(img);
        card.add(title);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = x;
        gbc.gridy = y;
        gbc.insets = new Insets(10, 10, 10, 10);
        panel.add(card, gbc);
    }


    public static void main(String[] args) {
        new Card();
    }
}
