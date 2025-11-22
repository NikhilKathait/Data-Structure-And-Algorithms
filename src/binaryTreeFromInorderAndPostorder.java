import java.util.*;

public class binaryTreeFromInorderAndPostorder {
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
        private Map<Integer, Integer> inMap;
        private int postIndex;

        public TreeNode buildTree(int[] A, int[] B) {
            inMap = new HashMap<>();
            for (int i = 0; i < A.length; i++) inMap.put(A[i], i);
            postIndex = B.length - 1;
            return build(B, 0, A.length - 1);
        }

        private TreeNode build(int[] post, int inStart, int inEnd) {
            if (inStart > inEnd) return null;

            TreeNode root = new TreeNode(post[postIndex--]);
            int idx = inMap.get(root.val);

            root.right = build(post, idx + 1, inEnd);
            root.left = build(post, inStart, idx - 1);

            return root;
        }
    }
}
