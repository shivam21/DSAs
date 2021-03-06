package graphs;

import java.util.Scanner;

/*Its Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's .
But Gary wants the biggest piece of '1's and no '0's .
A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with eachother on
the cake. Given the size of cake N and the cake , can you find the size of the biggest piece of '1's for Gary ?*/


public class LargestPiece {
    public static String[] cake = new String[55];

    public static void main(String[] args) {
        int n, m;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        scan.nextLine();
        for (int i = 0; i < n; i++) {
            cake[i] = scan.nextLine();
        }
        System.out.println(solve(n, cake));
    }

    private static int solve(int n, String[] cake) {
        boolean[][] visited = new boolean[n][cake[0].length()];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            String s = cake[i];
            for (int j = 0; j < s.length(); j++) {
                if (s.charAt(j) == '1' && !visited[i][j]) {
                    max = Math.max(max, getCount(cake, visited, i, j, n));
                }
            }
        }
        return max;
    }

    private static int getCount(String[] cake, boolean[][] visited, int i, int j, int n) {
        int count = 1;
        visited[i][j] = true;
        if (isValid(i + 1, j, cake, n) && cake[i + 1].charAt(j) == '1' && !visited[i + 1][j]) {
            count += getCount(cake, visited, i + 1, j, n);
        }
        if (isValid(i, j + 1, cake, n) && cake[i].charAt(j + 1) == '1' && !visited[i][j + 1]) {
            count += getCount(cake, visited, i, j + 1, n);
        }
        if (isValid(i + 1, j + 1, cake, n) && cake[i + 1].charAt(j + 1) == '1' && !visited[i + 1][j + 1]) {
            count += getCount(cake, visited, i + 1, j + 1, n);
        }
        if (isValid(i - 1, j, cake, n) && cake[i - 1].charAt(j) == '1' && !visited[i - 1][j]) {
            count += getCount(cake, visited, i - 1, j, n);
        }
        if (isValid(i, j - 1, cake, n) && cake[i].charAt(j - 1) == '1' && !visited[i][j - 1]) {
            count += getCount(cake, visited, i, j - 1, n);
        }
        if (isValid(i - 1, j - 1, cake, n) && cake[i - 1].charAt(j - 1) == '1' && !visited[i - 1][j - 1]) {
            count += getCount(cake, visited, i - 1, j - 1, n);
        }
        if (isValid(i + 1, j - 1, cake, n) && cake[i + 1].charAt(j - 1) == '1' && !visited[i + 1][j - 1]) {
            count += getCount(cake, visited, i + 1, j - 1, n);
        }
        if (isValid(i - 1, j + 1, cake, n) && cake[i - 1].charAt(j + 1) == '1' && !visited[i - 1][j + 1]) {
            count += getCount(cake, visited, i - 1, j + 1, n);
        }

        return count;
    }

    private static boolean isValid(int i, int j, String[] cake, int n) {
        return i < n && j < cake[0].length() && i > -1 && j > -1;
    }
}
