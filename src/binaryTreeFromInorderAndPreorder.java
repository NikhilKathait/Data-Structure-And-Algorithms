import java.util.*;

public class binaryTreeFromInorderAndPreorder {
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
        private int preIndex;
        private int[] preorder;
        private int[] inorder;

        public TreeNode buildTree(int[] A, int[] B) {
            if (A == null || B == null || A.length == 0 || A.length != B.length) return null;
            preorder = A;
            inorder = B;
            preIndex = 0;

            inMap = new HashMap<>();
            for (int i = 0; i < inorder.length; i++) {
                inMap.put(inorder[i], i); // map value -> index in inorder
            }

            return build(0, inorder.length - 1);
        }

        private TreeNode build(int inStart, int inEnd) {
            if (inStart > inEnd) return null;

            int rootVal = preorder[preIndex++];         // take next from preorder
            TreeNode root = new TreeNode(rootVal);

            int idx = inMap.get(rootVal);               // index of root in inorder

            // build left subtree (inorder[inStart .. idx-1])
            root.left = build(inStart, idx - 1);
            // build right subtree (inorder[idx+1 .. inEnd])
            root.right = build(idx + 1, inEnd);

            return root;
        }
    }
}
