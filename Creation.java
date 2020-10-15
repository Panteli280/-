package com.company.model;

import com.company.service.Game;

import java.util.ArrayList;

public class Creation {

    public static Deck deck;
    public static Board boards;
    public static Player handA;
    public static Player handB;
    public static ArrayList<Card> hand;

    public Creation(){
        this.deck = new Deck();
        this.boards = new Board();

        this.handA = new Player(deck);
        this.handB = new Player(deck);
        this.hand = new ArrayList();
    }
}
