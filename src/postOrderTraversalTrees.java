import java.util.*;

public class postOrderTraversalTrees {
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
        public int[] postorderTraversal(TreeNode A) {
            ArrayList<Integer> list = new ArrayList<>();
            post(A, list);

            // convert list to array
            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
            return res;
        }

        private void post(TreeNode node, ArrayList<Integer> list) {
            if (node == null) return;
            post(node.left, list);    // Left
            post(node.right, list);   // Right
            list.add(node.val);       // Root
        }
    }
}
