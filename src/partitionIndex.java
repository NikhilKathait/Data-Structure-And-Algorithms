public class partitionIndex {
    public int partition(int[] arr) {
        int n = arr.length;
        if (n == 0) return -1; // defensive (constraints say n>=1)

        int pivot = arr[n-1];  // choose last element as pivot
        int i = -1; // last index where arr[index] < pivot

        for (int j = 0; j < n - 1; j++) {
            if (arr[j] < pivot) {
                i++;
                swap(arr, i, j);
            }
        }

        // place pivot after last smaller element
        swap(arr, i+1, n-1);
        return i+1;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
