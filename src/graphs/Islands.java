package graphs;

import java.util.Scanner;

public class Islands {


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
        boolean[] visited = new boolean[n+1];
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (!visited[i]) {
                traverse(U, V, i, visited);
                count++;
            }
        }
        return count;
    }

    private static void traverse(int[] u, int[] v, int source, boolean[] visited) {
        visited[source] = true;
        for (int i = 0; i < u.length; i++) {
            if (u[i] == source && !visited[v[i]]) {
                traverse(u, v, v[i], visited);
            }
            if (v[i] == source && !visited[u[i]]) {
                traverse(u, v, u[i], visited);
            }
        }
    }
}
