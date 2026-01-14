import java.util.*;

public class productOf3 {
    public int[] solve(int[] A) {
        int n = A.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>();  // min-heap
        int[] result = new int[n];

        for (int i = 0; i<n; i++) {
            pq.offer(A[i]);

            // Keep only 3 largest elements
            if (pq.size() > 3) {
                pq.poll();
            }

            if (pq.size() < 3) {
                result[i] = -1;
            } else {
                long product = 1;
                for (int val : pq) {
                    product *= val;
                }

                result[i] = (int) product;
            }
        }

        return result;
    }
}
