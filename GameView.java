package com.company.view;

import com.company.model.Creation;
import com.company.service.Game;


import java.util.Scanner;

import static com.company.model.STATUS.ATTACKER;
import static com.company.model.STATUS.DEFENDER;
import static com.company.service.Game.*;

public class GameView {
    private final static Game game = new Game();
    private final static Scanner scan = new Scanner(System.in);

    public void Start() {
        Creation game = new Creation();
        Creation.handA.status = ATTACKER;
        int command;
        do {
            if (Creation.handA.status == DEFENDER){
                changeStatus(game);
            }
            game.handA.showCardsInHand();
            System.out.println("Choose your cards to attack:");
            System.out.println("Print '0', when you finish!");
            command = scan.nextInt()-1;
            do {
                Creation.boards.defBoard.add(Creation.handA.hand.get(command));
                put(Creation.handA.hand, Creation.boards.board, command);
                game.handA.showCardsInHand();
                game.boards.showCardsOnBoard();
                command = scan.nextInt()-1;
            } while ((ifCanDoIt(Creation.handA, Creation.boards.board, command))&&(command != -1));

            if (!Game.pass(command, game)) {
                game.handB.showCardsInHand();
                game.boards.showCardsOnDefBoard();
                System.out.println("Choose your cards to defend:");
                System.out.println("Print '0', when you finish!");
                command = scan.nextInt() - 1;
                while ((Creation.boards.defBoard.size() != 0) && (command != -1)) {
                    Game.compare(Creation.handB.hand.get(command), Creation.boards.defBoard);
                    put(Creation.handB.hand, Creation.boards.board, command);
                    game.handB.showCardsInHand();
                    game.boards.showCardsOnDefBoard();
                    command = scan.nextInt() - 1;
                }
                if (command == -1) {
                    losing(Creation.handB, Creation.boards);
                    Game.getAdditionalCards();
                }
            }
        } while (Continue(game));
    }
}
