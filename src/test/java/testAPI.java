import net.oprekoprek.javaswing.api.JikanAPI;
import net.oprekoprek.javaswing.util.ImageRenderer;
import net.sandrohc.jikan.Jikan;
import net.sandrohc.jikan.exception.JikanQueryException;
import net.sandrohc.jikan.model.anime.Anime;
import org.junit.jupiter.api.Test;

import javax.swing.*;
import java.util.Collection;

public class testAPI {
    static Jikan jikan;

    static {
        jikan = new Jikan();
    }

    @Test
    void getImageAndTitle() throws JikanQueryException {
        Collection<Anime> results = jikan.query().anime().search()
                .query("Naruto")
                .limit(10)
                .execute()
                .collectList()
                .block();

        for (Anime anime : results) {
            System.out.println(anime.title);
            System.out.println(anime.images.getJpg().largeImageUrl);

            ImageIcon icon = ImageRenderer.createImageIconByURL(anime.images.getJpg().largeImageUrl);
        }
    }
}
