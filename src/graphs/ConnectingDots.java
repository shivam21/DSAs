package graphs;

import java.util.Scanner;

public class ConnectingDots {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int N, M, i;

        N = scan.nextInt();
        M = scan.nextInt();

        String[] board = new String[N];

        for (i = 0; i < N; i++) {

            board[i] = scan.next();

        }
        System.out.println(solve(board, N, M));

    }

    static int solve(String[] Graph, int N, int M) {
        boolean result = false;
        boolean[] chars = new boolean[26];
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < Graph[i].length(); j++) {
                if (!visited[i][j]) {
                    result = result || (hasCycle(Graph, -1, -1, i, j, visited) == 1);
                }
            }
        }
        return result ? 1 : 0;
    }

    static int hasCycle(String[] board, int fromX, int fromY, int i, int j, boolean[][] visited) {
        if (visited[i][j])
            return 1;
        int[] X_dir = {1, 0, 0, -1};
        int[] Y_dir = {0, 1, -1, 0};
        visited[i][j] = true;
        for (int l = 0; l < X_dir.length; l++) {
            int x = X_dir[l] + i;
            int y = Y_dir[l] + j;
            if (x == fromX && y == fromY) {
                continue;
            }

            if (x >= 0 && y >= 0 && x < board.length && y < board[x].length() && board[x].charAt(y) == board[i].charAt(j)) {

                int ans = hasCycle(board, i, j, x, y, visited);
                if (ans == 1) {
                    return 1;
                }

            }

        }
        return 0;
    }
}

