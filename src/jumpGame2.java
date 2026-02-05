public class jumpGame2 {
    public int solve(int[] A) {
        int n = A.length;
        if (n <= 1) {
            return 0;
        }

        int jumps = 0;
        int end = 0;
        int farthest = 0;

        for (int i = 0; i < n - 1; i++) {
            farthest = Math.max(farthest, i + A[i]);

            // If we cannot move further
            if ( i == farthest && A[i] == 0) {
                return -1;
            }

            // End of current jump range
            if (i == end) {
                jumps++;
                end = farthest;
            }
        }

        return end >= n - 1 ? jumps : -1;
    }
}
