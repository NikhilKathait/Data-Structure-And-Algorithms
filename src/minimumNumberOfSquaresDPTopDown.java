import java.util.*;

public class minimumNumberOfSquaresDPTopDown {
    public int countMinSquares(int A) {
        int[] dp = new int[A + 1];
        Arrays.fill(dp, -1);

        return minSquares(A, dp);
    }

    private int minSquares(int A, int[] dp) {
        if (A == 0) {
            return dp[A] = 0;
        }

        if (dp[A] != -1) {
            return dp[A];
        }

        int ans = Integer.MAX_VALUE;

        for (int x = 1; x*x <= A; x++) {
            ans = Math.min(ans, minSquares(A - (x*x), dp));
        }

        return dp[A] = ans + 1;
    }
}
