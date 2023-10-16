package se.kellygashi.board;

/**
 * This interface is a base example for my teacher and is now modified for my solution
 * This interface is meant to be implemented by se.kellygashi.board class
 * it holds methods used in se.kellygashi.board manipulation
 */

public interface BoardOperations {

    /**
     * Initializing the 3x3 se.kellygashi.board with empty cells
     */
    void initializeBoard();


    /**
     * Checking if location row/column on the se.kellygashi.board is valid
     * If the cell is already taken or not
     *
     * @param row, row of the se.kellygashi.board
     * @param col, column of the se.kellygashi.board
     * @return true if the cell is empty, else false
     */
    boolean isValidMove(int row, int col);

    /**
     * Used after checking if move is valid.
     * If move is valid, then placing X or O is permissible
     *
     * @param mark, "X" or "O"
     * @param row,  row of the se.kellygashi.board
     * @param col,  column of the se.kellygashi.board
     */
    void placeMark(String mark, int row, int col);

    /**
     * Method returns the winner depending on who won, "X" or "O"
     *
     * @return isXWinner or isOWinner
     */
    boolean isWinner();


    /**
     * Checks if it is a draw
     * returns 0 empty cells, fulfilling condition for draw
     *
     * @return 0 empty cells
     */
    boolean isDraw();


    /**
     * Method checking rows, columns and diagonals for winner
     *
     * @param mark, used for "X" or "O"
     * @return true if there is rows, columns or diagonals with same mark, else false
     */
    boolean checkWinner(String mark);


    /**
     * Checks if only X is the winner, and then being used in isWinner
     *
     * @return checkWinner method with the mark "X"
     */
    boolean isXWinner();

    /**
     * Checks if only O is the winner, and then being used in isWinner
     *
     * @return checkWinner method with the mark "O"
     */
    boolean isOWinner();

    /**
     * Creates a deep copy of the current se.kellygashi.board to preserve its state.
     *
     * @return A new se.kellygashi.board.Board object with the same state as the current se.kellygashi.board.
     */
    Board copyBoard();

    /**
     * Prints se.kellygashi.board to the console.
     * Looping through the 2D array, and checks the condition for every cell
     */
    void printBoard();


    /**
     * Evaluates the se.kellygashi.board state and returns a score.
     * This method checks for winners. 'X' is considered positive and 'O' is considered negative.
     *
     * @param board The se.kellygashi.board state to evaluate.
     * @return 10 if 'X' wins, -10 if 'O' wins, 0 otherwise.
     */
    int evaluateBoard(Board board);


}
