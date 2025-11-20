import java.util.*;

public class deserializeBinaryTree {
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

    public class Solution {
        public TreeNode solve(int[] A) {
            if (A.length == 0) return null;
            if (A[0] == -1) return null;

            TreeNode root = new TreeNode(A[0]);
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);

            int i = 1;

            while (!q.isEmpty() && i < A.length) {
                TreeNode curr = q.poll();

                // left child
                if (A[i] != -1) {
                    curr.left = new TreeNode(A[i]);
                    q.add(curr.left);
                }
                i++;

                if (i >= A.length) break;

                // right child
                if (A[i] != -1) {
                    curr.right = new TreeNode(A[i]);
                    q.add(curr.right);
                }
                i++;
            }

            return root;
        }
    }
}
