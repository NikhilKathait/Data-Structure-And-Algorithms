public class insertInALinkedList {

     // Definition for singly-linked list.
     class ListNode {
         public int val;
         public ListNode next;
         ListNode(int x) { val = x; next = null; }
     }

    public class Solution {
        public ListNode solve(ListNode A, int B, int C) {
            ListNode newNode = new ListNode(B);

            // If list empty or insert at head (pos 0), new node becomes head
            if (A == null) {
                // For empty list, inserting anywhere yields the new node as head
                return newNode;
            }
            if (C == 0) {
                newNode.next = A;
                return newNode;
            }

            // Traverse to position C-1 or to the tail (whichever comes first)
            ListNode curr = A;
            int pos = 0;
            while (curr.next != null && pos < C - 1) {
                curr = curr.next;
                pos++;
            }

            // Now either pos == C-1 and curr is the node after which we insert,
            // or curr is the tail and pos < C-1 (C > length) -> append at tail.
            newNode.next = curr.next;
            curr.next = newNode;
            return A;
        }
    }
}
