public class buildAHeap {
    public int[] buildHeap(int[] A) {
        int n = A.length;

        // Start heapifying from last non-leaf node
        for (int i = n/2 - 1; i >= 0; i--) {
            downHeapify(A, i, n);
        }

        return A;
    }

    public void downHeapify(int[] A, int idx, int n) {

        while (true) {
            int smallest = idx;
            int left = 2 * idx + 1;
            int right = 2 * idx + 2;

            if (left < n && A[left] < A[smallest]) {
                smallest = left;
            }
            if (right < n && A[right] < A[smallest]) {
                smallest = right;
            }
            if (smallest == idx) {
                break;
            }

            swap(A, idx, smallest);
            idx = smallest;
        }
    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }
}
