package graphs;

import java.util.Scanner;

//Given a graph with N vertices (numbered from 1 to N) and Two Lists (U,V) of size M where
// (U[i],V[i]) and (V[i],U[i]) are connected by an edge , then count the distinct 3-cycles in the graph.
// A 3-cycle PQR is a cycle in which (P,Q), (Q,R) and (R,P) are connected an edge.


public interface ThreeCycle {
    public static int[] u = new int[5005];
    public static int[] v = new int[5005];

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n, m;
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        m = scan.nextInt();
        for (int i = 0; i < m; i++) {
            u[i] = scan.nextInt();
        }
        for (int i = 0; i < m; i++) {
            v[i] = scan.nextInt();
        }
        System.out.println(solve(n, m, u, v));
    }

    public static int solve(int n, int m, int U[], int V[]) {
        int[][] edges = new int[n][n];
        for (int i = 0; i < m; i++) {
            edges[U[i]][V[i]] = 1;
            edges[V[i]][U[i]] = 1;
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (edges[i][j] == 1) {
                    for (int k = 0; k < n; k++) {
                        if (edges[j][k] == 1 && edges[i][k] == 1) {
                            count++;
                        }
                    }
                }
            }
        }
        return count / 6;
    }
}
