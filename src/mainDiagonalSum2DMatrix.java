public class mainDiagonalSum2DMatrix {
    public int solve(final int[][] A) {
        int N = A.length;
        int sum = 0;

        for(int i= 0; i < N; i++)
        {
            for(int j = i; j == i; j++)
            {
                sum += A[i][j];
            }
        }

        return sum;
    }
}
