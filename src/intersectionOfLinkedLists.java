public class intersectionOfLinkedLists {
    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode getIntersectionNode(ListNode A, ListNode B) {
        if(A == null || B == null) return null;

        ListNode headA = A;
        ListNode headB = B;

        while (headA != headB) {

            if (headA == null) {
                headA = B;
            } else {
                headA = headA.next;
            }

            if (headB == null) {
                headB = A;
            } else {
                headB = headB.next;
            }
        }

        // intersection node or null
        return headA;
    }
}
