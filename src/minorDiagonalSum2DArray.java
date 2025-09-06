public class minorDiagonalSum2DArray {
    public int solve(final int[][] A) {
        int N = A.length;
        int sum = 0;

        for(int i = 0; i< N; i++)
        {
            for(int j = 0; j< N; j++)
            {
                if((i+j+2) == N+1)
                {
                    sum += A[i][j];
                }
            }
        }

        return sum;
    }
}
