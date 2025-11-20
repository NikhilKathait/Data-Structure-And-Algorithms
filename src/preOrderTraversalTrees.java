import java.util.*;

public class preOrderTraversalTrees {
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
        public int[] preorderTraversal(TreeNode A) {
            if (A == null) return new int[0];

            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> st = new Stack<>();

            st.push(A);

            while (!st.isEmpty()) {
                TreeNode node = st.pop();
                res.add(node.val);

                // Push right first so left is processed first
                if (node.right != null) st.push(node.right);
                if (node.left != null) st.push(node.left);
            }

            int[] ans = new int[res.size()];
            for (int i = 0; i < res.size(); i++)
                ans[i] = res.get(i);

            return ans;
        }
    }
}
