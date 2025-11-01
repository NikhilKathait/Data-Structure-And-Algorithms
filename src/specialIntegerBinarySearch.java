public class specialIntegerBinarySearch {
    public int solve(int[] A, int B) {
        int N = A.length;
        int low = 1;
        int high = N;

        int ans = 0;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if(isValid(A, B, mid)) {
                ans = mid;          // mid is valid
                low = mid + 1;      // try larger K
            }
            else {
                high = mid - 1;     // too large, try smaller
            }
        }

        return ans;
    }

    // Checks if no subarray of size k has sum > B
    private boolean isValid(int[] A, int B, int k) {
        long sum = 0;
        int N = A.length;

        // initial window of size k
        for (int i = 0; i < k; i++) {
            sum += A[i];
        }

        if (sum > B) return false;

        // slide window
        for (int i = k; i < N; i++) {
            sum += A[i] - A[i - k];
            if (sum > B) return false;
        }

        return true;
    }
}
