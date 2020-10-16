package dynamicProgramming;

public class MinimumCostPath {

    public static int minCostPathRecursive(int input[][]) {
        return minCostPathRecursive(input, 0, 0);

    }

    private static int minCostPathRecursive(int[][] input, int i, int j) {
        if (i == input.length - 1 && j == input.length - 1)
            return input[i][j];
        if (i >= input.length || j >= input.length)
            return Integer.MAX_VALUE;
        return input[i][j] + Math.min(minCostPathRecursive(input, i + 1, j + 1), Math.min(minCostPathRecursive(input, i + 1, j), minCostPathRecursive(input, i, j + 1)));
    }

    private static int minCostPath(int[][] input) {
        int[][] arr = new int[input.length][input.length];
        arr[input.length - 1][input.length - 1] = input[input.length - 1][input.length - 1];
        for (int i = input.length - 1; i >= 0; i--) {
            for (int j = input[0].length; j >= 0; j--) {
                if (i == input.length - 1 && j == input.length - 1)
                    continue;
                arr[i][j] = input[i][j] + Math.min(getElement(arr, i + 1, j + 1), Math.min(getElement(arr, i + 1, j), getElement(arr, i, j + 1)));
            }
        }
        return arr[0][0];
    }

    private static int getElement(int[][] arr, int i, int j) {
        if (i >= arr.length || j >= arr.length)
            return Integer.MAX_VALUE;
        return arr[i][j];
    }


}
