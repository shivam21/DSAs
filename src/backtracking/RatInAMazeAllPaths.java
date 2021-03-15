package backtracking;

import java.util.Scanner;

public class RatInAMazeAllPaths {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int maze[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = s.nextInt();
            }
        }
        ratInAMaze(maze);
    }

    public static void ratInAMaze(int maze[][]) {
        int[][] visited = new int[maze.length][maze.length];
        ratInAMaze(maze, 0, 0, visited);
    }

    private static void ratInAMaze(int[][] maze, int i, int j, int[][] visited) {
        visited[i][j] = 1;
        if (i == maze.length - 1 && j == maze.length - 1) {
            printResult(visited);
            return;
        }
        int[] xDirections = {1, 0, -1, 0};
        int[] yDirections = {0, 1, 0, -1};
        for (int k = 0; k < 4; k++) {
            int x = i + xDirections[k];
            int y = j + yDirections[k];
            if (isValid(x, y, maze.length) && maze[x][y] == 1 && visited[x][y] == 0) {
                ratInAMaze(maze, x, y, visited);
                visited[x][y] = 0;
            }
        }
    }

    private static void printResult(int[][] visited) {
        for (int[] a : visited)
            for (int b : a) {
                System.out.print(b + " ");
            }
        System.out.println();
    }

    private static boolean isValid(int x, int y, int length) {
        return x > -1 && y > -1 && x < length && y < length;
    }
}
