package se.kellygashi.minmax;

import se.kellygashi.board.Board;

public class MinMax {

    public static BestMove minMax(Board board, int depth, boolean isMaximizing) {
        final int MAX_DEPTH = 9;

        if (depth == MAX_DEPTH || board.isWinner() || board.isDraw()) {
            return new BestMove(board.evaluateBoard(board), -1, -1);
        }

        int bestValue = isMaximizing ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        int bestRow = -1;
        int bestCol = -1;

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board.isValidMove(i, j)) {
                    Board childBoard = board.copyBoard();
                    childBoard.placeMark(isMaximizing ? "X" : "O", i, j);

                    BestMove currentMove = minMax(childBoard, depth + 1, !isMaximizing);
                    if(isMaximizing && currentMove.value > bestValue){
                        bestValue = currentMove.value;
                        bestRow = i;
                        bestCol = j;
                    } else if (!isMaximizing && currentMove.value < bestValue) {
                        bestValue = currentMove.value;
                        bestRow = i;
                        bestCol = j;
                    }
                }
            }
        }
        return new BestMove(bestValue, bestRow, bestCol);
    }
}
