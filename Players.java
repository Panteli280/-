package com.company.model;

import java.util.ArrayList;

import static com.company.model.STATUS.*;

public class Players {

    public static ArrayList<Card> handA;
    public static String nameA;
    public static ArrayList<Card> handB;
    public static String nameB;

    public  Players(Deck deck, String oneName ,  String twoName) {
        handA = new ArrayList<Card>();
        nameA = oneName;

        for (int i = 0; i <= 5; i++) {
            handA.add(deck.drawFromDeck());
        }

        handB = new ArrayList<Card>();
        nameB = twoName;

        for (int i = 0; i <= 5; i++) {
            handB.add(deck.drawFromDeck());
        }
    }

    public void showCardsInHandA() {
        System.out.println("\nCards of player " + nameA + " :");
        for (Card c : handA) {
            System.out.println(c.toString() + " - " + (handA.indexOf(c)+1));
        }
    }

    public void showCardsInHandB() {
        System.out.println("\nCards of player " + nameB + " :");
        for (Card c : handB) {
            System.out.println(c.toString() + " - " + (handB.indexOf(c)+1));
        }
    }
}





