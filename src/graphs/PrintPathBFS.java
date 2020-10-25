package graphs;

import java.util.*;

public class PrintPathBFS {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[][] edges = takeInput(s);
        int sv = s.nextInt();
        int ev = s.nextInt();
        printPathBFS(edges, sv, ev);
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

    private static void printPathBFS(int[][] edges, int sv, int ev) {
        boolean[] visited = new boolean[edges.length];
        HashMap<Integer, Integer> map = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sv);
        visited[sv] = true;
        while (!queue.isEmpty()) {
            int element = queue.poll();
            for (int i = 0; i < edges.length; i++) {
                if (edges[element][i] == 1 && !visited[i]) {
                    queue.add(i);
                    map.put(i, element);
                    visited[i] = true;
                    if (i == ev) {
                        printShortestPath(map, sv, ev);
                        return;
                    }
                }
            }
        }
    }

    private static void printShortestPath(HashMap<Integer, Integer> map, int sv, int ev) {
        StringBuilder path = new StringBuilder();
        path.append(ev).append(" ");
        while (map.get(ev) != sv) {
            path.append(map.get(ev)).append(" ");
            ev = map.get(ev);
        }
        path.append(sv);
        System.out.println(path);
    }


}
