package com.company.model;

import com.company.service.Game;

import java.util.ArrayList;

public class Creation {

    public static Deck deck;
    public static Board boards;
    public static Players hands;
    public static ArrayList<Card> hand;

    public Creation(){
        this.deck = new Deck();
        this.boards = new Board();

        this.hands = new Players(deck);
        this.hand = new ArrayList();
    }
}
