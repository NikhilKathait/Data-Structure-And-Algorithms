import java.util.*;

public class commutableIslands {
    static class Pair {
        int node;
        int weight;
        Pair(int n, int w) {
            node = n;
            weight = w;
        }
    }


    public int solve(int A, int[][] B) {
        // Adjacency list (1-based indexing)
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] e : B) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        boolean[] visited = new boolean[A + 1];

        PriorityQueue<Pair> pq = new PriorityQueue<>(
                (a, b) -> a.weight - b.weight
        );

        // Start from island 1
        pq.offer(new Pair(1, 0));

        int totalCost = 0;
        int visitedCount = 0;

        while (!pq.isEmpty() && visitedCount < A) {
            Pair curr = pq.poll();

            if (visited[curr.node]) continue;

            visited[curr.node] = true;
            visitedCount++;
            totalCost += curr.weight;

            for (Pair nei : adj.get(curr.node)) {
                if (!visited[nei.node]) {
                    pq.offer(new Pair(nei.node, nei.weight));
                }
            }
        }

        return totalCost;
    }
}
