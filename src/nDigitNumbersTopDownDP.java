import java.util.*;

public class nDigitNumbersTopDownDP {
    int MOD = 1000000007;
    public int solve(int A, int B) {
        int[][] dp = new int[A+1][B+1];
        for (int i = 0; i <= A; i++) {
            Arrays.fill(dp[i], -1);
        }

        return digSum(A, B, true, dp) % MOD;
    }

    private int digSum(int A, int B, boolean isFirstDig, int[][] dp) {
        if (A == 0 && B == 0) return dp[A][B] = 1;
        if (A == 0 && B > 0) return 0;

        if (dp[A][B] != -1) return dp[A][B];

        int ways = 0;
        int start = isFirstDig == true ? 1 : 0;

        for (int d = start; d <= Math.min(9, B); d++) {
            ways = (ways + digSum(A - 1, B - d, false, dp)) % MOD;
        }

        return dp[A][B] = ways;
    }
}
