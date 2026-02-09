public class chocolates01Knapsack {
    public int solve(int A, int[] B, int[] C) {
        int n = B.length;
        int[] dp = new int[A + 1];

        for (int i = 0; i < n; i++) {
            int cost = B[i];
            int sweet = C[i];

            // Traverse backwards for 0-1 knapsack
            for (int w = A; w >= cost; w--) {
                dp[w] = Math.max(dp[w], dp[w - cost] + sweet);
            }
        }

        return dp[A];
    }
}
