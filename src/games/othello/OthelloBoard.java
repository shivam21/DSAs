package games.othello;

public class OthelloBoard {

    private int board[][];
    final static int player1Symbol = 1;
    final static int player2Symbol = 2;

    public OthelloBoard() {
        board = new int[8][8];
        board[3][3] = player1Symbol;
        board[3][4] = player2Symbol;
        board[4][3] = player2Symbol;
        board[4][4] = player1Symbol;
    }

    public void print() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean move(int symbol, int x, int y) {
        if (board[x][y] != 0)
            return false;
        int oppositeSymbol = (symbol == player1Symbol) ? player2Symbol : player1Symbol;
        int[] X_DIR = {1, 0, -1, 1, -1, 0, 1, -1};
        int[] Y_DIR = {0, 1, -1, 1, 0, -1, -1, 1};
        boolean result = false;
        for (int i = 0; i < X_DIR.length; i++) {
            int xStep = x + X_DIR[i];
            int yStep = y + Y_DIR[i];
            int count = 0;
            while (stepsValid(xStep, yStep) && board[xStep][yStep] == oppositeSymbol) {
                count++;
                xStep += X_DIR[i];
                yStep += Y_DIR[i];
            }
            if (count > 0 && board[xStep][yStep] == symbol) {
                board[x][y] = symbol;
                while (count-- > 0) {
                    xStep -= X_DIR[i];
                    yStep -= Y_DIR[i];
                    board[xStep][yStep] = symbol;
                }
                result = true;
            }
        }
        return result;
    }

    private boolean stepsValid(int i, int j) {
        return i > -1 && j > -1 && i < board.length && j < board[0].length;
    }
}

