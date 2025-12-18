public class pathSumNodeToLeaf {
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

    public int hasPathSum(TreeNode A, int B) {
        if (A == null) return 0;

        return dfs(A,B) ? 1 : 0;
    }

    private boolean dfs(TreeNode node, int remainingSum) {
        if (node == null) return false;

        remainingSum -= node.val;

        // Check only at leaf
        if (node.left == null && node.right == null) {
            return remainingSum == 0;
        }

        return dfs(node.left, remainingSum) || dfs(node.right, remainingSum);
    }
}
