public class quickSort {
    public int[] solve(int[] A) {
        quickSort(A, 0, A.length - 1);
        return A;
    }

    private void quickSort(int[] A, int left, int right) {
        if (left < right) {
            int p = partition(A, left, right); // Get pivot index
            quickSort(A, left, p - 1);         // Sort left part
            quickSort(A, p + 1, right);        // Sort right part
        }
    }

    private int partition(int[] A, int i, int j) {
        int pivot = A[i];  // choose last element as pivot
        int l = i + 1;     // index of smaller element
        int r = j;         // index of larger element

        while (l <= r) {
            if (A[l] <= pivot)
                l++;
            else {
                swap(A, l, r);
                r--;
            }
        }

        swap(A, i, r);
        return r;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
