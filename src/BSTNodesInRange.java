public class BSTNodesInRange {
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
        public int solve(TreeNode A, int B, int C) {
            if (A == null) return 0;

            // If the node value is less than the lower bound,
            // only the right subtree can have valid values
            if (A.val < B) {
                return solve(A.right, B, C);
            }

            // If the node value is greater than the upper bound,
            // only the left subtree can have valid values
            if (A.val > C) {
                return solve(A.left, B, C);
            }

            // The node value is within the range,
            // so count it and continue searching both sides
            return 1 + solve(A.left, B, C) + solve(A.right, B, C);
        }
    }
}
