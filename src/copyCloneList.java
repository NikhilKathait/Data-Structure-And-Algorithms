public class copyCloneList {

     // Definition for singly-linked list with a random pointer.
     class RandomListNode {
         int label;
         RandomListNode next, random;
         RandomListNode(int x) { this.label = x; }
     };

    public class Solution {
        public RandomListNode copyRandomList(RandomListNode head) {
            if (head == null) return null;

            RandomListNode curr = head;

            // 1. Insert cloned nodes after each original node
            while (curr != null) {
                RandomListNode copy = new RandomListNode(curr.label);
                copy.next = curr.next;
                curr.next = copy;
                curr = copy.next;
            }

            // 2. Set random pointers for cloned nodes
            curr = head;
            while (curr != null) {
                if (curr.random != null) {
                    curr.next.random = curr.random.next;
                }
                curr = curr.next.next;
            }

            // 3. Separate the two lists
            curr = head;
            RandomListNode newHead = head.next;
            RandomListNode copyCurr = newHead;

            while (curr != null) {
                curr.next = curr.next.next;
                if (copyCurr.next != null) {
                    copyCurr.next = copyCurr.next.next;
                }
                curr = curr.next;
                copyCurr = copyCurr.next;
            }

            return newHead;
        }
    }
}
