import java.util.*;

public class morrisInorderTraversal {
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

    public int[] solve(TreeNode A) {
        ArrayList<Integer> result = new ArrayList<>();
        TreeNode curr = A;

        while (curr != null) {

            // Case 1: No left child
            if(curr.left == null) {
                result.add(curr.val);   // visit
                curr = curr.right;
            }
            // Case 2: Left child exists
            else {
                TreeNode pred = curr.left;

                // Find inorder predecessor
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                // Create thread
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                }

                // If thread exists already then remove it
                if (pred.right == curr) {
                    pred.right = null;
                    result.add(curr.val);   // Visit
                    curr = curr.right;
                }
            }
        }

        // Convert ArrayList to int[]
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
