import java.util.*;

public class twoSumBST {
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
        public int t2Sum(TreeNode A, int B) {
            if (A == null) return 0;

            Stack<TreeNode> leftStack = new Stack<>();   // inorder  (small to big)
            Stack<TreeNode> rightStack = new Stack<>();  // rev inorder (big to small)

            // initialize both iterators
            pushLeft(A, leftStack);
            pushRight(A, rightStack);

            TreeNode left = nextSmall(leftStack);
            TreeNode right = nextLarge(rightStack);

            while (left != null && right != null && left != right) {

                long sum = (long) left.val + (long) right.val;

                if (sum == B) return 1;
                else if (sum < B)
                    left = nextSmall(leftStack);
                else
                    right = nextLarge(rightStack);
            }

            return 0;
        }

        // push all left children
        private void pushLeft(TreeNode node, Stack<TreeNode> st) {
            while (node != null) {
                st.push(node);
                node = node.left;
            }
        }

        // push all right children
        private void pushRight(TreeNode node, Stack<TreeNode> st) {
            while (node != null) {
                st.push(node);
                node = node.right;
            }
        }

        // get next smallest
        private TreeNode nextSmall(Stack<TreeNode> st) {
            if (st.isEmpty()) return null;

            TreeNode node = st.pop();
            if (node.right != null) pushLeft(node.right, st);

            return node;
        }

        // get next largest
        private TreeNode nextLarge(Stack<TreeNode> st) {
            if (st.isEmpty()) return null;

            TreeNode node = st.pop();
            if (node.left != null) pushRight(node.left, st);

            return node;
        }
    }
}
