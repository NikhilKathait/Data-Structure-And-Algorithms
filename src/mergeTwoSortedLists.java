public class mergeTwoSortedLists {
    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode mergeTwoLists(ListNode A, ListNode B) {
        // handle trivial cases
        if (A == null) return B;
        if (B == null) return A;

        // dummy node simplifies head handling
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (A != null && B != null) {
            if (A.val <= B.val) {
                tail.next = A;
                A = A.next;
            } else {
                tail.next = B;
                B = B.next;
            }
            tail = tail.next;
        }

        // attach remaining part
        if (A != null) tail.next = A;
        else tail.next = B;

        return dummy.next;
    }
}
