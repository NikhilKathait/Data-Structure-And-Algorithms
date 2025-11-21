public class sortedArrayToBinaryBST {
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
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public TreeNode sortedArrayToBST(final int[] A) {
            return build(A, 0, A.length - 1);

        }

        private TreeNode build(int[] A, int start, int end) {
            if (start > end) return null;

            int mid = start + (end-start) / 2;
            TreeNode node = new TreeNode(A[mid]);

            node.left = build (A, start, mid - 1);
            node.right = build (A, mid + 1, end);

            return node;
        }
    }
}
