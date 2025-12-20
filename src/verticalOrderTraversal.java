import java.util.*;

public class verticalOrderTraversal {
    // Definition for binary tree
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
            left=null;
            right=null;
        }
    }

    static class Pair {
        TreeNode node;
        int col;

        Pair(TreeNode n, int c) {
            node = n;
            col = c;
        }
    }

    public int[][] verticalOrderTraversal(TreeNode A) {
        if (A == null) return new int[0][0];

        // TreeMap to maintain vertical order
        TreeMap<Integer, List<Integer>> map = new TreeMap<>();

        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(A, 0));

        while (!q.isEmpty()) {
            Pair curr = q.poll();
            TreeNode node = curr.node;
            int col = curr.col;

            map.putIfAbsent(col, new ArrayList<>());
            map.get(col).add(node.val);

            if (node.left != null) {
                q.offer(new Pair(node.left, col - 1));
            }

            if (node.right != null) {
                q.offer(new Pair(node.right, col + 1));
            }
        }

        // build result
        int[][] result = new int[map.size()][];
        int i = 0;
        for (List<Integer> list : map.values()) {
            int[] arr = new int[list.size()];

            for (int j = 0; j < list.size(); j++) {
                arr[j] = list.get(j);
            }

            result[i++] = arr;
        }

        return result;
    }
}
