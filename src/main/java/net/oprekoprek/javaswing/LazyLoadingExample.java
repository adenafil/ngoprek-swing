package net.oprekoprek.javaswing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class LazyLoadingExample extends SwingWorker<Void, ImageIcon> {
    private final List<String> imageUrls;
    private final JLabel labelToUpdate;

    public LazyLoadingExample(List<String> imageUrls, JLabel labelToUpdate) {
        this.imageUrls = imageUrls;
        this.labelToUpdate = labelToUpdate;
    }

    @Override
    protected Void doInBackground() {
        for (String imageUrl : imageUrls) {
            try {
                byte[] imageData = loadImageData(imageUrl);
                ImageIcon imageIcon = new ImageIcon(imageData);

                // Publish the ImageIcon to be processed in the process method
                publish(imageIcon);

            } catch (IOException e) {
                e.printStackTrace();
                // Handle exception if necessary
            }
        }
        return null;
    }

    @Override
    protected void process(List<ImageIcon> chunks) {
        // Process the ImageIcon chunks and update the UI
        for (ImageIcon icon : chunks) {
            labelToUpdate.setIcon(icon);
        }
    }

    private byte[] loadImageData(String imageUrl) throws IOException {
        URL url = new URL(imageUrl);
        BufferedImage bufferedImage = ImageIO.read(url);

        // Convert BufferedImage to byte array
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ImageIO.write(bufferedImage, "png", byteArrayOutputStream);

        return byteArrayOutputStream.toByteArray();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Lazy Loading Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel imageLabel = new JLabel();
            frame.getContentPane().add(imageLabel);

            LazyLoadingExample lazyLoader = new LazyLoadingExample(
                    List.of("https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "https://cdn.myanimelist.net/images/anime/1015/138006.jpg", "https://cdn.myanimelist.net/images/anime/1015/138006.jpg"), // Replace with your actual URLs
                    imageLabel
            );

            lazyLoader.execute();

            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
