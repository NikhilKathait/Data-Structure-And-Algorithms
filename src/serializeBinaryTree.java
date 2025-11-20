import java.util.*;

public class serializeBinaryTree {
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
        public int[] solve(TreeNode A) {
            ArrayList<Integer> list = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<>();

            q.add(A);
            while (!q.isEmpty()) {
                TreeNode node = q.poll();

                if (node == null) {
                    list.add(-1);
                    continue;
                }

                list.add(node.val);
                q.add(node.left);
                q.add(node.right);
            }

            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); i++) res[i] = list.get(i);
            return res;
        }
    }
}
