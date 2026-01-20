import java.util.*;

public class uniqueBinarySearchTrees2TopDown {
    public int numTrees(int A) {
        int[] dp = new int[A+1];
        Arrays.fill(dp, -1);

        return countBST(A, dp);
    }

    private int countBST(int n, int[] dp) {
        if (n <= 1) return 1;

        if (dp[n] != -1)
            return dp[n];

        int count = 0;
        for (int root = 1; root <=n; root++) {
            count += countBST(root - 1, dp) * countBST(n - root, dp);
        }

        return dp[n] = count;
    }
}
