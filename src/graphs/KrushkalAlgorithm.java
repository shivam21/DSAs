package graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

class Edge {
    int sv;
    int ev;
    int w;

    public Edge(int sv, int ev, int w) {
        this.sv = sv;
        this.ev = ev;
        this.w = w;
    }
}

public class KrushkalAlgorithm {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int V = s.nextInt();
        int E = s.nextInt();
        Edge[] edges = new Edge[E];
        for (int i = 0; i < E; i++) {
            edges[i] = new Edge(s.nextInt(), s.nextInt(), s.nextInt());
        }
        Arrays.sort(edges, (edge1, edge2) -> {
            if (edge1.w < edge2.w) {
                return -1;
            } else if (edge1.w > edge2.w) {
                return 1;
            }
            return 0;
        });
        int[] parents = new int[V];
        for (int i = 0; i < V; i++) {
            parents[i] = i;
        }
        int count = 0;
        int index = 0;
        int resultIndex = 0;
        Edge[] result = new Edge[V - 1];
        while (count < V) {
            Edge currentEdge = edges[index];
            int parentV1 = currentEdge.sv;
            int parentV2 = currentEdge.ev;
            while (parents[parentV1] != parentV1) {
                parentV1 = parents[parentV1];
            }
            while (parents[parentV2] != parentV2) {
                parentV2 = parents[parentV2];
            }
            if (parentV1 != parentV2) {
                result[resultIndex++] = currentEdge;
                parents[parentV1] = parentV2;
                count++;
            }
            index++;
        }
        for (Edge e : result) {
            System.out.println(Math.min(e.ev,e.sv) + " " + Math.max(e.ev,e.sv)+ " " + e.w);
        }

    }
}
