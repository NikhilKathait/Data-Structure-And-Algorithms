public class sumOfAllSubArraysContribution {
    public long subarraySum(int[] A) {
        long totalSum = 0;
        long N = A.length;

        for (int i = 0; i < N; i++)
        {
            long times = (i+1) * (N-i);
            totalSum += A[i] * times;
        }

        return totalSum;
    }
}
