public class searchInSortedMatrix {
    public int solve(int[][] A, int B) {
        int N = A.length;
        int M = A[0].length;

        int i = 0, j = M-1;
        int ans = -1;

        while(i < N && j >= 0) {
            if(A[i][j] == B) {
                int code = (i+1) * 1009 + (j+1);

                if(ans == -1 || code < ans) ans = code;

                j--;
            } else if (A[i][j] > B) {
                j--;
            } else {
                i++;
            }
        }

        return ans;
    }
}
