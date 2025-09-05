public class allAntiDiagonalsSumIn2DArray {
    public int[][] diagonal(int[][] A) {
        int N = A.length;
        int[][] result = new int[2*N - 1][N];

        int row = 0;

        // Consider all the anti-diagonals starting from 0th row
        for(int k= 0; k < N; k++)
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

        // Consider all the anit-diagonals starting from last column
        for(int k= 1; k < N; k++)
        {
            int i = k, j =  N-1, col = 0;
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
