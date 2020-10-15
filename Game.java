package com.company.service;

import com.company.model.*;

import java.util.ArrayList;

public class Game {

    public static void showCardsInHand(Player player) {
        System.out.println("\nCards of player #" + player.getStatus() + ": ");
        for (Card c : player.hand) {
            System.out.println(c.toString() + "; ");
        }
    }

    public static boolean Continue(Creation game) {
        if (game.handA.hand.size() == 0) return false;
        if (game.handB.hand.size() == 0) return false;
        return true;
    }

    public static boolean ifCanDoIt(Player player, ArrayList<Card> board) {
        for (int i = 0; i < player.hand.size(); i++) {
            for (int j = 0; j < board.size(); j++) {
                if (player.hand.get(i).getRank() == board.get(j).getRank()) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void put(ArrayList<Card> from, ArrayList<Card> to, int choice) {
        to.add(from.get(choice));
        from.remove(choice);
    }

    public static void compare(Card card, ArrayList<Card> defBoard) {
        int index;
        for (index = 0; index < defBoard.size(); index++) {
            if ((card.getRank().getValue() > defBoard.get(index).getRank().getValue()) && (card.getSuit() == defBoard.get(index).getSuit())) {
                defBoard.remove(index);
                break;
            }
        }
        if (index == defBoard.size())
            System.out.println("Too weak");
    }

    public static void changeStatus(Creation game) {
        game.handA.hand = game.hand;
        Creation.handB.hand = Creation.handA.hand;
        Creation.hand = Creation.handB.hand;
    }

    public static void getAdditionalCards() {
        while ((Creation.handA.hand.size() < 6) && (Creation.deck.index != Creation.deck.getSizeOfDeck()))
            Creation.handA.hand.add(Creation.deck.drawFromDeck());
        while ((Creation.handB.hand.size() < 6) && (Creation.deck.index != Creation.deck.getSizeOfDeck()))
            Creation.handB.hand.add(Creation.deck.drawFromDeck());
    }

    public static void losing(Player player, Board boards) {
        for (int j = 0; j <= boards.board.size(); j++) {
            put(boards.board, player.hand, 0);
        }
        boards.defBoard.clear();
    }

    public static boolean pass(int command, Creation game) {
        if ((command == -1) && (Creation.boards.defBoard.size() == 0)) {
            Game.getAdditionalCards();
            game.handA.status = STATUS.DEFENDER;
            game.handB.status = STATUS.ATTACKER;
            return true;
        }
        return false;
    }

    public static void showCardsOnBoard() {
        System.out.println("\nCards board : ");
        for (Card c : Creation.boards.board) {
            System.out.println(c.toString() + "; ");
        }
    }

    public static void showCardsOnDefBoard() {
        System.out.println("\nCards defBoard : ");
        for (Card c : Creation.boards.defBoard) {
            System.out.println(c.toString() + "; ");
        }
    }
}
