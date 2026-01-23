public class coinSumInfiniteKnapsack {
    public int coinchange2(int[] A, int B) {
        int MOD = 1000007;
        int[] dp = new int[B+1];

        dp[0] = 1;

        // Iterate over coins
        for (int coin : A) {

            // Build sum using this coin
            for (int sum = coin; sum <= B; sum++) {
                dp[sum] = (dp[sum] + dp[sum - coin]) % MOD;
            }
        }

        return dp[B];
    }
}
