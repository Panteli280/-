package com.company.model;

import java.util.ArrayList;

public class Creation {

    public static Deck deck;
    public static Board boards;
    public static Players hands;
    public static SUIT trump;
    public static STATUS status;

    public Creation(String oneName ,  String twoName){
        this.status = STATUS.ATOD;
        this.trump = SUIT.getTrump();
        this.deck = new Deck();
        this.boards = new Board();

        this.hands = new Players(deck, oneName, twoName);
    }
}
