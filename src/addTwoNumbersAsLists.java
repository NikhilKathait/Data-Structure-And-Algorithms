public class addTwoNumbersAsLists {
    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public ListNode addTwoNumbers(ListNode A, ListNode B) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;

        int carry = 0;

        while (A != null || B != null || carry != 0) {
            int sum = carry;

            if (A != null) {
                sum += A.val;
                A = A.next;
            }

            if (B != null) {
                sum += B.val;
                B = B.next;
            }

            tail.next = new ListNode(sum % 10);
            tail = tail.next;

            carry = sum / 10;
        }

        return dummy.next;
    }
}
