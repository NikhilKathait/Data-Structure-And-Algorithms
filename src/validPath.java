import java.util.*;

public class validPath {
    public String solve(int A, int B, int C, int D, int[] E, int[] F) {
        boolean[][] blocked = new boolean[A + 1][B + 1];

        // Mark blocked cells due to circles
        for (int i = 0; i < C; i++) {
            int cx = E[i];
            int cy = F[i];

            for (int x = 0; x <= A; x++) {
                for (int y = 0; y <= B; y++) {
                    int dx = x - cx;
                    int dy = y - cy;

                    if (dx * dx + dy * dy <= D * D) {
                        blocked[x][y] = true;
                    }
                }
            }
        }

        // If start or end is blocked then impossible
        if (blocked[0][0] || blocked[A][B]) return "NO";

        // BFS
        boolean[][] visited = new boolean[A + 1][B + 1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0});
        visited[0][0] = true;

        int[] dx = {-1,-1,-1, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1,-1, 1,-1, 0, 1};

        while(!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0], y = curr[1];

            if (x == A && y == B) return "YES";

            for (int k = 0; k < 8; k++) {
                int nx = x + dx[k];
                int ny = y + dy[k];

                if (nx >= 0 && nx <= A &&
                        ny >= 0 && ny <= B &&
                        !blocked[nx][ny] &&
                        !visited[nx][ny]) {

                    visited[nx][ny] = true;
                    q.add(new int[] {nx, ny});
                }
            }
        }

        return "NO";
    }
}
