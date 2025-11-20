public class subBinaryTreeOrNot {
    // Definition for binary tree
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }

    public class Solution {
        public int solve(TreeNode A) {
            return helper(A) != -1 ? 1 : 0;
        }

        private int helper(TreeNode node) {
            if (node == null) return 0;

            // leaf node, valid sum tree, return its value
            if (node.left == null && node.right == null)
                return node.val;

            int left = helper(node.left);
            int right = helper(node.right);

            if (left == -1 || right == -1) return -1;

            if (node.val != left + right) return -1;

            return node.val + left + right;
        }
    }
}
