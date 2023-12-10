package net.oprekoprek.javaswing.component;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Card extends JFrame {
    private static final Map<String, ImageIcon> imageCache = new ConcurrentHashMap<>();
    public Card() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLayout(null);
        this.setSize(1920, 1080);
        this.setResizable(false);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 40, 1920, 800);

        ImageIcon imageAnime = createImageIconByURL("https://cdn.myanimelist.net/images/anime/1015/138006.jpg");
        JLabel labelImg = new JLabel();
        labelImg.setOpaque(true);
        labelImg.setBounds(0, 0, 300, 400);
        labelImg.setBackground(Color.YELLOW);

        panel.add(createCard(20, 20));
        panel.add(createCard(375, 20));
        panel.add(createCard(775, 20));
        panel.add(createCard(1175, 20));
        panel.add(createCard(1575, 20));

        panel.add(createCard(20, 500));
        panel.add(createCard(375, 500));
        panel.add(createCard(775, 500));
        panel.add(createCard(1175, 500));
        panel.add(createCard(1575, 500));

        panel.add(createCard(20, 1000));
        panel.add(createCard(375, 1000));
        panel.add(createCard(775, 1000));
        panel.add(createCard(1175, 1000));
        panel.add(createCard(1575, 1000));


        JScrollPane jScrollPane = new JScrollPane(panel);
//        jScrollPane.setBounds(0, 20, 1920, 800);
        jScrollPane.setPreferredSize(new Dimension(1920, 800));

        this.add(jScrollPane);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Card();
    }

    public JPanel createCard(int x, int y) {
//        ImageIcon imageAnime = createImageIconByURL("https://cdn.myanimelist.net/images/anime/1015/138006.jpg");
        JPanel bg = new JPanel();
        bg.setOpaque(true);
        bg.setBounds(x, y, 300, 400);
        bg.setBackground(Color.ORANGE);
        bg.setLayout(null);

        JLabel img = new JLabel();
        img.setOpaque(true);
        img.setBounds(0, 0, 300, 300);
        img.setBackground(Color.gray);

        JLabel title = new JLabel();
        title.setOpaque(true);
        title.setText("<html><p>Sousou No Frieren</p></html>");
        title.setBounds(0, 330, 300, 30);
//        title.setBackground(Color.BLUE);
        title.setBackground(Color.ORANGE);
        title.setHorizontalAlignment(SwingConstants.CENTER);
        title.setFont(new Font(Font.SERIF, Font.PLAIN, 20));

        bg.add(img);
        bg.add(title);


        return bg;
    }

    public ImageIcon createImageIconByURL(String imageUrl) {
        // Check if the image is already in the cache
        ImageIcon cachedImage = imageCache.get(imageUrl);
        if (cachedImage != null) {
            return cachedImage;
        }

        try {
            // Fetch and create the ImageIcon
            Image image = ImageIO.read(new URL(imageUrl));
            if (image != null) {
                ImageIcon newImageIcon = new ImageIcon(image);

                // Cache the image for future use
                imageCache.put(imageUrl, newImageIcon);

                return newImageIcon;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
