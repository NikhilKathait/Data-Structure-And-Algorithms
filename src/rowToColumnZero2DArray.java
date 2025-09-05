public class rowToColumnZero2DArray {
    public int[][] solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        for(int i= 0; i < N; i++)
        {
            boolean flag = false;
            for(int j = 0; j < M; j++)
            {
                if(A[i][j] == 0)
                {
                    flag = true;
                }

                if(flag == true)
                {
                    for(j = 0; j < M; j++)
                    {
                        if(A[i][j] > 0)
                        {
                            A[i][j] *= -1;
                        }
                    }
                }
            }
        }

        for(int j= 0; j < M; j++)
        {
            boolean flag = false;
            for(int i = 0; i < N; i++)
            {
                if(A[i][j] == 0)
                {
                    flag = true;
                }

                if(flag == true)
                {
                    for(i = 0; i < N; i++)
                    {
                        if(A[i][j] > 0)
                        {
                            A[i][j] *= -1;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < N; i++)
        {
            for(int j = 0; j < M; j++)
            {
                if (A[i][j] < 0)
                {
                    A[i][j] = 0;
                }
            }
        }

        return A;
    }
}
