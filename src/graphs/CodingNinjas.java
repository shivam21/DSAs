package graphs;

import java.util.Arrays;
import java.util.Scanner;

/*
Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .
        There is a path from any cell to all its neighbouring cells. A neighbour may share an edge or a corner.
*/

public class CodingNinjas {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N, M, i;

        N = scan.nextInt();
        M = scan.nextInt();

        String[] Graph = new String[N];

        for (i = 0; i < N; i++) {

            Graph[i] = scan.next();

        }
        System.out.println(solve(Graph, N, M));

    }

    static int solve(String[] Graph, int N, int M) {
        boolean result = false;
        for (int i = 0; i < N; i++) {
            String[] columns = Graph[i].split("");
            for (int j = 0; j < columns.length; j++) {
                if (columns[j].equals("C")) {
                    result = result || solve(Graph, N, M, "ODINGNINJA", i, j, new boolean[N][M]);
                }
            }
        }
        return result ? 1 : 0;
    }

    private static boolean solve(String[] graph, int n, int m, String str, int i, int j, boolean[][] visited) {
        if(str.isEmpty())
            return true;
        boolean opt1 = false, opt2 = false, opt3 = false, opt4 = false, opt5 = false, opt6 = false, opt7 = false, opt8 = false;
        char c = str.charAt(0);
        visited[i][j] = true;
        if (i > 0 && j > 0 && graph[i - 1].charAt(j - 1) == c && !visited[i - 1][j - 1]) {
            opt1 = solve(graph, n, m, str.substring(1), i - 1, j - 1, visited);
        }
        if (i > 0 && graph[i - 1].charAt(j) == c && !visited[i - 1][j]) {
            opt2 = solve(graph, n, m, str.substring(1), i - 1, j, visited);
        }
        if (i > 0 && j + 1 < m && graph[i - 1].charAt(j + 1) == c && !visited[i - 1][j + 1]) {
            opt3 = solve(graph, n, m, str.substring(1), i - 1, j + 1, visited);
        }
        if (j + 1 < m && graph[i].charAt(j + 1) == c && !visited[i][j + 1]) {
            opt4 = solve(graph, n, m, str.substring(1), i - 1, j + 1, visited);
        }
        if ((i + 1) < n && (j + 1) < m && graph[i + 1].charAt(j + 1) == c && !visited[i + 1][j + 1]) {
            opt5 = solve(graph, n, m, str.substring(1), i + 1, j + 1, visited);
        }
        if ((i + 1) < n && graph[i + 1].charAt(j) == c && !visited[i + 1][j]) {
            opt6 = solve(graph, n, m, str.substring(1), i + 1, j, visited);
        }
        if ((i + 1) < n && j > 0 && graph[i + 1].charAt(j - 1) == c && !visited[i + 1][j - 1]) {
            opt7 = solve(graph, n, m, str.substring(1), i + 1, j - 1, visited);
        }
        if (j > 0 && graph[i].charAt(j - 1) == c && !visited[i][j - 1]) {
            opt8 = solve(graph, n, m, str.substring(1), i + 1, j - 1, visited);
        }
        return opt1 || opt2 || opt3 || opt4 || opt5 || opt6 || opt7 || opt8;
    }


}
