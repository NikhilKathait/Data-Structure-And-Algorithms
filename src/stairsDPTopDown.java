import java.util.*;

public class stairsDPTopDown {
    static final int MOD = 1000000007;

    public int climbStairs(int A) {
        int[] dp = new int[A+1];
        Arrays.fill(dp, -1);

        return distinctStairs(A, dp);
    }

    private int distinctStairs(int A, int[] dp) {
        if (A <= 1) {
            return dp[A] = 1;
        }

        if (dp[A] != -1)
            return dp[A];

        dp[A] = (distinctStairs(A-1, dp) + distinctStairs(A-2, dp)) % MOD;

        return dp[A];
    }
}
