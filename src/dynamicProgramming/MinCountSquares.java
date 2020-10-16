package dynamicProgramming;

public class MinCountSquares {

    public static int minCountRecusrsive(int n) {
        if (n <= 0)
            return 0;
        if (n == 1)
            return 1;
        int minCount = Integer.MAX_VALUE;
        for (int i = 0; i * i < n; i++) {
            minCount = Math.min(minCount, 1 + minCountRecusrsive(n - i * i));
        }
        return minCount;
    }

    public static int minCount(int n) {
        int[] arr = new int[n + 1];
        arr[0] = 0;
        arr[1] = 1;
        for (int i = 2; i * i < n; i++) {
            int minCount = Integer.MAX_VALUE;
            for (int j = 1; j * j < n; j++) {
                minCount = Math.min(minCount, 1 + minCountRecusrsive(i - j * j));
            }
            arr[i] = minCount;
        }
        return arr[n];
    }


}
