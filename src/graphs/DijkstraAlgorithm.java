package graphs;

import java.util.Scanner;

public class DijkstraAlgorithm {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int[][] edges = new int[V][V];
        for (int i = 0; i < E; i++) {
            int sv = s.nextInt();
            int ev = s.nextInt();
            int w = s.nextInt();
            edges[sv][ev] = w;
            edges[ev][sv] = w;
        }
        boolean[] visited = new boolean[V];
        int[] distances = new int[V];
        for (int i = 1; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i < V; i++) {
            int source = findMinimumVertex(distances, visited);
            visited[source] = true;
            for (int j = 0; j < edges.length; j++) {
                if (edges[source][j] != 0 && !visited[j]) {
                    int distance = distances[source] + edges[source][j];
                    if (distance < distances[j]) {
                        distances[j] = distance;
                    }
                }
            }
        }
        for (int i = 0; i < distances.length; i++) {
            System.out.println(i + " " + distances[i]);
        }
    }

    private static int findMinimumVertex(int[] distances, boolean[] visited) {
        int minVertex = -1;
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i] && (minVertex == -1 || distances[i] < distances[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }
}
