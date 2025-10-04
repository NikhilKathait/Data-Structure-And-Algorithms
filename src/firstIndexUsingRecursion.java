public class firstIndexUsingRecursion {
    public int FirstIndex(int[] A, int B) {
        // start from index 0, assume first element is max
        return search(A, 0, B);
    }

    private int search(int[] A, int idx, int B) {
        // Base case: if we reached the end of array
        if (idx == A.length) {
            return -1;
        }

        // Check if A[idx] equal to B
        if (A[idx] == B) {
            return idx;
        }

        // Recursive call for next index
        return search(A, idx + 1, B);
    }
}
