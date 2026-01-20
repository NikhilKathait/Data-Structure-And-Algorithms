import java.util.*;

public class uniquePathsInAGridTopDownDP {
    public int uniquePathsWithObstacles(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        if (A[0][0] == 1 || A[n-1][m-1] == 1) return 0;

        int[][] dp = new int[n][m];
        for (int i=0; i<n; i++) {
            Arrays.fill(dp[i], -1);
        }

        return uniquePaths(A, dp, n-1, m-1);
    }

    private int uniquePaths(int[][] A, int[][] dp, int i, int j) {
        if (i < 0 || j < 0) return 0;
        else if (A[i][j] == 1) return 0;
        else if (i == 0 && j == 0) return dp[i][j] = 1;

        if (dp[i][j] != - 1) return dp[i][j];

        return dp[i][j] = uniquePaths(A, dp, i-1, j) + uniquePaths(A, dp, i, j-1);
    }
}
