package com.company.model;

import java.util.ArrayList;

import static com.company.model.STATUS.*;

public class Players {

    public STATUS status = ATOD;
    public static ArrayList<Card> handA;
    public static ArrayList<Card> handB;

    public  Players(Deck deck) {
        handA = new ArrayList<Card>();

        for (int i = 0; i <= 5; i++) {
            handA.add(deck.drawFromDeck());
        }

        handB = new ArrayList<Card>();

        for (int i = 0; i <= 5; i++) {
            handB.add(deck.drawFromDeck());
        }
    }

    public STATUS getStatus() {
        return status;
    }

    public void showCardsInHandA() {
        System.out.println("\nCards of player #A: ");
        for (Card c : handA) {
            System.out.println(c.toString() + "; ");
        }
    }

    public void showCardsInHandB() {
        System.out.println("\nCards of player #B: ");
        for (Card c : handB) {
            System.out.println(c.toString() + "; ");
        }
    }
}





