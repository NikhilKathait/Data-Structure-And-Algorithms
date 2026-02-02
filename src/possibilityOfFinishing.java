import java.util.*;

public class possibilityOfFinishing {
    public int solve(int A, int[] B, int[] C) {

        // Adjacency list (1-based indexing)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[A + 1];

        // Build graph
        for (int i = 0; i < B.length; i++) {
            int u = B[i];
            int v = C[i];
            adj.get(u).add(v);
            indegree[v]++;
        }

        // Queue for nodes with indegree 0
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= A; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        int completed = 0;

        while (!q.isEmpty()) {
            int node = q.poll();
            completed++;

            for (int next : adj.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        // If all courses completed = no cycle
        return completed == A ? 1 : 0;
    }
}
