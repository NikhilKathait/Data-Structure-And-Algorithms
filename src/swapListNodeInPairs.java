public class swapListNodeInPairs {
    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode swapPairs(ListNode A) {
        // Dummy node to handle head swaps
        ListNode dummy = new ListNode(0);
        dummy.next = A;

        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            // Nodes to be swapped
            ListNode first = prev.next;
            ListNode second = first.next;

            // Swapping
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev to the next pair
            prev = first;
        }

        return dummy.next;
    }
}
