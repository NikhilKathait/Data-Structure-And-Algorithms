public class sortALinkedListMergeSort {
    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode sortList(ListNode A) {
        if (A == null || A.next == null) {
            return A;
        }

        // Split into two halves
        ListNode mid = getMiddle(A);
        ListNode right = mid.next;
        mid.next = null;

        // Sort each half
        ListNode leftSorted = sortList(A);
        ListNode rightSorted = sortList(right);

        // Merge the sorted halves
        return merge(leftSorted, rightSorted);
    }

    // Find middle node of the linked list
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // Merge two sorted lists
    private ListNode merge(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        while (A != null & B != null) {
            if (A.val <= B.val) {
                tail.next = A;
                A = A.next;
            } else {
                tail.next = B;
                B = B.next;
            }

            tail = tail.next;
        }

        // attach remaining part
        if (A != null) tail.next = A;
        else tail.next = B;

        return dummy.next;
    }
}
