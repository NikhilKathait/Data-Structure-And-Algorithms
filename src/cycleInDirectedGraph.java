import java.util.*;

public class cycleInDirectedGraph {
    public int solve(int A, int[][] B) {
        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < A; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < B.length; i++) {
            int u = B[i][0] - 1;  // convert to 0-based index
            int v = B[i][1] - 1;
            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[A];
        boolean[] path = new boolean[A];

        // Check cycle in each component
        for (int i = 0; i < A; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, path)) {
                    return 1;
                }
            }
        }

        return 0;
    }

    private boolean dfs(int node, ArrayList<ArrayList<Integer>> adj,
                        boolean[] vis,
                        boolean[] path) {

        vis[node] = true;
        path[node] = true;

        for (int nbr : adj.get(node)) {
            // If node is already in current DFS path to cycle
            if (path[nbr]) return true;

            if (!vis[nbr]) {
                if (dfs(nbr, adj, vis, path)) return true;
            }
        }

        path[node] = false;     // backtrack
        return false;
    }
}
