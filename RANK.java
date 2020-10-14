package com.company.model;

public enum RANK {
    ACE(14),
    SIX(6),
    SEVEN(7),
    EIGHT(8),
    NINE(9),
    TEN(10),
    JACK(11),
    QUEEN(12),
    KING(13);

    private final int value;

    RANK(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}