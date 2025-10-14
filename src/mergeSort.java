public class mergeSort {
    public int[] solve(int[] A) {
        int n = A.length;
        if (A == null || n <= 1) return A;

        mergeSort(A, 0, n - 1);

        return A;
    }

    public void mergeSort(int[] A, int start, int end) {
        // Base case
        if (start >= end) return;

        int middle = (start + end) / 2;

        mergeSort(A, start, middle);
        mergeSort(A, middle + 1, end);

        merge(A, start, middle, end);
    }

    public void merge(int[] A, int start, int middle, int end) {
        int[] C = new int[end - start + 1];

        int p1 = start, p2 = middle + 1, k = 0;

        // Merge two sorted halves
        while (p1 <= middle && p2 <= end) {
            if (A[p1] < A[p2]) {
                C[k] = A[p1];
                p1++;
                k++;
            } else {
                C[k] = A[p2];
                p2++;
                k++;
            }
        }

        while (p1 <= middle) {
            C[k] = A[p1];
            p1++;
            k++;
        }

        while (p2 <= end) {
            C[k] = A[p2];
            p2++;
            k++;
        }

        for (int i = 0; i < C.length; i++) {
            A[start + i] = C[i];
        }
    }
}
