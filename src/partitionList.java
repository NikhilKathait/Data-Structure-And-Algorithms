public class partitionList {
    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode partition(ListNode A, int B) {

        // Dummy heads
        ListNode lessHead = new ListNode(0);
        ListNode greaterHead = new ListNode(0);

        ListNode less = lessHead;
        ListNode greater = greaterHead;

        ListNode curr = A;

        while (curr != null) {
            if (curr.val < B) {
                less.next = curr;
                less = less.next;
            } else {
                greater.next = curr;
                greater = greater.next;
            }
            curr = curr.next;
        }

        // Important: terminate the greater list
        greater.next = null;

        // Connect the two lists
        less.next = greaterHead.next;

        return lessHead.next;
    }
}
