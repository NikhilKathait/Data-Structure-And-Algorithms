public class slidingWindowSubArraySum {
    public int solve(int[] A, int B, int C) {
        int preSum = 0;

        // prefix sum from 0 to B-1
        for(int i=0; i < B; i++)
        {
            preSum += A[i];
        }

        if (preSum == C) {return 1;}

        int si = 1, ei = B;     // Index increased by 1 for both si and ei
        int N = A.length;

        while(ei < N)
        {
            preSum = preSum - A[si-1] + A[ei];
            if (preSum == C)
            {
                return 1;
            }
            si++;
            ei++;
        }

        return 0;
    }
}
