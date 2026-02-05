import java.util.*;

public class shortestDistanceInAMaze {
    public int solve(int[][] A, int[] B, int[] C) {
        int n = A.length;
        int m = A[0].length;
        int[] rows = new int[] {0, -1, 0, 1};
        int[] cols = new int[] {-1, 0, 1, 0};
        int[][] dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = Integer.MAX_VALUE;
            }
        }

        int srcx = B[0], srcy = B[1], destx = C[0], desty = C[1];

        dist[srcx][srcy] = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {srcx, srcy, 0});

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int x = curr[0];
            int y = curr[1];
            int steps = curr[2];

            for (int k = 0; k < 4; k++) {
                int currx = x;
                int curry = y;
                int cnt = 0;

                while (currx + rows[k] >= 0 && currx + rows[k] < n &&
                        curry + cols[k] >= 0 && curry + cols[k] < m &&
                        A[currx + rows[k]][curry + cols[k]] == 0) {

                    currx += rows[k];
                    curry += cols[k];
                    cnt++;
                }
                int d = cnt + steps;

                if (d < dist[currx][curry]) {
                    dist[currx][curry] = d;
                    q.add(new int[]{currx, curry, d});
                }
            }
        }

        return dist[destx][desty] == Integer.MAX_VALUE ? -1 : dist[destx][desty];
    }
}
