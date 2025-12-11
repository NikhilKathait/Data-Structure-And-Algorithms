import java.util.*;

public class shortestPathInBinaryMazeWithHurdles {
    public int FindShortestPath(ArrayList<ArrayList<Integer>> A, int B, int C, int D, int E) {
        int m = A.size();
        if (m == 0) return -1;
        int n = A.get(0).size();

        // visited matrix for backtracking
        boolean[][] visited = new boolean[m][n];

        // minimum distance found so far
        int[] minDist = new int[] {Integer.MAX_VALUE};

        // start DFS from source(B,C) with 0 steps
        dfs(A, B, C, D, E, visited, 0, minDist, m, n);

        return (minDist[0] == Integer.MAX_VALUE) ? -1 : minDist[0];
    }

    private void dfs(ArrayList<ArrayList<Integer>> A, int r, int c, int destR, int destC,
                     boolean[][] visited, int steps, int[] minDist, int m, int n)
    {
        // If out of bounds
        if (r < 0 || r >= m || c < 0 || c >= n) return;

        // If hurdle or already visited
        if (A.get(r).get(c) == 0 || visited[r][c]) return;

        // If current steps already >= best found minimum distance, leave this path
        if (steps >= minDist[0]) return;

        // If we reached destination, update minimum distance
        if (r == destR && c == destC) {
            minDist[0] = Math.min(minDist[0], steps);
            return;
        }

        // Mark current cell as visited
        visited[r][c] = true;

        // Explore all 4 directions
        // down
        dfs(A, r + 1, c, destR, destC, visited, steps + 1, minDist, m, n);

        // up
        dfs(A, r - 1, c, destR, destC, visited, steps + 1, minDist, m, n);

        // right
        dfs(A, r, c + 1, destR, destC, visited, steps + 1, minDist, m, n);

        // left
        dfs(A, r, c - 1, destR, destC, visited, steps + 1, minDist, m, n);

        // Backtrack: unmark current cell
        visited[r][c] = false;
    }
}
