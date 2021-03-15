package backtracking;

import java.util.Scanner;

public class RatInAMaze {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int maze[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = s.nextInt();
            }
        }
        System.out.println(ratInAMaze(maze));
    }


    public static boolean ratInAMaze(int maze[][]) {
        boolean[][] visited = new boolean[maze.length][maze.length];
        return ratInAMaze(maze, 0, 0, visited);
    }

    private static boolean ratInAMaze(int[][] maze, int i, int j, boolean[][] visited) {
        if (i == maze.length - 1 && j == maze.length - 1)
            return true;
        visited[i][j] = true;
        int[] xDirections = {1, 0, -1, 0};
        int[] yDirections = {0, 1, 0, -1};
        boolean result = false;
        for (int k = 0; k < 4; k++) {
            int x = i + xDirections[k];
            int y = j + yDirections[k];
            if (isValid(x, y, maze.length) && maze[x][y] == 1 && !visited[x][y]) {
                result = result || ratInAMaze(maze, x, y, visited);
            }
        }
        return result;
    }

    private static boolean isValid(int x, int y, int length) {
        return x > -1 && y > -1 && x < length && y < length;
    }
}
