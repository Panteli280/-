package com.company.view;

import com.company.model.Board;
import com.company.model.Deck;
import com.company.model.Player;
import com.company.service.Game;


import java.util.Random;
import java.util.Scanner;

import static com.company.model.STATUS.*;
import static com.company.service.Game.*;

public class GameView {
    private final static Game game = new Game();
    private final static Scanner scan = new Scanner(System.in);

    public void Start() {
        Deck deck = new Deck();

        Board boards = new Board();

        Player hand1 = new Player(deck);
        Player hand2 = new Player(deck);

        Random rnd = new Random();
        int i = rnd.nextInt(2);
        if (hand1.getId() == i)
            hand1.status = ATTACK;
        else hand2.status = ATTACK;

        do {
            if (hand1.status == ATTACK) turn(hand1, hand2, boards);
            else turn(hand2, hand1, boards);
            if (hand1.status == ATTACK) getAdditionalCards(hand1, hand2, deck);
            else getAdditionalCards(hand2, hand1, deck);
        } while (Continue(hand1, hand2));
        if (hand1.hand.size() == 0)  System.out.println("\nPlayer #" + hand1.getId() + " is winner");
        else  System.out.println("\nPlayer #" + hand2.getId() + " is winner");
    }

    public static void turn(Player attacker, Player defender, Board boards) {
        attacker.showCardsInHand();
        boards.showCardsOnBoard();
        addCard(attacker, boards);
        while (boards.board.size() != 0) {
            resetStatus(attacker, defender);
            while (attacker.status != PASS) {
                attacker.showCardsInHand();
                boards.showCardsOnBoard();
                addCard(attacker, boards);
            }
            while ((defender.status != PASS) && (boards.defBoard.size() != 0)) {
                defender.showCardsInHand();
                boards.showCardsOnDefBoard();
                defCard(defender, boards);
            }
        }
        if (defender.status != PASS) resetStatus(defender, attacker);
        else resetStatus(attacker, defender);
    }

    static void addCard(Player player, Board boards) {
        if (boards.board.size() == 0) {
            System.out.println("\nPlayer #" + player.getId() + " Choose a card");

            int choice = scan.nextInt() - 1;

            boards.defBoard.add(player.hand.get(choice));
            put(player.hand, boards.board, choice);
        } else {
            if (player.status != ACTIV) {
                System.out.println("\nPlayer #" + player.getId()
                        + " Continue or pass? Enter 'C'ontinue or 'P'ass");

                String userAnswer = scan.next();

                switch (userAnswer.toUpperCase()) {

                    case "C":
                        System.out.println("Choose a card");
                        int choice = scan.nextInt() - 1;
                        for (int i = 0; i < boards.board.size(); i++) {
                            if (player.hand.get(choice).getRank() == boards.board.get(i).getRank()) {
                                boards.defBoard.add(player.hand.get(choice));
                                put(player.hand, boards.board, choice);
                                changeStatus(player);
                                break;
                            }
                            if (i == boards.board.size()) {
                                System.out.println("Incorrect input. Try again.");
                                addCard(player, boards);
                            }
                        }
                        break;

                    case "P":
                        boards.board.clear();
                        pass(player);
                        break;

                    default:
                        System.out.println("Incorrect input. Try again.");
                        addCard(player, boards);
                }
            } else if (!ifCanDoIt(player, boards)) {
                pass(player);
            } else {
                System.out.println("\nPlayer #" + player.getId()
                        + " Put one more card or enter. Enter 'C'ard or 'E'nter");

                String userAnswer = scan.next();

                switch (userAnswer.toUpperCase()) {

                    case "C":
                        System.out.println("Choose a card");
                        int choice = scan.nextInt() - 1;
                        for (int i = 0; i < boards.board.size(); i++) {
                            if (player.hand.get(choice).getRank() == boards.board.get(i).getRank()) {
                                boards.defBoard.add(player.hand.get(choice));
                                put(player.hand, boards.board, choice);
                                break;
                            }
                            if (i == boards.board.size()) {
                                System.out.println("Incorrect input. Try again.");
                                addCard(player, boards);
                            }
                        }
                        break;

                    case "E":
                        pass(player);
                        break;

                    default:
                        System.out.println("Incorrect input. Try again.");
                        addCard(player, boards);
                }
            }
        }
    }

    static void defCard(Player player, Board boards) {
        System.out.println("\nPlayer #" + player.getId()
                + " Do you want to defend? 'Y'es or 'N'o");

        String userAnswer = scan.next();

        switch (userAnswer.toUpperCase()) {

            case "Y":
                System.out.println("Choose a card");

                int choice = scan.nextInt()-1;

                 while (boards.board.size() != 0) {
                    int index = compare(boards.defBoard, player.hand.get(choice));
                    if (index != -1) {
                        boards.defBoard.remove(index);
                        put(player.hand, boards.board, choice);
                        break;
                    }
                }
                break;

            case "N":
                for (int j = 0; j <= boards.board.size(); j++) {
                    put(boards.board, player.hand, 0);
                }
                boards.defBoard.clear();
                pass(player);
                break;

            default:
                System.out.println("Incorrect input. Try again.");
                defCard(player, boards);
        }
    }
}



