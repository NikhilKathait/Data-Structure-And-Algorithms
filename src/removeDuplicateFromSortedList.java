public class removeDuplicateFromSortedList {

     // Definition for singly-linked list.
     class ListNode {
         public int val;
         public ListNode next;
         ListNode(int x) { val = x; next = null; }
     }
    public class Solution {
        public ListNode deleteDuplicates(ListNode A) {
            ListNode curr = A;

            while (curr != null && curr.next != null) {
                if (curr.val == curr.next.val) {
                    curr.next = curr.next.next;    // skip duplicate
                } else {
                    curr = curr.next;             // move forward
                }
            }

            return A;
        }
    }
}
