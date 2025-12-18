public class leastCommonAncestor {
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

    public int lca(TreeNode A, int B, int C) {
        if (A == null) return -1;

        TreeNode lcaNode = findLCA(A, B, C);

        // Verify both nodes exist
        if (exists(lcaNode, B) && exists(lcaNode, C)) {
            return lcaNode.val;
        }

        return -1;
    }

    private TreeNode findLCA(TreeNode root, int B, int C) {
        if (root == null) return null;

        if (root.val == B || root.val == C)
            return root;

        TreeNode left = findLCA(root.left, B, C);
        TreeNode right = findLCA(root.right, B, C);

        if (left != null && right != null)
            return root;

        return left != null ? left : right;
    }

    private boolean exists(TreeNode root, int val) {
        if (root == null) return false;
        if (root.val == val) return true;
        return exists(root.left, val) || exists(root.right, val);
    }
}
