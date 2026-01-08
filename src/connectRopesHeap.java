import java.util.*;

public class connectRopesHeap {
    public int solve(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int ele: A)
            pq.add(ele);

        int cost = 0;

        while (pq.size() > 1) {
            int r1 = pq.remove();
            int r2 = pq.remove();

            cost += r1 + r2;

            pq.add(r1 + r2);
        }

        return cost;
    }
}
