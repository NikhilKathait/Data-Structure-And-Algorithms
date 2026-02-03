public class intersectingChordsInACircle {
    public int chordCnt(int A) {
        int MOD = 1000000007;
        long[] dp = new long[A + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int n = 2; n <= A; n++) {
            long ways = 0;
            for (int i = 0; i < n; i++) {
                ways = (ways + (dp[i] * dp[n - 1 - i]) % MOD) % MOD;
            }
            dp[n] = ways;
        }

        return (int) dp[A];
    }
}
