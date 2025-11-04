public class matrixMedianBinarySearch {
    public int findMedian(int[][] A) {
        int n = A.length;
        int m = A[0].length;

        int low = Integer.MAX_VALUE;
        int high = Integer.MIN_VALUE;

        // Step 1: find global min and max
        for (int i = 0; i < n; i++) {
            low = Math.min(low, A[i][0]);
            high = Math.max(high, A[i][m - 1]);
        }

        int desired = (n * m + 1) / 2; // median index (1-based)

        // Step 2: Binary Search on value range
        while (low < high) {
            int mid = low + (high - low) / 2;

            int count = 0;
            // Count numbers <= mid
            for (int i = 0; i < n; i++) {
                count += countSmallerThanOrEqual(A[i], mid);
            }

            // If count < desired, move right
            if (count < desired) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return low; // median value
    }

    // Helper: binary search per row
    private int countSmallerThanOrEqual(int[] row, int target) {
        int l = 0, r = row.length;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (row[mid] <= target)
                l = mid + 1;
            else
                r = mid;
        }
        return l; // number of elements <= target
    }
}
