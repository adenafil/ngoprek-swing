package net.oprekoprek.javaswing.component;

import net.oprekoprek.javaswing.api.JikanAPI;
import net.oprekoprek.javaswing.util.ImageLoaderWorker;
import net.oprekoprek.javaswing.util.ImageRenderer;
import net.oprekoprek.javaswing.util.ResizeImageIcon;
import net.sandrohc.jikan.exception.JikanQueryException;
import net.sandrohc.jikan.model.anime.Anime;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

public class Navbar extends JFrame {
    private String searchByUser;
    private CardSearchAnime cardSearchAnime;

    public JPanel getNavbar() {
        // div
        JPanel divContainer = new JPanel();
        divContainer.setLayout(new BoxLayout(divContainer, BoxLayout.Y_AXIS));
        divContainer.setSize(1920, 100);
        divContainer.setOpaque(true);
        divContainer.setBackground(Color.ORANGE);

        // div
        JPanel divNav = new JPanel();
        divNav.setOpaque(true);
        divNav.setBackground(Color.ORANGE);

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
        logo.setBackground(Color.ORANGE);
        logo.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 30));

        // Component JTextField

        JTextField search = new JTextField();
//        search.setBounds(500, 0, 1000, 40);
        search.setPreferredSize(new Dimension(500, 40));
        search.setText("Cari anime...");
        search.setFont(new Font(null, Font.BOLD, 20));

        // Component Dasboard
        JLabel dashboard = new JLabel("Dashbsoard");
        dashboard.setOpaque(true);
        dashboard.setBounds(1000, 0, 120, 100);
        dashboard.setFont(new Font(null, Font.PLAIN, 20));
        dashboard.setForeground(Color.BLACK);
        dashboard.setBackground(Color.ORANGE);

        // listener
        search.addActionListener(e -> {
            if (e.getSource() == search ) {
                cardSearchAnime.removeData();
                cardSearchAnime.setIndex(0);
                System.out.println(search.getText());
                setSearchByUser(search.getText());

                // sementara

//                try {
//                    Collection<Anime> anime = JikanAPI.getTitleAndImageAnimeBySearch(getSearchByUser());
//                    ImageLoaderWorker imageLoaderWorker = new ImageLoaderWorker(anime);
//                    imageLoaderWorker.execute();
//
////                    anime.forEach(ade -> {
////                        anime.parallelStream().forEach(adebayor -> ImageRenderer.createImageIconByUrl(adebayor.images.getJpg().largeImageUrl));
////                        ImageRenderer.createImageIconByUrl(ade.images.getJpg().largeImageUrl);
////                    });
//
//                        anime.parallelStream().forEach(ade -> addAnime(ade.title, ResizeImageIcon.setImageIconSize(ImageRenderer.createImageIconByURL(ade.images.getJpg().largeImageUrl), 450, 450)));
//
////                    for (Anime data : anime) {
//////                        ImageRenderer.createImageIconByUrl(data.images.getJpg().largeImageUrl);
////                        addAnime(data.title, ResizeImageIcon.setImageIconSize(ImageRenderer.createImageIconByURL(data.images.getJpg().largeImageUrl), 450, 450));
////                    }
//
//
//                } catch (JikanQueryException ex) {
//                    throw new RuntimeException(ex);
//                }

                try {
                    JikanAPI.getTitleAndImageAnimeBySearchAsync(search.getText())
                            .subscribeOn(Schedulers.parallel())
                            .subscribe(
                                    animeList -> {
                                        ImageLoaderWorker imageLoaderWorker = new ImageLoaderWorker(animeList);
                                        imageLoaderWorker.execute();
                                        animeList.stream().parallel().forEach(bayor -> addAnime(bayor.title, ResizeImageIcon.setImageIconSize(ImageRenderer.createImageIconByURL(bayor.images.getJpg().largeImageUrl), 450, 450), bayor.malId));
                                    },
                                    throwable -> {
                                        System.out.println("error : " + throwable.getMessage());
                                    }
                            );
                } catch (JikanQueryException ex) {
                    throw new RuntimeException(ex);
                }
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

    public String getSearchByUser() {
        return searchByUser;
    }

    public void setSearchByUser(String search) {
        this.searchByUser = search;
    }


    public static void main(String[] args) {
        Navbar navbar = new Navbar();
        navbar.add(navbar.getNavbar());
        navbar.setVisible(true);
    }

    public CardSearchAnime getCardSearch() {
        return cardSearchAnime;
    }

    public void setCardSearchAnime(CardSearchAnime cardSearchAnime) {
        this.cardSearchAnime = cardSearchAnime;
    }

    public void addAnime(String title,ImageIcon image, int id) {
        getCardSearch().addCard(title, image, id);
    }


}
