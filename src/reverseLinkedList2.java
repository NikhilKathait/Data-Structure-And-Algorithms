public class reverseLinkedList2 {

     // Definition for singly-linked list.
     class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
     }

    public class Solution {
        public ListNode reverseBetween(ListNode A, int B, int C) {
            if (A == null || B == C) return A;

            ListNode dummy = new ListNode(0);
            dummy.next = A;

            ListNode prev = dummy;

            // 1. Move prev to node just before B
            for (int i = 1; i < B; i++) {
                prev = prev.next;
            }

            // curr is the first node of the segment to reverse
            ListNode curr = prev.next;
            ListNode nextNode;

            // 2. Reverse the segment B..C
            for (int i = 0; i < C - B; i++) {
                nextNode = curr.next;
                curr.next = nextNode.next;      // detach nextNode
                nextNode.next = prev.next;      // move nextNode to front
                prev.next = nextNode;           // update start of reversed part
            }

            // 3. Return updated list
            return dummy.next;
        }
    }
}
