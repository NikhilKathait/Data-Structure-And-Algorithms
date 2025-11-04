import java.util.*;

public class findSmallestAgainBinarySearch {
    public int solve(int[] A, int B) {
        Arrays.sort(A);
        int N = A.length;
        long low = (long) A[0] + A[1] + A[2];
        long high = (long) A[N-1] + A[N-2] + A[N-3];
        int ans = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long count = countTriplets(A, mid);

            if (count >= B) {
                ans = (int) mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private long countTriplets(int[] A, long target) {
        int N = A.length;
        long count = 0;

        for (int i = 0; i < N - 2; i++) {
            for (int j = i + 1; j < N - 1; j++) {
                long need = target - A[i] - A[j];
                int idx = upperBound(A, j + 1, N - 1, need);
                count += (idx - (j + 1));
            }
        }
        return count;
    }

    // returns first index > target in sorted array A[l...r]
    private int upperBound(int[] A, int l, int r, long target) {
        int ans = l;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (A[mid] <= target) {
                ans = mid + 1;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return ans;
    }
}
