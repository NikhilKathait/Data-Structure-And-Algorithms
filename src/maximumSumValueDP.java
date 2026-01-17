public class maximumSumValueDP {
    public int solve(int[] A, int B, int C, int D) {
        int N = A.length;

        long[] dp1 = new long[N];
        long[] dp2 = new long[N];
        long[] dp3 = new long[N];

        // dp1[i] = max(A[x] * B) for x <= i
        dp1[0] = (long) A[0] * B;
        for (int i = 1; i < N; i++) {
            dp1[i] = Math.max(dp1[i - 1], (long) A[i] * B);
        }

        // dp2[j] = max(dp1[x] + A[j] * C) for x <= j
        dp2[0] = dp1[0] + (long) A[0] * C;
        for (int j = 1; j < N; j++) {
            dp2[j] = Math.max(dp2[j - 1], dp1[j] + (long) A[j] * C);
        }

        // dp3[k] = max(dp2[x] + A[k] * D) for x <= k
        dp3[0] = dp2[0] + (long) A[0] * D;
        for (int k = 1; k < N; k++) {
            dp3[k] = Math.max(dp3[k - 1], dp2[k] + (long) A[k] * D);
        }

        return (int) dp3[N - 1];
    }
}
