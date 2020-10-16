package dynamicProgramming;

import java.util.Arrays;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 100;
        long[] arr = new long[n + 1];
        Arrays.fill(arr, -1);
        long result = fib(n, arr);
        System.out.println(result);
        System.out.println(fibDP(n));

    }

    private static long fib(int n, long[] storage) {
        if (n == 0 || n == 1) {
            storage[n] = n;
            return n;
        }
        if (storage[n] != -1)
            return storage[n];
        storage[n] = fib(n - 1, storage) + fib(n - 2, storage);
        return storage[n];
    }

    private static long fibDP(int n) {
        long[] storage = new long[n + 1];
        storage[0] = 0;
        storage[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            storage[i] = storage[i - 1] + storage[i - 2];
        }
        return storage[n];
    }


}
