import java.util.*;

public class levelOrderTraversalTrees {
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
        public int[][] solve(TreeNode A) {
            if (A == null) return new int[0][0];

            Queue<TreeNode> q = new LinkedList<>();
            q.add(A);

            List<List<Integer>> levels = new ArrayList<>();

            while(!q.isEmpty()) {
                int sz = q.size();
                List<Integer> level = new ArrayList<>();

                for(int i = 0; i < sz; i++) {
                    TreeNode node = q.remove();
                    level.add(node.val);

                    if(node.left != null)
                        q.add(node.left);
                    if(node.right != null)
                        q.add(node.right);
                }

                levels.add(level);
            }

            // Convert List<List<Integer>> to int[][]
            int[][] ans = new int[levels.size()][];
            for (int i = 0; i < levels.size(); i++) {
                List<Integer> lv = levels.get(i);
                ans[i] = new int[lv.size()];
                for (int j = 0; j < lv.size(); j++) {
                    ans[i][j] = lv.get(j);
                }
            }

            return ans;
        }
    }

}
