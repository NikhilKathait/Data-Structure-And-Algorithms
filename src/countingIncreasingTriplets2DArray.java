public class countingIncreasingTriplets2DArray {
    public int solve(int[] A) {
        int N = A.length;
        int count = 0;

        for(int j = 1; j< N-1; j++)
        {
            int leftCount = 0, rightCount = 0;

            // count elements less than A[j] on left
            for(int i = 0; i<j; i++)
            {
                if(A[i] < A[j])
                    leftCount++;
            }

            // count elements greater than A[j] on right
            for(int k = j + 1; k < N; k++)
            {
                if(A[k] > A[j])
                    rightCount++;
            }

            // total triplets with j as middle element
            count += leftCount * rightCount;
        }

        return count;
    }
}
