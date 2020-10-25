package graphs;

import java.util.Scanner;

public class PrintPathDFS {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] edges = takeInput(s);
        int sv = s.nextInt();
        int ev = s.nextInt();
        printPathDFS(edges, sv, ev);
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

    private static void printPathDFS(int[][] edges, int sv, int ev) {
        boolean[] visited = new boolean[edges.length];
        traverseAndPrint(edges, ev, sv, visited);
    }

    private static void traverseAndPrint(int[][] edges, int sv, int ev, boolean[] visited) {
        System.out.print(sv + " ");
        for (int i = 0; i < edges.length; i++) {
            if (edges[sv][i] == 1 && !visited[i]) {
                if (i == ev) {
                    System.out.print(ev);
                    return;
                }
                traverseAndPrint(edges, sv, ev, visited);
            }

        }
    }
}
