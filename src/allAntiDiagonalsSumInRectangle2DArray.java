public class allAntiDiagonalsSumInRectangle2DArray {
    public int[][] diagonal(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        // Result array size rows up to (N+M-1)
        // Column size is minimum of (N, M)
        int[][] result = new int[N + M - 1][Math.min(N,M)];

        int row = 0;

        // Consider all the anti-diagonals starting from 0th row to M-1 column
        for(int k= 0; k < M; k++)
        {
            int i = 0, j = k, col = 0;
            while(i < N && j >= 0)
            {
                result[row][col] = A[i][j];
                i++;
                j--;
                col++;
            }
            row++;
        }

        // Consider all the anti-diagonals starting from last column
        for(int k= 1; k < N; k++)
        {
            int i = k, j = M-1, col = 0;
            while(i < N && j >= 0)
            {
                result[row][col] = A[i][j];
                i++;
                j--;
                col++;
            }
            row++;
        }

        return result;
    }
}
