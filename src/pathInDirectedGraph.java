import java.util.*;

public class pathInDirectedGraph {
    public int solve(int A, int[][] B) {
        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0] - 1;    // convert to 0-based index
            int v = B[i][1] - 1;
            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[A];

        // Check dfs from node 1
        return dfs(0, A - 1, adj, vis) ? 1 : 0;
    }

    private boolean dfs(int node, int target,
                        ArrayList<ArrayList<Integer>> adj,
                        boolean[] vis) {

        if (node == target) return true;

        vis[node] = true;

        for (int nbr : adj.get(node)) {

            if (!vis[nbr]) {
                if (dfs(nbr, target, adj, vis)) return true;
            }
        }

        return false;
    }
}
