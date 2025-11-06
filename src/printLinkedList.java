class ListNode1 {
    public int val;
    public ListNode1 next;
    ListNode1(int x) { val = x; next = null; }
 }

public class printLinkedList {
    public void solve(ListNode1 A) {
        ListNode1 temp = A;

        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }

        System.out.println();
    }
}
