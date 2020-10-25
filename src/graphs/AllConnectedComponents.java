package graphs;

import java.util.*;

public class AllConnectedComponents {

    public static void main(String[] args) {
        int[][] edges = takeInput();
        ArrayList<ArrayList<Integer>> list = getConnectedComponents(edges);
        StringBuilder stringBuilder = new StringBuilder();
        for (ArrayList<Integer> component : list) {
            for (int i : component) {
                stringBuilder.append(i).append(" ");
            }
            stringBuilder.append("\n");
        }
        System.out.println(stringBuilder);
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

    private static ArrayList<ArrayList<Integer>> getConnectedComponents(int[][] edges) {
        ArrayList<ArrayList<Integer>> connectedComponents = new ArrayList<>();
        boolean[] visited = new boolean[edges.length];
        for (int i = 0; i < visited.length; i++) {
            if (!visited[i]) {
                connectedComponents.add(getConnectedComponent(edges, i, visited));
            }
        }
        return connectedComponents;
    }

    private static ArrayList<Integer> getConnectedComponent(int[][] edges, int sv, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> component = new ArrayList<>();
        queue.add(sv);
        visited[sv] = true;
        while (!queue.isEmpty()) {
            Integer element = queue.poll();
            component.add(element);
            for (int i = 0; i < edges.length; i++) {
                if (edges[element][i] == 1 && !visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
        Collections.sort(component);
        return component;
    }
}
