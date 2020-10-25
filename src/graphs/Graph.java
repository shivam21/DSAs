package graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Graph {


    public static void main(String[] args) {
        int[][] edges = takeInput();
        printGraphBFS(edges);
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

    private static void printGraphDFS(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                printHelperDFS(edges, i, visited);
        }
    }

    private static void printHelperDFS(int[][] edges, int sv, boolean[] visited) {
        System.out.println(sv);
        visited[sv] = true;
        for (int j = 0; j < edges.length; j++) {
            if (edges[sv][j] == 1 && !visited[j]) {
                printHelperDFS(edges, j, visited);
            }
        }
    }

    private static void printGraphBFS(int[][] edges) {
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i])
                printHelperBFS(edges, i, visited);
        }
    }

    private static void printHelperBFS(int[][] edges, int sv, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sv);
        visited[sv] = true;
        while (!queue.isEmpty()) {
            int element = queue.poll();
            System.out.println(element);
            for (int i = 0; i < edges.length; i++) {
                if (edges[element][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}
