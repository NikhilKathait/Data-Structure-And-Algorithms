public class deleteInALinkedList {

     // Definition for singly-linked list.
     class ListNode {
         public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
     }

    public class Solution {
        public ListNode solve(ListNode A, int B) {
            // Case 1: delete head
            if (B == 0) {
                return A.next;
            }

            ListNode curr = A;
            int pos = 0;

            // Move to node just before B-th node
            while (curr != null && pos < B - 1) {
                curr = curr.next;
                pos++;
            }

            // Delete B-th node
            if (curr != null && curr.next != null) {
                curr.next = curr.next.next;
            }

            return A;
        }
    }

}
