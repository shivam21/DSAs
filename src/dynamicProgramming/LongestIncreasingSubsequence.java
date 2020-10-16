package dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public static int lis2(int arr[]) {
        return lis(arr, 0, Integer.MIN_VALUE);
    }

    private static int lis(int[] arr, int i, int minValue) {
        if (i >= arr.length)
            return 0;

        if (arr[i] > minValue) {
            int opt1 = 1 + lis(arr, i + 1, arr[i]);
            int opt2 = lis(arr, i + 1, minValue);
            return Math.max(opt1, opt2);
        }
        return lis(arr, i + 1, minValue);
    }


    public static int lis(int arr[]) {
        int[] storage = new int[arr.length + 1];
        Arrays.fill(storage, -1);
        return lisM(arr, 0, storage.length - 1, storage);
    }

    private static int lisM(int[] arr, int i, int minValueIndex, int[] storage) {
        if (i >= arr.length)
            return 0;

        if (minValueIndex != storage.length - 1 && storage[minValueIndex] != -1)
            return storage[minValueIndex];
        if (minValueIndex == storage.length - 1 || arr[i] > arr[minValueIndex]) {
            int opt1 = 1 + lisM(arr, i + 1, i, storage);
            int opt2 = lisM(arr, i + 1, minValueIndex, storage);
            storage[minValueIndex] = Math.max(opt1, opt2);
        } else {
            storage[minValueIndex] = lisM(arr, i + 1, minValueIndex, storage);
        }
        return storage[minValueIndex];
    }

    public static int lisDP(int arr[]) {
        int[] storage = new int[arr.length + 1];
        storage[arr.length] = 0;
        int result=0;
        for (int minValueIndex = arr.length - 1; minValueIndex >= 0; minValueIndex--) {
            int nextMax = 0;
            for (int i = minValueIndex + 1; i < arr.length; i++) {
                if (arr[i] > arr[minValueIndex]) {
                    nextMax = Math.max(nextMax,storage[i]);
                }
            }
            storage[minValueIndex] = 1 + nextMax;
            result=Math.max(result,storage[minValueIndex]);
        }
        return result;
    }
    
}
