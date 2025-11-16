import java.util.*;

public class sumOfMinAndMaxUsingDeque {
    public int solve(int[] A, int B) {
        int n = A.length;
        Deque<Integer> maxD = new ArrayDeque<>();
        Deque<Integer> minD = new ArrayDeque<>();
        final long MOD = 1000000007L;
        long sum = 0L;

        for (int i = 0; i < n; i++) {

            // Remove indices out of this window (from front)
            while (!maxD.isEmpty() && maxD.peekFirst() <= i - B)
                maxD.pollFirst();
            while (!minD.isEmpty() && minD.peekFirst() <= i - B)
                minD.pollFirst();

            // Maintain max deque (decreasing)
            while (!maxD.isEmpty() && A[maxD.peekLast()] <= A[i])
                maxD.pollLast();
            maxD.addLast(i);

            // Maintain min deque (increasing)
            while (!minD.isEmpty() && A[minD.peekLast()] >= A[i])
                minD.pollLast();
            minD.addLast(i);

            // Start adding results once we have the first full window
            if (i >= B - 1) {
                long maxVal = A[maxD.peekFirst()];
                long minVal = A[minD.peekFirst()];

                // Normalize each value to [0, MOD-1] before adding
                long add = ((maxVal % MOD) + (minVal % MOD) + MOD) % MOD;
                sum = (sum + add) % MOD;
            }
        }

        return (int) sum;
    }
}
