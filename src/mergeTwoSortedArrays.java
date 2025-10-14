public class mergeTwoSortedArrays {
    public int[] solve(final int[] A, final int[] B) {
        int n = A.length;
        int m = B.length;
        int[] C = new int[n+m];

        int p1 = 0, p2 = 0, k = 0;

        while (p1 < n && p2 < m) {
            if (A[p1] < B[p2]) {
                C[k] = A[p1];
                p1++;
                k++;
            } else {
                C[k] = B[p2];
                p2++;
                k++;
            }
        }

        while (p1 < n) {
            C[k] = A[p1];
            p1++;
            k++;
        }

        while (p2 < m) {
            C[k] = B[p2];
            p2++;
            k++;
        }

        return C;
    }
}
