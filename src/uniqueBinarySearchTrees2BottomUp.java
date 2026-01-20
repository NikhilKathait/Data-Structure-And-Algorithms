public class uniqueBinarySearchTrees2BottomUp {
    public int numTrees(int A) {
        if (A <= 1) return 1;

        int[] dp = new int[A+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int nodes = 2; nodes <= A; nodes++) {
            dp[nodes] = 0;
            for (int root = 1; root <= nodes; root++) {
                dp[nodes] += dp[root - 1] * dp[nodes - root];
            }
        }

        return dp[A];
    }
}
