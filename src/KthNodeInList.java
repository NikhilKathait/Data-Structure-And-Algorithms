class ListNode2 {
    public int val;
    public ListNode2 next;
    ListNode2(int x) { val = x; next = null; }
}

public class KthNodeInList {
    public int solve(ListNode2 A, int B) {
        ListNode2 curr = A;
        int index = 0;

        while (curr != null) {
            if (index == B) {
                return curr.val;
            }

            curr = curr.next;
            index++;
        }

        return -1; // If B is out of bounds
    }
}
