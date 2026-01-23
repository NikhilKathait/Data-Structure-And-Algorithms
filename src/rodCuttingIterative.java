public class rodCuttingIterative {
    public int solve(int[] A) {
        int N = A.length;
        int[] dp = new int[N + 1];

        dp[0] = 0;

        for (int len = 1; len <= N; len++) {
            int max = 0;
            for (int cut = 1; cut <= len; cut++) {
                max = Math.max(max, A[cut - 1] + dp[len - cut]);
            }

            dp[len] = max;
        }

        return dp[N];
    }
}
