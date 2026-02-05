public class numberOfIslands {
    public int solve(int[][] A) {
        int n = A.length;
        int m = A[0].length;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j);
                    cnt++;
                }
            }
        }

        return cnt;
    }

    private void dfs(int[][] A, int row, int col) {
        int n = A.length;
        int m = A[0].length;

        A[row][col] = 2;    // mark visited

        // 8 directions (including diagonals)
        int[] DR = new int[] {-1,-1,-1, 0, 0, 1, 1, 1};
        int[] DC = new int[] {-1, 0, 1,-1, 1,-1, 0, 1};

        for (int k = 0; k < 8; k++) {
            int newRow = row + DR[k];
            int newCol = col + DC[k];

            if (newRow >= 0 && newRow < n &&
                    newCol >= 0 && newCol < m &&
                    A[newRow][newCol] == 1) {

                dfs(A, newRow, newCol);
            }
        }
    }
}
