import java.util.*;

public class constructionCost {
    static class Pair {
        int node;
        long cost;
        Pair(int n, long c) {
            node = n;
            cost = c;
        }
    }

    public int solve(int A, int[][] B) {
        int MOD = 1000000007;

        // Adjacency list
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= A; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] e : B) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            adj.get(u).add(new Pair(v, w));
            adj.get(v).add(new Pair(u, w));
        }

        boolean[] visited = new boolean[A+1];

        PriorityQueue<Pair> pq = new PriorityQueue<> (
                (a, b) -> Long.compare(a.cost, b.cost)
        );

        // Start from node 1
        pq.offer(new Pair(1, 0));

        long totalCost = 0;

        while (!pq.isEmpty()) {
            Pair cur = pq.poll();

            if (visited[cur.node]) continue;

            visited[cur.node] = true;
            totalCost = (totalCost + cur.cost) % MOD;

            for (Pair nei : adj.get(cur.node)) {
                if (!visited[nei.node]) {
                    pq.offer(new Pair(nei.node, nei.cost));
                }
            }
        }

        return (int) totalCost;
    }
}
