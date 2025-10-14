public class inversionCountInAnArray {
    private static final int MOD = 1000000007;

    public int solve(int[] A) {
        int n = A.length;
        if (A == null || n <= 1) return 0;

        int[] temp = new int[n]; // reusable temporary array
        return (int) mergeSortAndCount(A, temp, 0, n - 1);
    }

    private long mergeSortAndCount(int[] A, int[] temp, int l, int r) {
        if (l >= r) return 0;

        int mid = l + (r - l) / 2;
        long count = 0;

        count += mergeSortAndCount(A, temp, l, mid);
        count %= MOD;

        count += mergeSortAndCount(A, temp, mid+1, r);
        count %= MOD;

        count += mergeAndCount(A, temp, l, mid, r);
        count %= MOD;

        return count;
    }

    private long mergeAndCount(int[] A, int[] temp, int l, int mid, int r) {
        int i = l, j = mid + 1, k = l;
        long invCount = 0;

        // Merge into temp array
        while (i <= mid && j <= r) {
            if (A[i] <= A[j]) {
                temp[k++] = A[i++];
            } else {
                temp[k++] = A[j++];
                invCount += (mid - i + 1); // all remaining in left are inversions
                invCount %= MOD;
            }
        }

        while (i <= mid) temp[k++] = A[i++];
        while (j <= r) temp[k++] = A[j++];

        // Copy back to original array
        for (i = l; i <= r; i++) {
            A[i] = temp[i];
        }

        return invCount;
    }
}
