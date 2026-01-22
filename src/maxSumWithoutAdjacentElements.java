import java.util.*;

public class maxSumWithoutAdjacentElements {
    public int adjacent(int[][] A) {
        int n = A[0].length;

        int[] Amax = new int[n];
        for (int j= 0; j < n; j++) {
            Amax[j] = Math.max(A[0][j], A[1][j]);
        }

        int[] dp = new int[n];
        Arrays.fill(dp, -1);

        return maxSum(Amax, dp, n-1);
    }

    private int maxSum(int[] Amax, int[] dp, int idx) {
        if (idx < 0) return 0;
        else if (idx == 0) return dp[idx] = Amax[0];
        else if (idx == 1) return dp[idx] = Math.max(Amax[0], Amax[1]);

        if (dp[idx] != -1) return dp[idx];

        dp[idx] = Math.max(
                maxSum(Amax, dp, idx - 1),              // Skip current
                Amax[idx] + maxSum(Amax, dp, idx - 2)   // Take current
        );

        return dp[idx];
    }
}
