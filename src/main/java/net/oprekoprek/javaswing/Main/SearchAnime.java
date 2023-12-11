package net.oprekoprek.javaswing.Main;

import net.oprekoprek.javaswing.component.*;
import net.oprekoprek.javaswing.component.Card;

import javax.swing.*;
import java.awt.*;

public class SearchAnime {
    static Navbar navbar = new Navbar();

    public static void main(String[] args) {
        JFrame frame = new JFrame();

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(1920, 1080);
        frame.getContentPane().setBackground(Color.ORANGE);
        frame.setResizable(false);

//        CardAgain card = new CardAgain();
//        CardTopAnime card = new CardTopAnime();
//        CardRecomendationAnime recomendation = new CardRecomendationAnime();

//        GridBagConstraints gbc = new GridBagConstraints();
//
//        JPanel scrollingAnime = new JPanel();
//        scrollingAnime.setSize(1920, 1000);
//        scrollingAnime.setLayout(new GridBagLayout());
//
//        gbc.gridy = 0;
//
//        scrollingAnime.add(card.getCard(), gbc);
//
//        gbc.gridy = 1;
//        scrollingAnime.add(recomendation.getCard(), gbc);

        CardSearchAnime searchAnime = new CardSearchAnime();

        frame.add(navbar.getNavbar());
        navbar.setCardSearchAnime(searchAnime);
        frame.add(searchAnime.getCard());

//        frame.add(recomendation.getCard());
//        frame.add(Box.createHorizontalStrut(0));
//        frame.add(card.getCard());
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//
//        recomendation.addCard();
//        recomendation.addCard();
//        recomendation.addCard();
//        recomendation.addCard();
//        recomendation.addCard();
//        recomendation.addCard();
//        recomendation.addCard();
//        recomendation.addCard();
//        recomendation.addCard();
//        recomendation.addCard();
//        recomendation.addCard();
//        recomendation.addCard();
//



//        frame.add(card.getCard());
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();
//        card.addCard();


        frame.setVisible(true);

    }
}
