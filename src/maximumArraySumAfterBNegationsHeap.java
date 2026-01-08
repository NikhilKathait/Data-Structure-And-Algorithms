import java.util.*;

public class maximumArraySumAfterBNegationsHeap {
    public int solve(int[] A, int B) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all elements in min heap
        for (int val : A) {
            pq.add(val);
        }

        // Perform B operations
        while (B-- > 0) {
            int min = pq.poll();
            pq.add(-min);
        }

        // Calculate sum
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll();
        }

        return sum;
    }
}
