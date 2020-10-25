package graphs;

import java.util.Scanner;

public class HasPath {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] edges = takeInput(s);
        int sv = s.nextInt();
        int ev = s.nextInt();
        System.out.println(hasPath(edges, sv, ev));
    }

    private static int[][] takeInput(Scanner s) {
        int n = s.nextInt();
        int e = s.nextInt();
        int[][] edges = new int[n][n];
        for (int i = 0; i < e; i++) {
            int sv = s.nextInt();
            int eV = s.nextInt();
            edges[sv][eV] = 1;
            edges[eV][sv] = 1;
        }
        return edges;
    }

    private static boolean hasPath(int[][] edges, int sv, int ev) {
        boolean[] visited = new boolean[edges.length];
        return traverse(edges, sv, ev, visited);

    }

    private static boolean traverse(int[][] edges, int sv, int ev, boolean[] visited) {
        visited[sv] = true;
        boolean result = false;
        for (int i = 0; i < edges.length; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                if (i == ev)
                    return true;
                result = result || traverse(edges, i, ev, visited);
            }
        }
        return result;
    }

}
