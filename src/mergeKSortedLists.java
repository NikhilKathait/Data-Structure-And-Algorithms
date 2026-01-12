import java.util.*;

public class mergeKSortedLists {

     // Definition for singly-linked list.
     class ListNode {
          public int val;
          public ListNode next;
          ListNode(int x) { val = x; next = null; }
     }

    public class Solution {
        public ListNode mergeKLists(ArrayList<ListNode> a) {
            PriorityQueue<ListNode> pq = new PriorityQueue<>(
                    (x, y) -> x.val - y.val
            );

            // Add head of each list
            for (ListNode node : a) {
                if (node != null) {
                    pq.offer(node);
                }
            }

            ListNode dummy = new ListNode(0);
            ListNode tail = dummy;

            while (!pq.isEmpty()) {
                ListNode minNode = pq.poll();

                tail.next = minNode;
                tail = tail.next;

                if (minNode.next != null) {
                    pq.offer(minNode.next);
                }
            }

            return dummy.next;
        }
    }
}
