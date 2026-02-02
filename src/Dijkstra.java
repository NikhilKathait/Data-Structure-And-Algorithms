import java.util.*;

public class Dijkstra {
    public int[] solve(int A, int[][] B, int C) {
        // Adjacency list: node == {neighbor, weight}
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
        dist[C] = 0;

        // Min-heap: {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (a, b) -> Integer.compare(a[0], b[0])
        );

        pq.add(new int[] {0, C});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currDist = curr[0];
            int node = curr[1];

            // Skip outdated entries
            if (currDist > dist[node]) continue;

            for (int[] next : adj.get(node)) {
                int nei = next[0];
                int w = next[1];

                if (dist[node] + w < dist[nei]) {
                    dist[nei] = dist[node] + w;
                    pq.add(new int[] {dist[nei], nei});
                }
            }
        }

        // Convert unreachable nodes to -1
        for (int i = 0; i < A; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
    }
}
