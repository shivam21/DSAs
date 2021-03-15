package dynamicProgramming;

import java.util.Scanner;

/*Given two integers a and b. You need to find and return the count of possible ways in which we can represent the number a as the sum of unique integers raise to the power b.
        For eg. if a = 10 and b = 2, only way to represent 10 as -
        10 = 1^2 + 3^2
        Hence, answer is 1.*/

public class AllWays {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int x = s.nextInt();
        int n = s.nextInt();
        System.out.println(allWays(x, n));
    }

    public static int allWays(int x, int n) {
        int c = (int) Math.pow(x, 1f / n);
        return allWays(x, n, 1, c, 0);
    }

    private static int allWays(int x, int n, int i, int max, int sum) {
        if (i > max) {
            if (sum == x) {
                return 1;
            } else {
                return 0;
            }
        }
        int count1 = allWays(x, n, i + 1, max, sum + (int) Math.pow(i, n));
        int count2 = allWays(x, n, i + 1, max, sum);
        return count1 + count2;
    }

}
