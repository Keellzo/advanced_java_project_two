package se.kellygashi.minmax;

/**
 * Class for storing the evaluation value and position of the best move determined by the min-max algorithm
 */
public class BestMove {
    public int value;
    public int row;
    public int col;

    BestMove(int value, int row, int col) {
        this.value = value;
        this.row = row;
        this.col = col;
    }
}
