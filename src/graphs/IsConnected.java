package graphs;

import java.util.Scanner;

public class IsConnected {

    public static void main(String[] args) {
        int[][] edges = takeInput();
        System.out.println(isConnected(edges));
    }

    private static int[][] takeInput() {
        Scanner s = new Scanner(System.in);
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

    private static boolean isConnected(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        traverse(edges, visited, 0);
        boolean isConnected = true;
        for (boolean b : visited) {
            isConnected = isConnected && b;
        }
        return isConnected;
    }

    private static void traverse(int[][] edges, boolean[] visited, int sv) {
        visited[sv] = true;
        for (int i = 0; i < edges.length; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                visited[i] = true;
                traverse(edges, visited, i);
            }
        }
    }
}
