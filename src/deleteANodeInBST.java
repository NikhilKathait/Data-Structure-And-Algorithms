public class deleteANodeInBST {

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
        public TreeNode solve(TreeNode A, int B) {
            if (A == null) return null;

            if (B < A.val) {
                A.left = solve(A.left, B);
            }
            else if (B > A.val) {
                A.right = solve(A.right, B);
            }
            else {
                // Node found
                if (A.left == null) return A.right;
                if (A.right == null) return A.left;

                // Two childern, use inorder traversal
                TreeNode pred = findMax(A.left);
                A.val = pred.val;

                // Delete predecessor from left subtree
                A.left = solve(A.left, pred.val);
            }

            return A;
        }

        private TreeNode findMax(TreeNode node) {
            while (node.right != null)
                node = node.right;
            return node;
        }
    }
}
