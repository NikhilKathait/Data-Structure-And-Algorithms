public class searchInBST {

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
        public int solve(TreeNode A, int B) {
            return search(A, B) ? 1 : 0;
        }

        private boolean search(TreeNode root, int k) {
            if (root == null) return false;

            if (root.val == k)
                return true;
            else if (root.val > k)
                return search(root.left, k);
            else
                return search(root.right, k);
        }
    }
}
