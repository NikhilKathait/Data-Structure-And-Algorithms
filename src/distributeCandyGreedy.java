public class distributeCandyGreedy {
    public int candy(int[] A) {
        int n = A.length;
        int[] left = new int[n];
        int[] right = new int[n];

        // Initialize with 1 candy each
        for (int i = 0; i < n; i++) {
            left[i] = 1;
            right[i] = 1;
        }

        // Left to right pass
        for (int i = 1; i < n ; i++) {
            if (A[i] > A[i-1]) {
                left[i] = left[i-1] + 1;
            }
        }

        // Right to left pass
        for (int i = n - 2; i >= 0 ; i--) {
            if (A[i] > A[i+1]) {
                right[i] = right[i+1] + 1;
            }
        }

        int minCandies = 0;
        for (int i = 0; i < n; i++) {
            minCandies += Math.max(left[i], right[i]);
        }

        return minCandies;
    }
}
