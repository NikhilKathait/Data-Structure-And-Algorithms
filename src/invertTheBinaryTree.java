public class invertTheBinaryTree {
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

    public TreeNode invertTree(TreeNode A) {
        // Base case
        if (A == null) return null;

        // Swap left and right children
        TreeNode temp = A.left;
        A.left = A.right;
        A.right = temp;

        // Recur for left and right subtrees
        invertTree(A.left);
        invertTree(A.right);

        return A;
    }
}
