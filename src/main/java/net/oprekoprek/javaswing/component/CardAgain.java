package net.oprekoprek.javaswing.component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

public class CardAgain {
    JPanel cardPanel;
    private static final int CARD_WIDTH = 300;
    private static final int CARD_HEIGHT = 400;
    private static int[] x = {20, 350, 700, 1050, 1400};
    private static int index = 0;
    // will up constantly when index ==4 do 20 + 300;
    private static int normalY = 20;

    public JPanel getCard() {

        cardPanel = new JPanel();
        cardPanel.setLayout(new GridBagLayout());

        addCard();

        JScrollPane scrollPane = new JScrollPane(cardPanel);
        scrollPane.setPreferredSize(new Dimension(1920, 500));
        scrollPane.setOpaque(true);
        scrollPane.getViewport().getView().setBackground(Color.decode("#333b48"));
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setBackground(Color.decode("#333b48"));
//        scrollPane.setBackground(Color.BLACK);
//        scrollPane.setForeground(Color.YELLOW);
//        scrollPane.setBackground(Color.RED);
        System.out.println(scrollPane.getBackground());
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        JLabel topAnime = new JLabel("Top Anime");
        topAnime.setOpaque(true);
        topAnime.setBackground(Color.decode("#333b48"));
        topAnime.setForeground(Color.WHITE);
        topAnime.setFont(new Font(Font.SERIF, Font.BOLD, 30));
        topAnime.setPreferredSize(new Dimension(1600, 40));
        topAnime.setAlignmentX(JLabel.LEFT);

        JPanel panel = new JPanel();
        panel.add(topAnime);
        panel.setPreferredSize(new Dimension(1920, 500));
        panel.setBackground(Color.decode("#333b48"));
        panel.setLayout(new FlowLayout());
//        panel.setLayout(null);
//        panel.setBounds(20, 20, 1000, 1000);
        panel.add(scrollPane);

        return panel;
    }

    public void addCard() {

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
        gbc.gridx = x[index];
        gbc.gridy = normalY;
        gbc.insets = new Insets(10, 10, 10, 10);
        cardPanel.add(card, gbc);

        index++;
        if (index > 4) {
            index = 0;
            normalY += 300;
        }

        card.addMouseListener(
                new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        System.out.println("mama huhu");
                        System.out.println(title.getText());

                    }
                }
        );

    }
}
