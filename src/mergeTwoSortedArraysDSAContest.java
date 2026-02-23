public class mergeTwoSortedArraysDSAContest {
    public int[] solve(final int[] A, final int[] B) {

        int n = A.length;
        int m = B.length;

        int[] result = new int[n + m];

        int i = 0, j = 0, k = 0;

        // Merge both arrays
        while (i < n && j < m) {
            if (A[i] <= B[j]) {
                result[k++] = A[i++];
            } else {
                result[k++] = B[j++];
            }
        }

        // Add remaining elements from A
        while (i < n) {
            result[k++] = A[i++];
        }

        // Add remaining elements from B
        while (j < m) {
            result[k++] = B[j++];
        }

        return result;
    }
}
