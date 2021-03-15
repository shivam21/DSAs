package games.tictactoe;

import java.util.Scanner;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter Player1  name");
        String player1 = s.nextLine();
        System.out.println("Enter Player1  symbol");
        String sym1 = s.nextLine();
        System.out.println("Enter Player2  name");
        String player2 = s.nextLine();
        System.out.println("Enter Player2  symbol");
        String sym2 = s.nextLine();
        String[][] board = new String[3][3];
        boolean isPlayer1Turn = true;
        Player myPlayer1 = new Player(player1, sym1);
        Player myPlayer2 = new Player(player2, sym2);
        int count = 0;
        int boardSize = 9;
        while (!isSomeoneWins(board) && count < boardSize) {
            int i = s.nextInt();
            int j = s.nextInt();
            if (isValidMove(board, i, j)) {
                board[i][j] = (isPlayer1Turn) ? sym1 : sym2;
                isPlayer1Turn = !isPlayer1Turn;
                printBoard(board);
                count++;
            } else {
                System.out.println("Invalid move");
            }
        }
        System.out.println((isPlayer1Turn) ? player2 + " Wins" : player1 + " Wins");
    }

    private static boolean isValidMove(String[][] board, int i, int j) {
        return i > -1 && j > -1 && i < board.length && j < board[0].length;
    }

    private static void printBoard(String[][] board) {
        for (String[] strings : board) {
            for (String string : strings) {
                System.out.print("|" + string + "|");
            }
            System.out.println();
        }
    }

    private static boolean isSomeoneWins(String[][] board) {
        boolean result = false;
        boolean[][] visited = new boolean[3][3];
        for (int j = 0; j < board[0].length; j++) {
            if (!visited[0][j]) {
                result = result || isSomeoneWins(board, 0, j, visited, board[0][j]);
            }
        }
        for (int i = 0; i < board.length; i++) {
            if (!visited[0][0]) {
                result = result || isSomeoneWins(board, i, 0, visited, board[i][0]);
            }
        }
        return result;
    }

    private static boolean isSomeoneWins(String[][] board, int i, int j, boolean[][] visited, String symbol) {
        visited[i][j] = true;
        int[] X_DIR = {1, 0, 1};
        int[] Y_DIR = {0, 1, 1};
        for (int k = 0; k < 3; k++) {
            int x = i + X_DIR[k];
            int y = j + Y_DIR[k];
            if (isValidMove(board, x, y) && board[x][y].equals(symbol)) {
                return isSomeoneWins(board, x, y, visited, symbol);
            }
        }
        return false;
    }
}
