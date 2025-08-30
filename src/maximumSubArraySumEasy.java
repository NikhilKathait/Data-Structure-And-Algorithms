public class maximumSubArraySumEasy {
    public int maxSubarray(int A, int B, int[] C) {
        int maxSum = 0;

        for(int i = 0; i < A; i++)
        {
            int currSum = 0;
            for(int j = i; j < A; j++)
            {
                currSum += C[j];

                if(currSum <= B)
                {
                    maxSum = Math.max(maxSum, currSum);
                }
                else
                {
                    break;
                }
            }
        }

        return maxSum;
    }
}
