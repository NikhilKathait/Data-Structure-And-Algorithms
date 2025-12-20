public class nextPointerBinaryTree {

     // Definition for binary tree with next pointer.
     public class TreeLinkNode {
        int val;
        TreeLinkNode left, right, next;
        TreeLinkNode(int x) { val = x; }
     }

    public void connect(TreeLinkNode root) {
        if (root == null || root.left == null) return;

        // Connect left child to right child
        root.left.next = root.right;

        // Connect right child to next subtree's left child
        if (root.next != null) {
            root.right.next = root.next.left;
        }

        // Recurse for lower levels
        connect(root.left);
        connect(root.right);
    }
}
