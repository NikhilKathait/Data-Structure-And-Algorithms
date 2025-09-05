public class rowSum2DMatrix {
    public int[] solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        int[] result = new int[N];

        for(int i= 0; i < N; i++)
        {
            int sum = 0;
            for(int j = 0; j < M; j++)
            {
                sum += A[i][j];
            }

            result[i] = sum;
        }

        return result;
    }
}
