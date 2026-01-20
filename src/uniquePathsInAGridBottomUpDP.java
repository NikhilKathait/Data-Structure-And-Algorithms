public class uniquePathsInAGridBottomUpDP {
    public int uniquePathsWithObstacles(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        // If start or end is blocked
        if (A[0][0] == 1 || A[n-1][m-1] == 1) return 0;

        int[][] dp = new int[n][m];

        // starting point
        dp[0][0] = 1;

        // First row
        for (int j=1; j<m; j++) {
            if (A[0][j] == 0) {
                dp[0][j] = dp[0][j-1];
            }
        }

        // First column
        for (int i=1; i<n; i++) {
            if (A[i][0] == 0) {
                dp[i][0] = dp[i-1][0];
            }
        }

        // Fill rest of the grid
        for (int i=1; i<n; i++) {
            for (int j=1; j<m; j++) {
                if (A[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                }
            }
        }

        return dp[n-1][m-1];
    }
}
