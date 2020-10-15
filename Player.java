package com.company.model;

import java.util.ArrayList;

import static com.company.model.STATUS.*;

public class Player {

    public STATUS status = DEFENDER;
    public static ArrayList<Card> hand;

    public  Player(Deck deck) {
        this.hand = new ArrayList<Card>();

        for (int i = 0; i <= 5; i++) {
            this.hand.add(deck.drawFromDeck());
        }
    }
    public STATUS getStatus() {
        return status;
    }
}





