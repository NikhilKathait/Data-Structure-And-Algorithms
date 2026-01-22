public class Knapsack01 {
    public int solve(int[] A, int[] B, int C) {
        int n = A.length;
        int[] dp = new int[C+1];

        for (int i = 0; i < n; i++) {
            int val = A[i];
            int wt = B[i];

            // Traverse backwards to ensure 0-1 property
            for (int w = C; w >= wt; w--) {
                dp[w] = Math.max(dp[w], dp[w - wt] + val);
            }
        }

        return dp[C];
    }
}
