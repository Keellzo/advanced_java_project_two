package se.kellygashi.game_logic;

import se.kellygashi.board.Board;
import se.kellygashi.minmax.BestMove;
import se.kellygashi.minmax.MinMax;
import se.kellygashi.utils.Color;

import java.util.Scanner;

public class GameLogic {

    private final Board board;

    private final Scanner scanner;

    public GameLogic(Board board, Scanner scanner) {
        this.board = board;
        this.scanner = scanner;
    }

    public void startGame() {
        int depth = 0;
        boolean isPlayersTurn = true;

        System.out.println(Color.GREEN + "Enter your move for row (1-3) and column (1-3). Example input for center mid: \"2 2\" \n" +
                "You are \"X\" \n");

        while (!board.isWinner() && !board.isDraw()) {
            board.printBoard();

            if (isPlayersTurn) {
                handlePlayerTurn(depth);
            } else {
                handleBotTurn(depth);
            }

            isPlayersTurn = !isPlayersTurn;
        }

        board.printBoard();
        if (board.isWinner()) {
            System.out.println(isPlayersTurn ? Color.RED + "Bot wins!" : Color.BLUE + "You win!");
        } else {
            System.out.println(Color.PURPLE + "It's a draw!");
        }
    }

    private void handlePlayerTurn(int depth) {
        System.out.println(Color.BLUE + "----------------------");

        BestMove bestMove = MinMax.minMax(board, depth, true);
        System.out.println(Color.BLUE + "Suggested move: row " + (bestMove.row + 1) + ", col " + (bestMove.col + 1));

        System.out.print(Color.BLUE + "Enter:  \n");
        int row, col;
        do {
            row = scanner.nextInt() - 1;
            col = scanner.nextInt() - 1;
            System.out.println(Color.BLUE + "----------------------");
        } while (!board.isValidMove(row, col));

        board.placeMark("X", row, col);
    }

    private void handleBotTurn(int depth) {
        System.out.println(Color.RED + "----------------------");
        System.out.println(Color.RED + "Bot's turn");

        BestMove bestMove = MinMax.minMax(board, depth, false);
        System.out.println(Color.RED + "Bot chose \"" + (bestMove.row + 1) + " " + (bestMove.col + 1) + "\"");
        System.out.println(Color.RED + "----------------------");

        board.placeMark("O", bestMove.row, bestMove.col);
    }


}
