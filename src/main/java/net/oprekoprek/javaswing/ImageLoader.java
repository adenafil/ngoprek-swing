package net.oprekoprek.javaswing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;

public class ImageLoader extends SwingWorker<ImageIcon, Void> {
    private final String imageUrl;

    public ImageLoader(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    protected ImageIcon doInBackground() {
        try {
            BufferedImage bufferedImage = loadImageData(imageUrl);
            return new ImageIcon(bufferedImage);
        } catch (IOException e) {
            e.printStackTrace();
            // Handle exception if necessary
        }
        return null;
    }

    private BufferedImage loadImageData(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        return ImageIO.read(url);
    }

    public static void createImageByUrl(String imageUrl, JLabel labelToUpdate) {
        ImageLoader imageLoader = new ImageLoader(imageUrl);

        imageLoader.addPropertyChangeListener(evt -> {
            if ("state".equals(evt.getPropertyName()) && SwingWorker.StateValue.DONE.equals(evt.getNewValue())) {
                try {
                    ImageIcon imageIcon = imageLoader.get();
                    labelToUpdate.setIcon(imageIcon);
                } catch (Exception e) {
                    e.printStackTrace();
                    // Handle exception if necessary
                }
            }
        });

        imageLoader.execute();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image Loader Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel imageLabel = new JLabel();
            frame.getContentPane().add(imageLabel);

            String imageUrl = "https://cdn.myanimelist.net/images/anime/1015/138006.jpg";  // Replace with your actual URL
            createImageByUrl(imageUrl, imageLabel);

            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
