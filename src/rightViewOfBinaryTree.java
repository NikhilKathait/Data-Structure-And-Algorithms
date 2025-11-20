import java.util.*;

public class rightViewOfBinaryTree {
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
        public int[] solve(TreeNode A) {
            if (A == null) return new int[0];

            List<Integer> res = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();

            q.add(A);

            while (!q.isEmpty()) {
                int sz = q.size();
                TreeNode last = null;

                for (int i = 0; i < sz; i++) {
                    TreeNode node = q.remove();
                    last = node;

                    if (node.left != null) q.add(node.left);
                    if (node.right != null) q.add(node.right);
                }

                // last node of this level = right view
                res.add(last.val);
            }

            // convert list to int[]
            int[] ans = new int[res.size()];
            for (int i = 0; i < res.size(); i++)
                ans[i] = res.get(i);

            return ans;
        }
    }
}
