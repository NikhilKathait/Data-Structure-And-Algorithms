import java.util.*;

public class parkingIceCreamTruck {
    public class Solution {
        // DO NOT MODIFY THE ARGUMENTS WITH "final" PREFIX. IT IS READ ONLY
        public int[] slidingMaximum(final int[] A, int B) {
            int n = A.length;

            // Edge case: If B > size, return just max of entire array
            if (B > n) {
                int max = Integer.MIN_VALUE;
                for (int x : A)
                    max = Math.max(max, x);
                return new int[] {max};
            }

            int[] result = new int[n-B+1];
            int idx = 0;

            Deque<Integer> dq = new ArrayDeque<>();

            // Process first B elements
            for (int i = 0; i < B; i++) {
                while (!dq.isEmpty() && A[dq.peekLast()] <= A[i]) {
                    dq.pollLast();
                }
                dq.addLast(i);
            }

            // Process the rest
            for (int i = B; i < n; i++) {
                // Front of deque contains max of previous window
                result[idx++] = A[dq.peekFirst()];

                // Remove out-of-window indices
                while (!dq.isEmpty() && dq.peekFirst() <= i - B) {
                    dq.pollFirst();
                }

                // Maintain decreasing order
                while (!dq.isEmpty() && A[dq.peekLast()] <= A[i]) {
                    dq.pollLast();
                }

                dq.addLast(i);
            }

            // Add max for last window
            result[idx] = A[dq.peekFirst()];

            return result;
        }
    }

}
