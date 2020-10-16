package dynamicProgramming;

public class Staircase {

    public static long staircaseRecursive(int n) {
        if (n <= 2)
            return n;
        if (n == 3)
            return 4;
        long count1 = staircaseRecursive(n - 1);
        long count2 = staircaseRecursive(n - 2);
        long count3 = staircaseRecursive(n - 3);
        return count1 + count2 + count3;
    }

    public static long staircase(int n) {
        long[] arr = new long[n + 1];
        arr[0] = 0;
        if (n > 0)
            arr[1] = 1;
        if (n > 1)
            arr[2] = 2;
        if (n > 2)
            arr[3] = 4;
        for (int i = 4; i < arr.length; i++) {
            arr[i] = arr[i - 1] + arr[i - 2] + arr[i - 3];
        }
        return arr[n];
    }
}
