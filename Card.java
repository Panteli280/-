package com.company.model;

public class Card {
    private SUIT suit;
    private RANK rank;

    public Card(SUIT suit, RANK rank) {
        this.suit = suit;
        this.rank = rank;
    }

    public SUIT getSuit() {
        return suit;
    }

    public RANK getRank() {
        return rank;
    }

    public String toString() {
        return "[" + suit + ":" + rank + "]";
    }
}
