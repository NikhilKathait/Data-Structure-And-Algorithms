import java.util.*;

public class commonNodesInTwoBST {
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

    public int solve(TreeNode A, TreeNode B) {
        final long MOD = 1000000007L;

        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();

        TreeNode curr1 = A;
        TreeNode curr2 = B;

        long sum = 0;

        while ((curr1 != null || !s1.isEmpty()) &&
                (curr2 != null || !s2.isEmpty())) {

            // Push left nodes of both trees
            while (curr1 != null) {
                s1.push(curr1);
                curr1 = curr1.left;
            }

            while (curr2 != null) {
                s2.push(curr2);
                curr2 = curr2.left;
            }

            TreeNode top1 = s1.peek();
            TreeNode top2 = s2.peek();

            if (top1.val == top2.val) {
                sum = (sum + top1.val) % MOD;
                s1.pop();
                s2.pop();
                curr1 = top1.right;
                curr2 = top2.right;
            }
            else if (top1.val < top2.val) {
                s1.pop();
                curr1 = top1.right;
            }
            else {
                s2.pop();
                curr2 = top2.right;
            }
        }

        return (int) sum;
    }
}
