public class identicalBinaryTrees {
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

    public int isSameTree(TreeNode A, TreeNode B) {
        return checkIdentical(A, B) ? 1 : 0;
    }

    private boolean checkIdentical(TreeNode A, TreeNode B) {
        // Case 1: If both null then identical
        if (A == null && B == null) return true;

        // Case 2: If only one null then not identical
        if (A == null || B == null) return false;

        // Case 3: If values differ
        if (A.val != B.val) return false;

        // Check left and right subtrees
        return checkIdentical(A.left, B.left) && checkIdentical(A.right, B.right);
    }
}
