public class nextPermutationHard {
    public int[] nextPermutation(int[] A) {
        int n = A.length;

        // Find the first decreasing element from right
        int i = n - 2;
        while(i>=0 && A[i] >= A[i+1]) {
            i--;
        }

        if(i >= 0) {
            // Find element just larger than A[i] from right
            int j = n - 1;
            while(A[j] <= A[i]) {
                j--;
            }

            // Swap
            swap(A, i, j);
        }

        // Reverse the suffix from i+1 to end
        reverse(A, i+1, n-1);

        return A;
    }

    private void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    private void reverse(int[] A, int start, int end) {
        while(start < end) {
            swap(A, start, end);
            start++;
            end--;
        }
    }
}
