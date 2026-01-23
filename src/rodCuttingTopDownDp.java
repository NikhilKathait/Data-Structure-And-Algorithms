import java.util.Arrays;

public class rodCuttingTopDownDp {
    public int solve(int[] A) {
        int N = A.length;
        int[] dp = new int[N + 1];

        Arrays.fill(dp, -1);

        return maxValue(A, dp, N);
    }

    private int maxValue(int[] A, int[] dp, int len) {
        // Base case
        if (len == 0) return 0;

        if (dp[len] != -1) return dp[len];

        int ans = 0;

        // Try all possible cuts
        for (int cut = 1; cut <= len; cut++) {
            ans = Math.max(ans, A[cut - 1] + maxValue(A, dp, len - cut));
        }

        return dp[len] = ans;
    }
}
