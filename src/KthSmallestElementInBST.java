public class KthSmallestElementInBST {

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

    int count = 0;
    int ans = Integer.MAX_VALUE;

    public int kthsmallest(TreeNode A, int B) {
        count = 0;
        ans = Integer.MAX_VALUE;
        inorder(A, B);
        return ans;
    }

    private void inorder(TreeNode A, int B) {
        if (A == null) return;

        if (ans == Integer.MAX_VALUE)
            inorder(A.left, B);

        count += 1;
        if (count == B){
            ans = A.val;
            return;
        }
        if (ans == Integer.MAX_VALUE)
            inorder(A.right, B);
    }
}
