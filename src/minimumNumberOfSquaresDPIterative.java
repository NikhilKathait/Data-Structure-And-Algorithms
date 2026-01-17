public class minimumNumberOfSquaresDPIterative {
    public int countMinSquares(int A) {
        int[] dp = new int[A+1];
        dp[0] = 0;

        for (int i = 1; i <= A; i++) {
            int ans = Integer.MAX_VALUE;

            for (int x = 1; x*x <= i; x++) {
                ans = Math.min(ans, dp[i - x*x]);
            }
            dp[i] = ans + 1;
        }

        return dp[A];
    }
}
