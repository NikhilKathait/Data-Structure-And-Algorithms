import java.util.*;

public class reverseLinkedList {

    // Definition for singly-linked list.
     class ListNode {
         public int val;
         public ListNode next;
         ListNode(int x) { val = x; next = null; }
     }

    public class Solution {
        public ListNode reverseList(ListNode A) {
            ListNode prev = null;
            ListNode curr = A;

            while (curr != null) {
                ListNode nextNode = curr.next;   // store next
                curr.next = prev;                // reverse link
                prev = curr;                     // move prev
                curr = nextNode;                 // move curr
            }

            return prev;  // new head
        }
    }
}
