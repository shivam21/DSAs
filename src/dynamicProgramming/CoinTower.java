package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class CoinTower {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
        String[] strNums = br.readLine().trim().split("\\s");
        int n = Integer.parseInt(strNums[0]);
        int x = Integer.parseInt(strNums[1]);
        int y = Integer.parseInt(strNums[2]);

        System.out.println(findWinner(n, x, y));
    }

    public static String findWinnerR(int n, int x, int y) {
        int[][] storage = new int[2][n + 1];
        boolean result = isBeerusWin(n, x, y, true, storage);
        if (!result) {
            return "Whis";
        }
        return "Beerus";
    }

    private static boolean isBeerusWin(int n, int x, int y, boolean isBeerusTurn, int[][] storage) {
        if (n <= 0) {
            return !isBeerusTurn;
        }
        if (isBeerusTurn && storage[0][n] != 0) {
            return storage[0][n] == 1;
        }
        if (!isBeerusTurn && storage[1][n] != 0) {
            return storage[1][n] == 1;
        }
        boolean opt1 = isBeerusWin(n - 1, x, y, !isBeerusTurn, storage);
        boolean opt2 = isBeerusWin(n - x, x, y, !isBeerusTurn, storage);
        boolean opt3 = isBeerusWin(n - y, x, y, !isBeerusTurn, storage);
        boolean isBeerusWin;
        if (isBeerusTurn)
            isBeerusWin = opt1 || opt2 || opt3;
        else
            isBeerusWin = opt1 && opt2 && opt3;
        if (isBeerusTurn) {
            if (isBeerusWin)
                storage[0][n] = 1;
            else
                storage[0][n] = 2;
        } else {
            if (isBeerusWin)
                storage[1][n] = 1;
            else
                storage[1][n] = 2;
        }
        return isBeerusWin;
    }

    public static String findWinner(int n, int x, int y) {
        int[][] storage = new int[2][n + 1];
        storage[0][0] = 2;
        storage[0][1] = 1;
        for (int j = 1; j < storage[0].length; j++) {
            for (int i = 0; i < 2; i++) {
                if (i == 0) {
                    boolean opt1 = storage[1][j - 1] == 1;
                    boolean opt2=true;
                    if (j - x > 0)
                        opt2 = storage[1][j - x] == 1;
                    boolean opt3= true;
                    if (j - y > 0)
                        opt3 = storage[1][j - y] == 1;
                    boolean result = opt1 || opt2 || opt3;
                    if (result) {
                        storage[i][j] = 1;
                    } else {
                        storage[i][j] = 2;
                    }
                } else {
                    boolean opt1 = storage[0][j - 1] == 1;
                    boolean opt2=false;
                    if (j - x > 0)
                        opt2 = storage[0][j - x] == 1;
                    boolean opt3=false;
                    if (j - y > 0)
                        opt3 = storage[0][j - y] == 1;
                    boolean result = opt1 && opt2 && opt3;
                    if (result) {
                        storage[i][j] = 1;
                    } else {
                        storage[i][j] = 2;
                    }
                }
            }
        }

        boolean result = storage[0][storage[0].length - 1] == 1;
        if (!result) {
            return "Whis";
        }
        return "Beerus";
    }


}
