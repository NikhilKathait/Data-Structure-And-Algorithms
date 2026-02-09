import java.util.*;

public class magicalBridge {
    public int solve(int[] A) {
        int n = A.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(0);
        visited[0] = true;
        int steps = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            while (size-- > 0) {
                int i = q.poll();

                // If we cross the bridge
                if (i >= n) return steps;

                // normal move
                if (i+1 < n && !visited[i + 1]) {
                    visited[i + 1] = true;
                    q.offer(i + 1);
                }

                // magical move
                int jump = i + A[i];
                if (jump >= n) return steps + 1;

                if (!visited[jump]) {
                    visited[jump] = true;
                    q.offer(jump);
                }
            }
            steps++;
        }

        return -1;
    }
}
