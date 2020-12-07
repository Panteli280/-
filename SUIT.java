package com.company.model;

import java.util.Random;

public enum SUIT {
    HEARTS,
    SPADES,
    DIAMONDS,
    CLUBS;

    public static SUIT getTrump() {
        int Trump = new Random().nextInt(SUIT.values().length);
        return SUIT.values()[Trump];
    }
}
