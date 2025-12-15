public class longestPalindromicList {
    // Definition for singly-linked list.
    class ListNode {
        public int val;
        public ListNode next;
        ListNode(int x) { val = x; next = null; }
    }

    public int solve(ListNode A) {
        int ans = 1;

        ListNode prev = null;
        ListNode curr = A;

        while (curr != null) {
            ListNode next = curr.next;

            // Reverse current node
            curr.next = prev;

            // EVEN length palindrome
            ans = Math.max(ans, 2 * countCommon(curr, next));

            // ODD length palindrome
            ans = Math.max(ans, 2 * countCommon(prev, next) + 1);

            // Move forward
            prev = curr;
            curr = next;
        }

        return ans;
    }

    private int countCommon(ListNode a, ListNode b) {
        int count = 0;
        while (a != null && b != null && a.val == b.val) {
            count++;
            a = a.next;
            b = b.next;
        }
        return count;
    }
}
