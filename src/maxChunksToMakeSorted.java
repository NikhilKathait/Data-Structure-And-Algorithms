public class maxChunksToMakeSorted {
    public int solve(int[] A) {
        int n = A.length;
        int chunks = 0;
        int max = 0;

        for (int i = 0; i<n; i++) {
            max = Math.max(max, A[i]);

            // When all numbers so far can form [0..i]
            if (max == i) {
                chunks++;
            }
        }

        return chunks;
    }
}
