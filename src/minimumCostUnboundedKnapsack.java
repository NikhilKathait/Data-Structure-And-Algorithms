public class minimumCostUnboundedKnapsack {
    public int solve(final int[] A, final int[] B, final int[] C) {
        int MOD = 1000000007;

        // Find maximum eating capacity
        int maxCap = 0;
        for (int cap : A) {
            maxCap = Math.max(maxCap, cap);
        }

        // dp[x] = minimum cost to reach capacity x
        int[] dp = new int[maxCap + 1];

        // Initialize with large value
        for (int i = 1; i <= maxCap; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        // Unbounded Knapsack
        for (int i = 1; i <= maxCap; i++) {
            for (int j = 0; j < B.length; j++) {
                if (B[j] <= i && dp[i - B[j]] != Integer.MAX_VALUE) {
                    dp[i] = Math.min(dp[i], dp[i - B[j]] + C[j]);
                }
            }
        }

        // Sum cost for all friends
        long ans = 0;
        for (int cap  : A) {
            ans += dp[cap];
        }

        return (int)(ans % MOD);
    }
}
