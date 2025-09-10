public class rotateMatrix {
    public void solve(int[][] A) {
        int N = A.length;

        for(int i = 0; i < N; i++) {
            for(int j = i + 1; j < N; j++) {
                int temp = A[i][j];
                A[i][j] = A[j][i];
                A[j][i] = temp;
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N/2; j++) {
                int temp = A[i][j];
                A[i][j] = A[i][N-j-1];
                A[i][N-j-1] = temp;
            }
        }
    }
}
