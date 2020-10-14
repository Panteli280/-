package com.company.model;

import java.util.ArrayList;

import static com.company.model.STATUS.*;

public class Player {

    private int id;
    private static int nextId = 1;
    public STATUS status = DEFEND;

    public ArrayList<Card> hand;

    public Player(Deck deck) {
        this.setId();
        this.hand = new ArrayList<Card>();

        for (int i = 0; i <= 5; i++) {
            this.hand.add(deck.drawFromDeck());
        }
    }

    void setId() {
        id = nextId;
        nextId++;
    }

    public int getId() {
        return id;
    }

    public void showCardsInHand() {
        System.out.println("\nCards of player #" + this.getId() + ": ");
        for (Card c : hand) {
            System.out.println(c.toString() + "; ");
        }
    }
}





