public class pathSumBST {
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
        public int hasPathSum(TreeNode A, int B) {
            if (A == null) return 0;
            return hasPathSumRec(A, B) ? 1 : 0;
        }

        private boolean hasPathSumRec(TreeNode node, int remaining) {
            if (node == null) return false;

            // If this is a leaf, check if remaining equals node.val
            if (node.left == null && node.right == null) {
                return remaining == node.val;
            }

            // otherwise subtract current node value and recurse
            int newRem = remaining - node.val;
            return hasPathSumRec(node.left, newRem) || hasPathSumRec(node.right, newRem);
        }
    }
}
