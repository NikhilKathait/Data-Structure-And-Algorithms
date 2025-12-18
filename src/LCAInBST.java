public class LCAInBST {
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

    public int solve(TreeNode A, int B, int C) {
        while (A != null) {
            if (B < A.val && C < A.val) {
                A = A.left;
            } else if (B > A.val && C > A.val) {
                A = A.right;
            } else {
                return A.val; // LCA found
            }
        }
        return -1; // unreachable since B and C exist
    }
}
