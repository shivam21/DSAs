package dynamicProgramming;

import java.util.Arrays;
import java.util.Scanner;

/*
Given a chain of matrices A1, A2, A3,.....An, you have to figure out the most efficient way to multiply these matrices i.e. determine where to place parentheses to minimise the number of multiplications.
        You will be given an array p[] of size n + 1. Dimension of matrix Ai is p[i - 1]*p[i]. You need to find minimum number of multiplications needed to multiply the chain.
*/

public class MatrixChainMultiplication {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);

        int n = s.nextInt();
        int p[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            p[i] = s.nextInt();
        }
        System.out.println(mcm(p));
    }

    public static int mcmR(int[] p) {
        int[][] storage = new int[p.length][p.length];
        for (int[] a : storage)
            Arrays.fill(a, -1);
        return mcm(p, 0, p.length - 1, storage);
    }

    private static int mcm(int[] p, int start, int end, int[][] storage) {
        if (start >= end - 1) {
            return 0;
        }
        if (storage[start][end] != -1)
            return storage[start][end];
        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < end; i++) {
            min = Math.min(min, (mcm(p, start, i, storage) + mcm(p, i, end, storage) + p[start] * p[i] * p[end]));
        }
        storage[start][end] = min;
        return min;
    }

    public static int mcm(int[] p) {
        int[][] storage = new int[p.length][p.length];
        for (int start = storage.length - 2; start >= 0; start--) {
            for (int end = start + 2; end < storage.length; end++) {
                int min = Integer.MAX_VALUE;
                for (int i = start + 1; i < end; i++) {
                    min = Math.min(min, storage[start][i] + storage[i][end] + p[start] * p[i] * p[end]);
                }
                storage[start][end] = min;
            }
        }
        return storage[0][p.length - 1];
    }

}
