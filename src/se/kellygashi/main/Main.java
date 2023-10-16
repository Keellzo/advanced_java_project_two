package se.kellygashi.main;

import se.kellygashi.board.Board;
import se.kellygashi.game_logic.GameLogic;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Board rootBoard = new Board();
        Scanner scanner = new Scanner(System.in);

        GameLogic gameLogic = new GameLogic(rootBoard, scanner);
        gameLogic.startGame();

        scanner.close();
    }
}