public class palindromeList {
    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public int lPalin(ListNode A) {
        // empty or single node is a palindrome
        if (A == null || A.next == null) return 1;

        // find middle
        ListNode slow = A, fast = A;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // determine start of second half
        // if fast != null then odd length
        ListNode secondHead = (fast != null) ? slow.next : slow;

        // reverse second half
        ListNode revSecond = reverseList(secondHead);

        // compare first half and reversed second half
        ListNode p1 = A;
        ListNode p2 = revSecond;
        boolean isPalin = true;

        // only need to compare length of second half
        while (p2 != null) {
            if (p1.val != p2.val) {
                isPalin = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return isPalin ? 1 : 0;
    }

    // reverse a linked list and return new head
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
