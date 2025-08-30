public class subArrayWithLeastAverageSlidingWindow {
    public int solve(int[] A, int B) {
        int average = 0;
        int minIndex = 0;

        for(int i = 0; i<B; i++)
        {
            average += A[i];
        }

        int si = 1, ei = B;
        int N = A.length;
        int minAverage = average;

        while(ei<N)
        {
            average = average - A[si-1] + A[ei];

            if(average < minAverage)
            {
                minIndex = si;
            }

            minAverage = Math.min(minAverage, average);

            si++;
            ei++;
        }

        return minIndex;
    }
}
