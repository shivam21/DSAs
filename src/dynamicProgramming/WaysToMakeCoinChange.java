package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/*You are given an infinite supply of coins of each of denominations D = {D0, D1, D2, D3, ...... Dn-1}. You need to figure out the total number of ways W, in which you can make change for Value V using coins of denominations D.
        Note : Return 0, if change isn't possible.*/

public class WaysToMakeCoinChange {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner s = new Scanner(System.in);
        int numDenominations = s.nextInt();
        int denominations[] = new int[numDenominations];
        for (int i = 0; i < numDenominations; i++) {
            denominations[i] = s.nextInt();
        }

        int value = s.nextInt();

        System.out.println(countWaysToMakeChange(denominations, value));

    }


    public static int countWaysToMakeChange2(int denominations[], int value) {
        int[][] storage = new int[denominations.length][value + 1];
        for (int[] arr : storage)
            Arrays.fill(arr, -1);
        return countWaysToMakeChange(denominations, value, 0, storage);

    }

    private static int countWaysToMakeChange(int[] denominations, int value, int q, int[][] storage) {
        if (value == 0)
            return 1;
        if (value < 0)
            return 0;
        if (storage[q][value] != -1)
            return storage[q][value];
        int count = 0;
        for (int j = q, denominationsLength = denominations.length; j < denominationsLength; j++) {
            int i = denominations[j];
            count += countWaysToMakeChange(denominations, value - i, j, storage);
        }
        storage[q][value] = count;
        return count;
    }

    public static int countWaysToMakeChange(int denominations[], int value) {
        int[][] storage = new int[denominations.length][value + 1];
        for (int i = storage.length - 2; i >= 0; i--) {
            for (int j = 1; j < storage[0].length; j++) {
                int count = 0;
                for (int k = i; k < storage.length; k++) {
                    int coin = denominations[k];
                    if (j - coin == 0)
                        count += 1;
                    else if (j - coin > 0)
                        count += storage[k][j - coin];
                }
                storage[i][j] = count;
            }
        }
        return storage[0][storage[0].length - 1];
    }

}
