public class recoverBinarySearchTree {
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

    public int[] recoverTree(TreeNode A) {
        TreeNode curr = A;
        TreeNode prev = null;
        TreeNode first = null;
        TreeNode second = null;

        while (curr != null) {
            // Case 1: No left child
            if (curr.left == null) {
                // Check violation
                if (prev != null && prev.val > curr.val) {
                    if (first == null)
                        first = prev;
                    second = curr;
                }
                prev = curr;
                curr = curr.right;
            }
            // Case 2: Left child exists
            else {
                TreeNode pred = curr.left;
                while (pred.right != null && pred.right != curr) {
                    pred = pred.right;
                }

                // Create thread
                if (pred.right == null) {
                    pred.right = curr;
                    curr = curr.left;
                }

                // If thread exists then remove it
                else {
                    pred.right = null;

                    if (prev != null && prev.val > curr.val) {
                        if (first == null)
                            first = prev;
                        second = curr;
                    }
                    prev = curr;
                    curr = curr.right;
                }
            }
        }

        int x = first.val;
        int y = second.val;

        // Return in ascending order
        if (x < y)
            return new int[]{x, y};
        else
            return new int[]{y, x};
    }
}
