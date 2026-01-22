import java.util.*;

public class minSumPathInMatrixTopDownDP {
    public int minPathSum(int[][] A) {
        int m = A.length;
        int n = A[0].length;
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        return minSum(A, dp, m-1, n-1);
    }

    private int minSum(int[][] A, int[][] dp, int row, int col) {
        if (row < 0 || col < 0) return Integer.MAX_VALUE;
        if (row == 0 && col == 0) return A[0][0];

        if (dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];

        int up = minSum(A, dp, row-1, col);
        int left = minSum(A, dp, row, col-1);

        dp[row][col] = A[row][col] + Math.min(up, left);

        return dp[row][col];
    }
}
