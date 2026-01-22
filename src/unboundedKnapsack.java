public class unboundedKnapsack {
    public int solve(int A, int[] B, int[] C) {
        int n = B.length;
        int[] dp = new int[A+1];

        for (int i=0; i<n; i++) {
            int val = B[i];
            int wt = C[i];

            // Traverse Forward to allow reuse of same item
            for (int w = wt; w <= A; w++) {
                dp[w] = Math.max(dp[w], dp[w - wt] + val);
            }
        }

        return dp[A];
    }
}
