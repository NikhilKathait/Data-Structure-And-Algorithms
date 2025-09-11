public class addMatrices {
    public int[][] solve(int[][] A, int[][] B) {
        int N = A.length;
        int M = A[0].length;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                A[i][j] += B[i][j];
            }
        }

        return A;
    }
}
