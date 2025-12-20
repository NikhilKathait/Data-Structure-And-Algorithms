public class diameterOfBinaryTree {

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

    int diameter = 0;

    public int solve(TreeNode A) {
        height(A);
        return diameter;
    }

    private int height(TreeNode node) {
        if (node == null) return -1;

        int lh = height(node.left);
        int rh = height(node.right);

        // update diameter at this node
        diameter = Math.max(diameter, lh + rh + 2);

        // return max height
        return Math.max(lh, rh) + 1;
    }
}
