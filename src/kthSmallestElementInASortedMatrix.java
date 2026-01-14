import java.util.*;

public class kthSmallestElementInASortedMatrix {
    public int solve(int[][] A, int B) {
        int n = A.length;
        int m = A[0].length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(
                Collections.reverseOrder()
        );

        int result = 0;

        for (int i = 0; i <n; i++) {
            for (int j =0; j<m; j++) {
                pq.offer(A[i][j]);

                // Keep only B smallest elements
                if (pq.size() >  B) {
                    pq.poll();
                }
            }
        }

        // Top of max-heap = Bth smallest
        return pq.peek();
    }
}
