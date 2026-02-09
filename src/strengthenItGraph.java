import java.util.*;

public class strengthenItGraph {
    static class DSU {
        int[] parent, size, edges;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];
            edges = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
                edges[i] = 0;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);
            if (pa == pb) {
                edges[pa]++;
                return;
            }

            parent[pb] = pa;
            size[pa] += size[pb];
            edges[pa] += edges[pb] + 1;
        }
    }

    public int solve(int A, int[][] B, int C) {
        DSU dsu = new DSU(A);

        for (int[] e : B) {
            dsu.union(e[0] - 1, e[1] - 1);
        }

        // collect components
        Map<Integer, int[]> map = new HashMap<>();
        for (int i = 0; i < A; i++) {
            int p = dsu.find(i);
            map.put(p, new int[]{dsu.size[p], dsu.edges[p]});
        }

        List<int[]> comps = new ArrayList<>(map.values());

        // sort by size descending
        comps.sort((a, b) -> b[0] - a[0]);

        int nodes = comps.get(0)[0];
        long edges = comps.get(0)[1];

        // merge components
        for (int i = 1; i < comps.size() && C>0; i++) {
            nodes += comps.get(i)[0];
            edges += comps.get(i)[1] + 1;
            C--; // one edge to connect
        }

        // densify
        long maxEdges = (long) nodes * (nodes - 1) / 2;
        long extra = Math.min(C, maxEdges - edges);

        return (int) (edges + extra);
    }
}
