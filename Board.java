package com.company.model;

import java.util.ArrayList;

public class Board {

    public ArrayList<Card> board;
    public ArrayList<Card> defBoard;

    public Board(){
        this.board = new ArrayList<Card>();
        this.defBoard = new ArrayList<Card>();
    }

    public void showCardsOnBoard() {
        System.out.println("\nCards board : ");
        for (Card c : this.board) {
            System.out.println(c.toString() + "; ");
        }
    }

    public void showCardsOnDefBoard() {
        System.out.println("\nCards defBoard : ");
        for (Card c : this.defBoard) {
            System.out.println(c.toString() + "; ");
        }
    }
}
