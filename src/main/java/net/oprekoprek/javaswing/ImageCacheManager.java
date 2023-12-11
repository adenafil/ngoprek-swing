package net.oprekoprek.javaswing;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ImageCacheManager {
    private final Map<String, ImageIcon> imageCache = new ConcurrentHashMap<>();

    public ImageIcon createImageIconByUrl(String imageUrl) {
        ImageIcon cachedImageIcon = imageCache.get(imageUrl);

        if (cachedImageIcon != null) {
            return cachedImageIcon;
        }

        ImageLoader imageLoader = new ImageLoader(imageUrl);
        imageLoader.addPropertyChangeListener(evt -> {
            if ("state".equals(evt.getPropertyName()) && SwingWorker.StateValue.DONE.equals(evt.getNewValue())) {
                try {
                    ImageIcon imageIcon = imageLoader.get();
                    imageCache.put(imageUrl, imageIcon);
                    // You can perform additional actions here if needed
                } catch (Exception e) {
                    e.printStackTrace();
                    // Handle exception if necessary
                }
            }
        });

        imageLoader.execute();
        return null; // Return null temporarily; the actual ImageIcon will be set asynchronously
    }

    private static class ImageLoader extends SwingWorker<ImageIcon, Void> {
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
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Image Cache Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            JLabel imageLabel1 = new JLabel();
            JLabel imageLabel2 = new JLabel();

            frame.getContentPane().setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
            frame.getContentPane().add(imageLabel1);
            frame.getContentPane().add(imageLabel2);

            ImageCacheManager imageCacheManager = new ImageCacheManager();

            String imageUrl1 = "https://example.com/image1.jpg"; // Replace with your actual URL
            String imageUrl2 = "https://example.com/image2.jpg"; // Replace with your actual URL

            ImageIcon imageIcon1 = imageCacheManager.createImageIconByUrl(imageUrl1);
            ImageIcon imageIcon2 = imageCacheManager.createImageIconByUrl(imageUrl2);

            imageLabel1.setIcon(imageIcon1);
            imageLabel2.setIcon(imageIcon2);

            frame.setSize(400, 400);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}
