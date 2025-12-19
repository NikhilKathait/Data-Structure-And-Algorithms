public class distanceBetweenNodesOfBST {
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

    public int solve(TreeNode A, int B, int C) {
        TreeNode lca = findLCA(A, B, C);

        int d1 = distanceFromNode(lca, B);
        int d2 = distanceFromNode(lca, C);

        return d1 + d2;
    }

    private TreeNode findLCA(TreeNode root, int B, int C) {
        while (root != null) {
            if (B < root.val && C < root.val)
                root = root.left;
            else if (B > root.val && C > root.val)
                root = root.right;
            else
                return root;
        }
        return null;
    }

    private int distanceFromNode(TreeNode root, int val) {
        int dist = 0;
        while (root.val != val) {
            if (val < root.val)
                root = root.left;
            else
                root = root.right;
            dist++;
        }
        return dist;
    }
}
