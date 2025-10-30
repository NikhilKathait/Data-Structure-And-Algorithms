public class findAPeakElementBinarySearch {
    public int solve(int[] A) {
        int N = A.length;
        if (N == 1) return A[0];
        if (A[0] >= A[1]) return A[0];
        if (A[N-1] >= A[N-2]) return A[N-1];

        int low = 1, high = N - 2;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (A[mid + 1] <= A[mid] && A[mid - 1] <= A[mid]) {
                return A[mid];
            }
            else if (A[mid + 1] > A[mid]) {
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
