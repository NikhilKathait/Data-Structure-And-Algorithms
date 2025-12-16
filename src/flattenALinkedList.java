public class flattenALinkedList {

    class ListNode {
        int val;
        ListNode right, down;

        ListNode(int x) {
            val = x;
            right = down = null;
        }
    }

    ListNode flatten(ListNode root) {
        if (root == null || root.right == null)
            return root;

        // Flatten the right list
        root.right = flatten(root.right);

        // Merge current list with right list
        root = merge(root, root.right);

        return root;
    }

    // Merge two sorted lists using down pointer
    private ListNode merge(ListNode a, ListNode b) {
        if (a == null) return b;
        if (b == null) return a;

        ListNode result;

        if (a.val <= b.val) {
            result = a;
            result.down = merge(a.down, b);
        } else {
            result = b;
            result.down = merge(a, b.down);
        }

        result.right = null; // IMPORTANT: remove right pointers
        return result;
    }
}
