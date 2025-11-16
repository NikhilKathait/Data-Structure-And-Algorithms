public class kReverseLinkedList {

     // Definition for singly-linked list.
     class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
     }

    public class Solution {
        public ListNode reverseList(ListNode A, int B) {
            if (A == null || B == 1) return A;

            ListNode dummy = new ListNode(0);
            dummy.next = A;

            ListNode prevBlockEnd = dummy;
            ListNode curr = A;

            while (curr != null) {

                // check if a full block of B nodes exists
                ListNode check = curr;
                for (int i = 0; i < B; i++) {
                    if (check == null) return dummy.next;
                    check = check.next;
                }

                // reverse next B nodes
                ListNode prev = null, temp = curr;
                for (int i = 0; i < B; i++) {
                    ListNode nextNode = temp.next;
                    temp.next = prev;
                    prev = temp;
                    temp = nextNode;
                }

                // connect reversed block
                prevBlockEnd.next = prev;
                curr.next = temp;

                // advance to next block
                prevBlockEnd = curr;
                curr = temp;
            }

            return dummy.next;
        }
    }
}
