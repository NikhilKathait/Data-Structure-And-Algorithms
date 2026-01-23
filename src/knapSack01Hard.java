public class knapSack01Hard {
    public int solve(int[] A, int[] B, int C) {
        int N = A.length;
        int sum = 0;
        for (int val : A) {
            sum += val;
        }

        int[][] dp = new int[N+1][sum+1];

        for (int i = 0; i <= N; i++) {
            for (int j = 0 ; j <= sum; j++) {
                if (j == 0) dp[i][j] = 0;
                else if (i == 0) dp[i][j] = Integer.MAX_VALUE;
                else {
                    int npick = dp[i-1][j];
                    int pick = Integer.MAX_VALUE;
                    int rval = j - A[i - 1];

                    if (rval >= 0 && dp[i-1][rval] != Integer.MAX_VALUE) {
                        pick = B[i - 1] + dp[i - 1][rval];
                    }

                    dp[i][j] = Math.min(pick, npick);
                }
            }
        }

        int ans = -1;

        for (int j = sum; j >= 0; j--) {
            if (dp[N][j] <= C) {
                ans = j;
                break;
            }
        }

        return ans;
    }
}
