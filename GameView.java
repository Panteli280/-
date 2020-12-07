package com.company.view;

import com.company.model.Creation;
import com.company.model.STATUS;
import com.company.service.Game;


import java.util.Scanner;

import static com.company.service.Game.*;

public class GameView {
    private final static Game game = new Game();
    private final static Scanner scan = new Scanner(System.in);

    public void Start() {
        Creation game = new Creation();
        int command;

        do {
            System.out.println("The Trump is: " + game.trump);
            if (game.status == STATUS.DTOA){
                changeStatus(game);
            }
            game.hands.showCardsInHandA();
            game.boards.showCardsOnBoard();
            System.out.println("Choose your cards to attack:");
            System.out.println("Print '0', when you finish!");
            command = scan.nextInt()-1;
            while (command != -1) {
                if (ifCanDoIt(Creation.hands.handA.get(command), Creation.boards.board)) {
                    Creation.boards.defBoard.add(Creation.hands.handA.get(command));
                    put(Creation.hands.handA, Creation.boards.board, command);
                }
                if (oneMoreCard(Creation.hands, Creation.boards.board)){
                    game.hands.showCardsInHandA();
                    game.boards.showCardsOnBoard();
                    command = scan.nextInt()-1;
                } else {
                    break;
                }
            }

            if (!Game.pass(command, game)) {
                game.hands.showCardsInHandB();
                game.boards.showCardsOnDefBoard();
                System.out.println("Choose your cards to defend:");
                System.out.println("Print '0', when you finish!");
                command = scan.nextInt() - 1;
                while (command != -1) {
                    int result = compare(Creation.hands.handB.get(command), Creation.boards.board, game.trump);
                    if (result != -1){
                        Creation.boards.defBoard.remove(result);
                        put(Creation.hands.handB, Creation.boards.board, command);
                    }
                    if (Creation.boards.defBoard.size() != 0){
                        game.hands.showCardsInHandB();
                        game.boards.showCardsOnDefBoard();
                        command = scan.nextInt() - 1;
                    } else {
                        break;
                    }
                }
                if (game.boards.defBoard.size() != 0) {
                    losing(Creation.hands, Creation.boards);
                    Game.getAdditionalCards();
                }
            }
        } while (Continue(game));
    }
}
