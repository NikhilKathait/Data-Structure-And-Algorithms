public class sumOfAllSubmatrices2D {
    public int solve(int[][] A) {
        int N = A.length;
        int ans = 0;

        for(int i = 0; i<N; i++) {
            for(int j = 0; j<N; j++) {
                int contri = ((i+1)* (j+1))*((N-i)*(N-j));

                ans = ans + A[i][j] * contri;
            }
        }

        return ans;
    }
}
