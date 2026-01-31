import java.util.*;

public class rottenOranges {
    class pair {
        int i, j, time;
        pair(int x, int y, int t) {
            i=x; j=y; time=t;
        }
    }

    public int solve(int[][] A) {
        int mintime = 0, fresh = 0;
        Queue<pair> q = new LinkedList<>();

        for (int i=0; i<A.length; i++) {
            for (int j = 0; j<A[0].length; j++) {
                if (A[i][j] == 1)
                    fresh++;
                else if (A[i][j] == 2)
                    q.offer(new pair(i, j, 0));
            }
        }

        int[] dr = new int[] {-1, 0, 1, 0};
        int[] dc = new int[] {0, -1, 0, 1};

        while (q.size() > 0) {
            pair rem = q.poll();
            mintime = rem.time;

            for (int d=0; d<4; d++) {
                int nr = rem.i + dr[d];
                int nc = rem.j + dc[d];

                if (nr >= 0 && nr < A.length && nc >= 0
                        && nc < A[0].length && A[nr][nc] == 1) {
                    A[nr][nc] = 2;
                    q.offer(new pair(nr, nc, rem.time + 1));
                    fresh--;
                }
            }
        }

        if (fresh == 0) return mintime;

        return -1;
    }
}
