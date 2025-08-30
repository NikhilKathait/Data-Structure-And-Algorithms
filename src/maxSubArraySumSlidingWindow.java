public class maxSubArraySumSlidingWindow {
    public long solve(int[] A, int B) {
        long prefixSum = 0;

        // sum for 1st window
        for(int i = 0; i < B; i++)
        {
            prefixSum += A[i];
        }

        long maxSum = prefixSum;

        // 2nd window indices
        int si = 1, ei = B;
        int N = A.length;

        // Using sliding window technique
        while (ei<N)
        {
            prefixSum = prefixSum - A[si-1] + A[ei];
            maxSum = Math.max(maxSum, prefixSum);
            si++;
            ei++;
        }

        return maxSum;
    }
}
