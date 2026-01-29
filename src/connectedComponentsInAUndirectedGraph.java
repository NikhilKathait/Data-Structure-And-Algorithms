import java.util.*;

public class connectedComponentsInAUndirectedGraph {
    public int[][] getComponents(int A, int[][] B) {

        // Build adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i=0; i<A; i++){
            adj.add(new ArrayList<>());
        }

        // Undirected graph, add both ways
        for (int i=0; i < B.length; i++) {
            int u = B[i][0];
            int v = B[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] vis = new boolean[A];
        ArrayList<ArrayList<Integer>> components = new ArrayList<>();

        // Find connected components
        for (int i = 0; i < A; i++) {
            if (!vis[i]) {
                ArrayList<Integer> comp = new ArrayList<>();
                dfs(i, adj, vis, comp);
                Collections.sort(comp);
                components.add(comp);
            }
        }

        // Sort components by first element
        components.sort((a, b) -> a.get(0) - b.get(0));

        // Convert to int[][]
        int[][] result = new int[components.size()][];

        for (int i = 0; i < components.size(); i++) {
            ArrayList<Integer> comp = components.get(i);
            result[i] = new int[comp.size()];
            for (int j = 0; j < comp.size(); j++) {
                result[i][j] = comp.get(j);
            }
        }

        return result;
    }

    private void dfs(int node,
                     ArrayList<ArrayList<Integer>> adj,
                     boolean[] vis,
                     ArrayList<Integer> comp) {

        vis[node] = true;
        comp.add(node);

        for (int nbr : adj.get(node)) {
            if (!vis[nbr]) {
                dfs(nbr, adj, vis, comp);
            }
        }
    }
}
