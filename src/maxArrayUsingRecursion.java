public class maxArrayUsingRecursion {
    public int getMax(int[] A) {
        // start from index 0, assume first element is max
        return max(A, 0, A[0]);
    }

    private int max(int[] A, int idx, int currentMax) {
        // Base case: if we reached the end of array
        if (idx == A.length) {
            return currentMax;
        }

        // Update max if needed
        if (A[idx] > currentMax) {
            currentMax = A[idx];
        }

        // Recursive call for next index
        return max(A, idx + 1, currentMax);
    }
}
