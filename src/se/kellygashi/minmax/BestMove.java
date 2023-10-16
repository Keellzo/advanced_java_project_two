package se.kellygashi.minmax;

public class BestMove {
    public int value;
    public int row;
    public int col;

    BestMove(int value, int row, int col){
        this.value = value;
        this.row = row;
        this.col = col;
    }
}
