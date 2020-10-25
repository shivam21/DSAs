package graphs;

import java.util.Scanner;

public class PrimsAlgorithm {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        int[][] edges = new int[V][V];
        for (int i = 0; i < E; i++) {
            int j = s.nextInt();
            int k = s.nextInt();
            int w = s.nextInt();
            edges[j][k] = w;
            edges[k][j] = w;
        }
        int[] parent = new int[V];
        int[] weight = new int[V];
        boolean[] visited = new boolean[V];
        for (int i = 1; i < V; i++) {
            weight[i] = Integer.MAX_VALUE;
        }
        int source = 0;
        for (int k = 0; k < V; k++) {
            visited[source] = true;
            for (int j = 0; j < V; j++) {
                if (edges[source][j] != 0 && !visited[j]) {
                    if (weight[j] > edges[source][j]) {
                        weight[j] = edges[source][j];
                        parent[j] = source;
                    }
                }
            }
            source = findMinWeightVertex(weight, visited);
        }
        for (int i = 1; i < V; i++) {
            System.out.println(Math.min(i, parent[i]) + " " + Math.max(i, parent[i]) + " " + weight[i]);
        }

    }

    private static int findMinWeightVertex(int[] weight, boolean[] visited) {
        int minWeightVertices = -1;
        for (int i = 0; i < weight.length; i++) {
            if (!visited[i] && (minWeightVertices == -1 || weight[i] < weight[minWeightVertices])) {
                minWeightVertices = i;
            }
        }
        return minWeightVertices;
    }
}
