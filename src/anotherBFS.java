import java.util.*;

public class anotherBFS {
    public int solve(int A, int[][] B, int C, int D) {
        // Adjacency list: node = (neighbor, weight)
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        // Undirected graph
        for (int[] edge : B) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];

            adj.get(u).add(new int[] {v, w});
            adj.get(v).add(new int[] {u, w});
        }

        int[] dist = new int[A];
        Arrays.fill(dist, Integer.MAX_VALUE);

        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(C);
        dist[C] = 0;

        while (!dq.isEmpty()) {
            int node = dq.pollFirst();

            for (int[] next : adj.get(node)) {
                int nei = next[0];
                int w = next[1];

                if (dist[node] + w < dist[nei]) {
                    dist[nei] = dist[node] + w;

                    if (w == 1) {
                        dq.addFirst(nei);
                    } else {    // w == 2
                        dq.addLast(nei);
                    }
                }
            }
        }

        return dist[D] == Integer.MAX_VALUE ? -1 : dist[D];
    }
}
