package dynamicProgramming;

import java.util.Scanner;

public class BalancedTreesOfHeightH {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int height = s.nextInt();
        System.out.println(balancedTreesOfHeightHRecursive(height));
    }

    public static long balancedTreesOfHeightHRecursive(int height) {
        if (height <= 1)
            return height;
        if (height == 2)
            return 3;
        long count1 = balancedTreesOfHeightHRecursive(height - 1) % 1000000007;
        long count2 = balancedTreesOfHeightHRecursive(height - 2) % 1000000007;
        return (((2 * count1 * count2) % 1000000007) + ((count1 * count1) % 1000000007)) % 1000000007;
    }

    public static long balancedTreesOfHeightH(int height) {
        long[] arr = new long[height + 1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 3;
        for (int i = 3; i < arr.length; i++) {
            long count1 = arr[i - 1] % 1000000007;
            long count2 = arr[i - 2] % 1000000007;
            arr[i] = (((2 * count1 * count2) % 1000000007) + ((count1 * count1) % 1000000007)) % 1000000007;
        }
        return arr[height];
    }


}
