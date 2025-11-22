public class balancedBinaryTree {
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

    public class Solution {
        public int isBalanced(TreeNode A) {
            if (A == null) return 0;

            return isBalancedTree(A) != - 1 ? 1 : 0;
        }

        private int isBalancedTree(TreeNode node) {
            if (node == null) return 0;

            int left = isBalancedTree(node.left);
            int right = isBalancedTree(node.right);

            if(left == -1 || right == -1) return -1;
            if(Math.abs(left - right) > 1) return -1;

            return Math.max(left, right) + 1;
        }
    }
}
