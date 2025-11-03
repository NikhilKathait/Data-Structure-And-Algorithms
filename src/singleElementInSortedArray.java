public class singleElementInSortedArray {
    public int solve(int[] A) {
        int N = A.length;

        if (N == 1) return A[0];
        if (A[0] != A[1]) return A[0];
        if (A[N-1] != A[N-2]) return A[N-1];

        int low = 1, high = N - 2;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (A[mid] != A[mid-1] && A[mid] != A[mid+1])
                return A[mid];
            if (A[mid] == A[mid-1]) {
                mid = mid - 1;
            }
            if (mid % 2 == 0) {
                low = mid + 2;
            }
            else {
                high = mid - 1;
            }
        }

        return -1;
    }
}
