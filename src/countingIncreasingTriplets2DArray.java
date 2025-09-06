public class countingIncreasingTriplets2DArray {
    public int solve(int[] A) {
        int N = A.length;
        int count = 0;

        for(int i = 0; i< N-2; i++)
        {
            for(int j = 1; j< N-1; j++)
            {
                for(int k = 2; k<N; k++)
                {
                    if((i<j && j<k) && (A[i]<A[j] && A[j]<A[k]))
                        count++;
                }
            }
        }

        return count;
    }
}
