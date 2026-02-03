public class waysToSendTheSignal {
    public int solve(int A) {
        int MOD = 1000000007;

        if (A == 0) return 1;
        if (A == 1) return 2;

        long prev2 = 1; // dp[0]
        long prev1 = 2; // dp[1]

        for (int i = 2; i <= A; i++) {
            long curr = (prev1 + prev2) % MOD;
            prev2 = prev1;
            prev1 = curr;
        }

        return (int) prev1;
    }
}
