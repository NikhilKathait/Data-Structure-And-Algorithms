public class columnSum2DMatrix {
    public int[] solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        int[] result = new int[M];

        for(int j= 0; j < M; j++)
        {
            int sum = 0;
            for(int i = 0; i < N; i++)
            {
                sum += A[i][j];
            }

            result[j] = sum;
        }

        return result;
    }
}
