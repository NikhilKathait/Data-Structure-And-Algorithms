import java.util.*;

public class inOrderTraversalTrees {

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
        public int[] inorderTraversal(TreeNode A) {
            List<Integer> res = new ArrayList<>();
            Stack<TreeNode> st = new Stack<>();
            TreeNode curr = A;

            while (curr != null || !st.isEmpty()) {

                // Go to leftmost node
                while (curr != null) {
                    st.push(curr);
                    curr = curr.left;
                }

                // Process node
                curr = st.pop();
                res.add(curr.val);

                // Move to right subtree
                curr = curr.right;
            }

            // Convert list to int[]
            int[] ans = new int[res.size()];
            for (int i = 0; i < res.size(); i++)
                ans[i] = res.get(i);

            return ans;
        }
    }

}
