public class validBinarySearchTree {

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
        public int isValidBST(TreeNode A) {
            return isBST(A, Long.MIN_VALUE, Long.MAX_VALUE) ? 1 : 0;
        }

        private boolean isBST(TreeNode root, long start, long end) {
            if (root == null) return true;
            long val = (long) root.val;

            if (val <= start || val >= end) return false;
            return isBST(root.left, start, val) && isBST(root.right, val, end);
        }
    }
}
