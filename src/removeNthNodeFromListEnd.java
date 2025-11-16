public class removeNthNodeFromListEnd {

     // Definition for singly-linked list.
     class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
     }
    public class Solution {
        public ListNode removeNthFromEnd(ListNode A, int B) {
            if (A == null) return null;

            ListNode dummy = new ListNode(0);
            dummy.next = A;

            ListNode fast = dummy;
            ListNode slow = dummy;

            // Move fast B steps ahead
            for (int i = 0; i < B; i++) {
                if (fast.next != null) {
                    fast = fast.next;
                } else {
                    // B >= length: delete head
                    return A.next;
                }
            }

            // Move both fast and slow until fast reaches end
            while (fast.next != null) {
                fast = fast.next;
                slow = slow.next;
            }

            // slow is just before the target node
            slow.next = slow.next.next;

            return dummy.next;
        }
    }
}
