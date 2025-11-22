public class equalTreePartition {
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
        private long total = 0;
        private boolean possible = false;

        public int solve(TreeNode A) {
            total = computeTotal(A);
            if (total % 2 != 0) return 0;
            post(A);
            return possible ? 1 : 0;
        }

        private long computeTotal(TreeNode node) {
            if (node == null) return 0;
            return node.val + computeTotal(node.left) + computeTotal(node.right);
        }

        private long post(TreeNode node) {
            if (node == null) return 0;
            long sum = node.val + post(node.left) + post(node.right);
            if (sum == total / 2) possible = true;
            return sum;
        }
    }
}
