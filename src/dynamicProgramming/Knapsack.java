package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/*
A thief robbing a store and can carry a maximal weight of W into his knapsack. There are N items and ith item weigh wi and is of value vi. What is the maximum value V, that thief can take ?
*/

public class Knapsack {

    public static int knapsackRecursive(int[] weight, int value[], int maxWeight, int n) {
        return knapsackRecursive(weight, value, maxWeight, n, 0, 0);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[] weight = new int[n];
        for (int i = 0; i < n; i++) {
            weight[i] = s.nextInt();
        }
        int[] value = new int[n];
        for (int i = 0; i < n; i++) {
            value[i] = s.nextInt();
        }
        int maxWeight = s.nextInt();
        System.out.println(knapsack(weight, value, maxWeight));
    }

    private static int knapsackRecursive(int[] weight, int[] value, int maxWeight, int n, int i, int maxValue) {
        if (i >= n)
            return maxValue;

        if (weight[i] <= maxWeight) {
            return Math.max(knapsackRecursive(weight, value, maxWeight - weight[i], n, i + 1, maxValue + value[i]), knapsackRecursive(weight, value, maxWeight, n, i + 1, maxValue));
        } else {
            return knapsackRecursive(weight, value, maxWeight, n, i + 1, maxValue);
        }
    }

    public static int knapsack(int[] weight, int[] value, int maxWeight) {
        int n = weight.length;
        int[][] arr = new int[n + 1][maxWeight + 1];
        for (int[] ints : arr) {
            Arrays.fill(ints, -1);
        }
        int result = knapsackM(weight, value, maxWeight, n, 0, arr);
        printArray(arr);
        return result;
    }

    private static int knapsackDP(int[] weight, int[] value, int maxWeight) {
        int n = weight.length;
        int[][] arr = new int[2][maxWeight + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < arr[0].length; j++) {
                int result;
                if (weight[i] <= j) {
                    result = Math.max(value[i] + arr[0][j - weight[i]], arr[0][j]);
                } else {
                    result = arr[0][j];
                }
                arr[1][j] = result;
            }
            System.arraycopy(arr[1], 0, arr[0], 0, arr[0].length);
        }
        return arr[1][maxWeight];
    }


    private static int knapsackM(int[] weight, int[] value, int maxWeight, int n, int i, int[][] arr) {
        if (i >= n)
            return 0;
        if (arr[i + 1][maxWeight] != -1)
            return arr[i + 1][maxWeight];
        int result;
        if (weight[i] <= maxWeight) {
            result = Math.max(value[i] + knapsackM(weight, value, maxWeight - weight[i], n, i + 1, arr), knapsackM(weight, value, maxWeight, n, i + 1, arr));
        } else {
            result = knapsackM(weight, value, maxWeight, n, i + 1, arr);
        }
        arr[i + 1][maxWeight] = result;
        return result;
    }

    private static void printArray(int[][] arr) {
        for (int[] ints : arr) {
            System.out.println(Arrays.toString(ints));
        }
        System.out.println();
        System.out.println();
    }

}
