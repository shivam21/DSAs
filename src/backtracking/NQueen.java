package backtracking;

import java.util.Scanner;

public class NQueen {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        placeNQueens(n);
    }

    public static void placeNQueens(int n) {
        int[][] board = new int[n][n];
        placeNQueens(n, 0, board);

    }

    private static void placeNQueens(int n, int row, int[][] board) {
        if (row == n) {
            printResult(board);
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValidPosition(board, row, col)) {
                board[row][col] = 1;
                placeNQueens(n, row + 1, board);
                board[row][col] = 0;
            }
        }
    }

    private static boolean isValidPosition(int[][] board, int row, int col) {
        for (int[] ints : board) {
            if (ints[col] == 1)
                return false;
        }
        int myRow = row;
        int myCol = col;
        while (row >= 0 && col >= 0) {
            if (board[row--][col--] == 1)
                return false;
        }
        while (myRow >= 0 && myCol < board.length) {
            if (board[myRow--][myCol++] == 1)
                return false;
        }
        return true;
    }

    private static void printResult(int[][] board) {
        for (int[] a : board)
            for (int b : a) {
                System.out.print(b + " ");
            }
        System.out.println();
    }
}
