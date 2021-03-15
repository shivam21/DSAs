package dynamicProgramming;

/*
Given a n*m matrix which contains only 0s and 1s, find out the size of maximum square sub-matrix with all 0s. You need to return the size of square with all 0s.
*/

public class FindMaxSquareWithAllZeros {

    public static int findMaxSquareWithAllZeros(int[][] input) {
        int m = input.length;
        int n = input[0].length;
        int[][] storage = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            storage[i][0] = (input[i][0] == 0) ? 1 : 0;
            max = Math.max(max, storage[i][0]);
        }
        for (int i = 0; i < n; i++) {
            storage[0][i] = (input[0][i] == 0) ? 1 : 0;
            max = Math.max(max, storage[0][i]);
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (input[i][j] == 0) {
                    storage[i][j] = Math.min(storage[i - 1][j - 1], Math.min(storage[i - 1][j], storage[i][j - 1])) + 1;
                    max = Math.max(max, storage[i][j]);
                }
            }
        }
        return max;
    }


}
