package se.kellygashi.board;

import se.kellygashi.utils.Color;

public class Board implements BoardOperations {

    private final int SIZE = 3;
    private String[][] board;

    private int emptyCells;

    public Board() {
        board = new String[SIZE][SIZE];
        emptyCells = SIZE * SIZE;
        initializeBoard();
    }

    @Override
    public void initializeBoard() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                board[i][j] = "-";
            }
        }
    }

    @Override
    public boolean isValidMove(int row, int col) {
        return board[row][col].equals("-");
    }

    @Override
    public void placeMark(String mark, int row, int col) {
        board[row][col] = mark;
        emptyCells--;
    }

    @Override
    public boolean isWinner() {
        return isXWinner() || isOWinner();
    }

    @Override
    public boolean isDraw() {
        return emptyCells == 0;
    }

    @Override
    public boolean checkWinner(String mark) {
        for (int i = 0; i < SIZE; i++) {
            // check rows
            if (board[i][0].equals(mark) && board[i][1].equals(mark) && board[i][2].equals(mark)) {
                return true;
            }

            // check columns
            if (board[0][i].equals(mark) && board[1][i].equals(mark) && board[2][i].equals(mark)) {
                return true;
            }
        }

        // check diagonals
        if (board[0][0].equals(mark) && board[1][1].equals(mark) && board[2][2].equals(mark)) {
            return true;
        }
        if (board[0][2].equals(mark) && board[1][1].equals(mark) && board[2][0].equals(mark)){
            return true;
        }

        return false;
    }

    @Override
    public boolean isXWinner() {
        return checkWinner("X");
    }

    @Override
    public boolean isOWinner() {
        return checkWinner("O");
    }

    @Override
    public Board copyBoard() {
        Board newBoard = new Board();

        for (int i = 0; i < SIZE; i++){
            for (int j = 0; j < SIZE; j++){
                newBoard.board[i][j] = this.board[i][j];
            }
        }
        newBoard.emptyCells = this.emptyCells;

        return newBoard;
    }

    @Override
    public void printBoard() {
        System.out.println(Color.YELLOW + "==============");
        for (int i = 0; i < SIZE; i++) {
            System.out.print(Color.YELLOW + "| ");
            for (int j = 0; j < SIZE; j++) {
                if ("-".equals(board[i][j])) {
                    System.out.print(" ");
                } else if ("X".equals(board[i][j])) {
                    System.out.print(Color.BLUE + board[i][j]);
                } else if ("O".equals(board[i][j])) {
                    System.out.print(Color.RED + board[i][j]);
                }
                if (j < SIZE - 1) {
                    System.out.print(Color.YELLOW + " | ");
                }
            }
            System.out.println(Color.YELLOW + " |");
            if (i < SIZE - 1) {
                System.out.println(Color.YELLOW + " ------------");
            }
        }
        System.out.println(Color.YELLOW + "==============");
    }


    @Override
    public int evaluateBoard(Board board) {
        if (isXWinner()) {
            return 10;
        }
        if (isOWinner()) {
            return -10;
        }
        return 0;
    }


}
