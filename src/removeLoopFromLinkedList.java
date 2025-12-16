public class removeLoopFromLinkedList {
    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode solve(ListNode A) {
        if (A == null || A.next == null) return A;

        ListNode slow = A;
        ListNode fast = A;

        // Step 1: Detect loop
        boolean hasLoop = false;
        while (fast!= null && fast.next!= null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) {
                hasLoop = true;
                break;
            }
        }

        // If no loop then return original list
        if (!hasLoop) return A;

        // Step 2: Find start of the loop
        slow = A;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // slow == fast then loop starting node
        ListNode loopStart = slow;

        // Step 3: Find last node in the loop
        ListNode temp = loopStart;
        while (temp.next != loopStart) {
            temp = temp.next;
        }

        // Step 4: Break the loop
        temp.next = null;

        return A;
    }
}
