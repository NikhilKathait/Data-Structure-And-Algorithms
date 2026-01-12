import java.util.*;

public class effectiveInventoryManagementGreedy {
    public int solve(int[] A, int[] B) {
        int n = A.length;
        int MOD = 1000000007;

        // Deadlines with profits
        int[][] items = new int[n][2];
        for (int i = 0; i < n; i++) {
            items[i][0] = A[i];         // deadline
            items[i][1] = B[i];         // profit
        }

        // sort by deadline
        Arrays.sort(items, (x, y) -> Integer.compare(x[0], y[0]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            int deadline = items[i][0];
            int profit = items[i][1];

            minHeap.offer(profit);

            // If we exceed available time slot
            if (minHeap.size() > deadline) {
                minHeap.poll();                 // remove least profit
            }
        }

        long totalProfit = 0;

        while (!minHeap.isEmpty()) {
            totalProfit = (totalProfit + minHeap.poll()) % MOD;
        }

        return (int) totalProfit;
    }
}
