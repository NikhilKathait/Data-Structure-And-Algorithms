import java.util.*;

public class aggressiveCows {
    public int solve(int[] A, int B) {
        int N = A.length;
        Arrays.sort(A);

        int low = 1;
        int high = A[N - 1] - A[0];
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(A, mid, B) == true) {
                ans = mid;
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return ans;
    }

    private boolean check(int[] A, int mid, int B) {
        int cows = 1;
        int lastPos = A[0];
        int N = A.length;

        for (int i = 1; i < N; i++) {
            if (A[i] - lastPos >= mid) {
                cows++;
                lastPos = A[i];

                if (cows == B) return true;
            }
        }

        return false;
    }
}
