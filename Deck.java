package com.company.model;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    public ArrayList<Card> deck;
    public int index = 0;

    public Deck() {
        this.deck = new ArrayList<Card>();
        SUIT[] suit = SUIT.values();
        RANK[] rank = RANK.values();

        for (SUIT s : suit)  {
            for (RANK r : rank) {
                deck.add(new Card(s, r));
            }
        }

        Random rnd = new Random();
        for (int i = 1; i < deck.size(); i++) {
            int j = rnd.nextInt(i);
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);

            int tr = rnd.nextInt(suit.length);
            SUIT trump = suit[tr];
        }
    }

    public Card drawFromDeck(){
            Card drawedCard = deck.get(index);
            deck.remove(index);
            index++;
            return drawedCard;
    }

    public int getSizeOfDeck() {
        return deck.size();
    }
}
