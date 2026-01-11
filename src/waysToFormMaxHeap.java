import java.util.*;

public class waysToFormMaxHeap {
    static final int MOD = 1000000007;
    long[][] nCr = new long[101][101];
    long[] dp = new long[101];

    public int solve(int A) {
        buildNCR();
        Arrays.fill(dp, -1);
        return (int) ways(A);
    }

    // number of heaps with n nodes
    long ways(int n) {
        if (n <= 1) return 1;
        if (dp[n] != -1) return dp[n];

        int L = getLeft(n);
        int R = n - 1 - L;

        long ans = nCr[n - 1][L];
        ans = (ans * ways(L)) % MOD;
        ans = (ans * ways(R)) % MOD;

        dp[n] = ans;
        return ans;
    }

    // compute left subtree size
    int getLeft(int n) {
        int h = (int) (Math.log(n) / Math.log(2));
        int nodesBeforeLast = (1 << h) - 1;
        int nodesLast = n - nodesBeforeLast;
        int leftLast = Math.min(1 << (h - 1), nodesLast);

        return (1 << (h - 1)) - 1 + leftLast;
    }

    // build nCr table
    void buildNCR() {
        for (int i = 0; i <= 100; i++) {
            nCr[i][0] = nCr[i][i] = 1;
            for (int j = 1; j < i; j++) {
                nCr[i][j] = (nCr[i - 1][j - 1] + nCr[i - 1][j]) % MOD;
            }
        }
    }
}
