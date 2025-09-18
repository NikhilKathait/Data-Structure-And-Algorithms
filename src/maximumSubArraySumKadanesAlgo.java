public class maximumSubArraySumKadanesAlgo {
    public int maxSubArray(final int[] A) {
        int N = A.length;

        int ans = Integer.MIN_VALUE;
        int sum = 0;

        for(int i = 0; i< N; i++) {
            sum += A[i];

            if(sum > ans)
                ans = sum;
            if(sum < 0)
                sum = 0;
        }

        return ans;
    }
}
