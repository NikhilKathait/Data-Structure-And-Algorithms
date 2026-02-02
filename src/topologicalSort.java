import java.util.*;

public class topologicalSort {
    public int[] solve(int A, int[][] B) {
        // Adjacency list (1-based indexing)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[A + 1];

        // Build graph
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            indegree[v]++;
        }

        // Min-heap for lexicographically smallest order
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i = 1; i <= A; i++) {
            if (indegree[i] == 0) {
                pq.add(i);
            }
        }

        int[] topo = new int[A];
        int idx = 0;

        while (!pq.isEmpty()) {
            int node = pq.poll();
            topo[idx++] = node;

            for (int next : adj.get(node)) {
                indegree[next]--;
                if (indegree[next] == 0) {
                    pq.add(next);
                }
            }
        }

        // If cycle exists
        if (idx != A) {
            return new int[0];
        }

        return topo;
    }
}
