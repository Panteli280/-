package com.company.service;

import com.company.model.Board;
import com.company.model.Card;
import com.company.model.Deck;
import com.company.model.Player;

import java.util.ArrayList;

import static com.company.model.STATUS.*;

public class Game {

    public static boolean Continue(Player hand1, Player hand2) {
        if (hand1.hand.size() == 0) return false;
        if (hand2.hand.size() == 0) return false;
        return true;
    }

    public static boolean ifCanDoIt(Player player, Board boards) {
        for (int i = 0; i < player.hand.size(); i++) {
            for (int j = 0; j < boards.board.size(); j++) {
                if (player.hand.get(i).getRank() == boards.board.get(j).getRank()) {
                    boards.defBoard.add(player.hand.get(i));
                    put(player.hand, boards.board, i);
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

    public static int compare(ArrayList<Card> defBoard, Card card) {
        for (int index = 0; index < defBoard.size(); index++) {
            if ((card.getRank().getValue() > defBoard.get(index).getRank().getValue()) && (card.getSuit() == defBoard.get(index).getSuit())) {
                return index;
            }
        }
        return -1;
    }

    public static void resetStatus(Player attacker, Player defender){
        attacker.status = ATTACK;
        defender.status = DEFEND;
    }

    public static void getAdditionalCards(Player player1, Player player2, Deck deck) {
            while ((player1.hand.size() < 6) && (deck.index != deck.getSizeOfDeck()))
                player1.hand.add(deck.drawFromDeck());
            while ((player2.hand.size() < 6) && (deck.index != deck.getSizeOfDeck()))
                player2.hand.add(deck.drawFromDeck());

    }

    public static void pass(Player player) {
        player.status = PASS;
    }
    public static void changeStatus(Player player) {
        player.status = ACTIV;
    }
}
