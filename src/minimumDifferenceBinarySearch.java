import java.util.*;

public class minimumDifferenceBinarySearch {
    public int solve(int A, int B, int[][] C) {
        // sort every row for two-pointer checks
        for (int i = 0; i < A; i++) {
            Arrays.sort(C[i]);
        }

        int low = 0;
        int high = 1_000_000;
        int ans = high;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            if (isPossible(C, A, mid)) {
                ans = mid;
                high = mid - 1; // try to find smaller cost
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    // Predicate: is there at least one adjacent row pair whose pairwise min absolute difference <= diff?
    private boolean isPossible(int[][] C, int A, int diff) {
        for (int r = 0; r < A - 1; r++) {
            if (pairHasDiffAtMost(C[r], C[r + 1], diff)) return true;
        }
        return false;
    }

    // Two-pointer check: do arrays a and b contain a pair (x in a, y in b) with |x - y| <= diff ?
    private boolean pairHasDiffAtMost(int[] a, int[] b, int diff) {
        int i = 0, j = 0;
        while (i < a.length && j < b.length) {
            int av = a[i];
            int bv = b[j];
            int d = av - bv;
            if (d < 0) d = -d;
            if (d <= diff) return true;

            // advance pointer on the smaller value to try to reduce difference
            if (a[i] < b[j]) i++;
            else j++;
        }
        return false;
    }
}
