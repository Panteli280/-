package com.company.service;

import com.company.model.*;

import java.util.ArrayList;

public class Game {



    public static boolean Continue(Creation game) {
        if (game.hands.handA.size() == 0) return false;
        if (game.hands.handB.size() == 0) return false;
        return true;
    }

    public static boolean ifCanDoIt(Card card, ArrayList<Card> board) {
         if (board.size() == 0){
            return true;
        } else
            for (int j = 0; j < board.size(); j++) {
                if (card.getRank() == board.get(j).getRank()) {
                    return true;
                }
        }
        System.out.println("Incorrect input, try again");
        return false;
    }

    public static boolean oneMoreCard(Players player, ArrayList<Card> board) {
        for (int i = 0; i < player.handA.size(); i++) {
            for (int j = 0; j < board.size(); j++) {
                if (player.handA.get(i).getRank() == board.get(j).getRank()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static int compare(Card card, ArrayList<Card> defBoard, SUIT trump) {
        int index;
        for (index = 0; index < defBoard.size(); index++) {
            if  ((card.getSuit() == trump)&&(defBoard.get(index).getSuit() != trump)||
                    (card.getRank().getValue() > defBoard.get(index).getRank().getValue() &&
                    (card.getSuit() == defBoard.get(index).getSuit()))) {
                return index;
            }
        }
        System.out.println("Incorrect input, try again");
        return index = -1;
    }

    public static void put(ArrayList<Card> from, ArrayList<Card> to, int choice) {
        to.add(from.get(choice));
        from.remove(choice);
    }

    public static void getAdditionalCards() {
        while ((Creation.hands.handA.size() < 6) && (Creation.deck.index != Creation.deck.getSizeOfDeck()))
            Creation.hands.handA.add(Creation.deck.drawFromDeck());
        while ((Creation.hands.handB.size() < 6) && (Creation.deck.index != Creation.deck.getSizeOfDeck()))
            Creation.hands.handB.add(Creation.deck.drawFromDeck());
    }

    public static void losing(Players player, Board boards) {
        for (int j = 0; j <= boards.board.size(); j++) {
            put(boards.board, player.handB, 0);
        }
        boards.defBoard.clear();
    }

    public static boolean pass(int command, Creation game) {
        if ((command == -1) && (Creation.boards.defBoard.size() == 0)) {
            game.boards.board.clear();
            Game.getAdditionalCards();
            game.status = STATUS.DTOA;
            return true;
        }
        return false;
    }

    public static void changeStatus(Creation game) {
        ArrayList<Card> handSwitcher = game.hands.handA;
        Creation.hands.handA = Creation.hands.handB;
        Creation.hands.handB = handSwitcher;

        String nameSwitcher = game.hands.nameA;
        game.hands.nameA = game.hands.nameB;
        game.hands.nameB = nameSwitcher;
        game.status = STATUS.ATOD;
    }
}
