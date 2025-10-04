public class lastIndexUsingRecursion {
    public int LastIndex(int[] A, int B) {
        int N = A.length;

        // start from index 0, assume first element is max
        return lastSearch(A, N-1, B);
    }

    private int lastSearch(int[] A, int idx, int B) {
        // Base case: if we reached the end of array
        if (idx < 0) {
            return -1;
        }

        // Check if A[idx] equal to B
        if (A[idx] == B) {
            return idx;
        }

        // Recursive call for next index
        return lastSearch(A, idx - 1, B);
    }
}
