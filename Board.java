package com.company.model;

import java.util.ArrayList;

public class Board {

    public ArrayList<Card> board;
    public ArrayList<Card> defBoard;

    public Board(){
        this.board = new ArrayList<Card>();
        this.defBoard = new ArrayList<Card>();
    }
}
