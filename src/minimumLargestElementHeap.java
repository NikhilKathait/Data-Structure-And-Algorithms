import java.util.*;

public class minimumLargestElementHeap {
    public int solve(int[] A, int B) {

        // EDGE CASE: all elements <= 0
        int max = A[0];
        boolean hasPositive = false;

        for (int x : A) {
            max = Math.max(max, x);
            if (x > 0) hasPositive = true;
        }

        if (!hasPositive) {
            return max;   // best is doing no operations
        }

        // Normal heap logic for positive values
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (x, y) -> Integer.compare(
                        x[0] + x[1],
                        y[0] + y[1]
                )
        );

        // Initialize heap
        for (int val: A)
            pq.add(new int[] {val, val, 1});    // current, original, times

        // Perform B operations
        while (B-- > 0) {
            int[] arr = pq.remove();

            arr[2]++;                   // timesUsed++
            arr[0] = arr[1] * arr[2];   // current = original * timesUsed

            pq.add(arr);
        }

        // Find maximum value
        int ans = Integer.MIN_VALUE;
        while (!pq.isEmpty()) {
            ans = Math.max(ans, pq.remove()[0]);
        }

        return ans;
    }
}
