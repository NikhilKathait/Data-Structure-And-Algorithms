public class countSort {
    public int[] solve(int[] A) {
        int n = A.length;
        if (n == 0) return new int[0];

        // Find maximum value in A
        int max = A[0];
        for (int i = 1; i<n; i++) {
            if (A[i] > max) {
                max = A[i];
            }
        }

        // Frequency array of size max+1
        int[] freq = new int[max + 1];
        for (int i = 0; i < n; i++) {
            freq[A[i]]++;
        }

        // Build sorted result
        int[] result = new int[n];
        int idx = 0;
        for (int i = 0; i <= max; i++) {
            int count = freq[i];
            for (int j = 0; j < count; j++) {
                result[idx++] = i;
            }
        }

        return result;
    }
}
