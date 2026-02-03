public class buyingCandiesUnboundedKnapsack {
    public int solve(int[] A, int[] B, int[] C, int D) {
        int n = A.length;
        int[] dp = new int[D + 1];

        // Unbounded Knapsack
        for (int i = 0; i < n; i++) {
            int cost = C[i];
            int value = A[i] * B[i];    // total sweetness per packet

            for (int w = cost; w <= D; w++) {
                dp[w] = Math.max(dp[w], dp[w - cost] + value);
            }
        }

        return dp[D];
    }
}
