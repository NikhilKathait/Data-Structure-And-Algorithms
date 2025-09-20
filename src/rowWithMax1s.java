public class rowWithMax1s {
    public int solve(int[][] A) {
        int N = A.length;
        int i = 0, j = N -1;
        int rowIndex = -1;

        while(i < N && j >= 0) {
            if(A[i][j] == 1) {
                rowIndex = i;
                j--;
            } else {
                i++;
            }
        }

        return rowIndex;
    }
}
