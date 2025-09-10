public class transposeOfMatrix {
    public int[][] solve(int[][] A) {
        int N = A.length;
        int M = A[0].length;

        int[][] result = new int[M][N];
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                result[j][i] = A[i][j];
            }
        }

        return result;
    }
}
