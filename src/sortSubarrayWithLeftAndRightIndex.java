public class sortSubarrayWithLeftAndRightIndex {
    public int[] sortSubarray(int[] A, int B, int C) {
        if (A == null || A.length == 0 || B >= C)
            return A;

        mergeSort(A, B, C);
        return A;
    }

    // Recursive merge sort on A[l..r]
    public void mergeSort(int[] A, int l, int r) {
        // Base case
        if (l >= r) return;

        int mid = l + (r - l) / 2;

        mergeSort(A, l, mid);
        mergeSort(A, mid + 1, r);

        merge(A, l, mid, r);
    }

    // Merge two sorted halves A[l..mid] and A[mid+1..r]
    public void merge(int[] A, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] left = new int[n1];
        int[] right = new int[n2];

        for (int i = 0; i < n1; i++) left[i] = A[l + i];
        for (int j = 0; j < n2; j++) right[j] = A[mid + 1 + j];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) {
            if (left[i] <= right[j]) {
                A[k++] = left[i++];
            } else {
                A[k++] = right[j++];
            }
        }

        while (i < n1) A[k++] = left[i++];
        while (j < n2) A[k++] = right[j++];
    }
}
