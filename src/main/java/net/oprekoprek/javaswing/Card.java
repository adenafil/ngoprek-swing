package net.oprekoprek.javaswing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Card extends JFrame {
    private static final Map<String, ImageIcon> imageCache = new ConcurrentHashMap<>();

    public Card() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        JPanel panel = new JPanel(new FlowLayout(FlowLayout.LEADING, 10, 10));
        panel.setBackground(Color.WHITE);

        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));
        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));
        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));
        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));
        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));

        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));
        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));
        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));
        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));
        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));

        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));
        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));
        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));
        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));
        panel.add(createCard("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "Sousou No Frieren"));


        JScrollPane jScrollPane = new JScrollPane(panel);
        add(jScrollPane, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new Card();
    }

    public JPanel createCard(String imageUrl, String titleText) {
        JPanel cardPanel = new JPanel(new BorderLayout());
        cardPanel.setBackground(Color.ORANGE);

        JLabel imgLabel = new JLabel();
        ImageIcon imageIcon = createImageIconByURL(imageUrl);
        imgLabel.setIcon(imageIcon);

        JLabel titleLabel = new JLabel("<html><p>" + titleText + "</p></html>");
        titleLabel.setBackground(Color.ORANGE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font(Font.SERIF, Font.PLAIN, 20));

        cardPanel.add(imgLabel, BorderLayout.CENTER);
        cardPanel.add(titleLabel, BorderLayout.SOUTH);

        return cardPanel;
    }

    public ImageIcon createImageIconByURL(String imageUrl) {
        ImageIcon cachedImage = imageCache.get(imageUrl);
        if (cachedImage != null) {
            return cachedImage;
        }

        try {
            Image image = ImageIO.read(new URL(imageUrl));
            if (image != null) {
                ImageIcon newImageIcon = new ImageIcon(image);
                imageCache.put(imageUrl, newImageIcon);
                return newImageIcon;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
