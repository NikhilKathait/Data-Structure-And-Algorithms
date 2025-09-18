public class lexicographicallySmallestPairFlip {
    public int[] flip(String A) {
        int n = A.length();
        int maxSum = 0;
        int curSum = 0;
        int start = 0;
        int l = -1, r = -1;

        for (int i = 0; i < n; i++) {
            int val = (A.charAt(i) == '0') ? 1 : -1;

            curSum += val;

            if (curSum > maxSum) {
                maxSum = curSum;
                l = start;
                r = i;
            }

            if (curSum < 0) {
                curSum = 0;
                start = i + 1;
            }
        }

        if (l == -1) {
            // No flip improves the string
            return new int[] {};
        }

        // Convert to 1-based indexing
        return new int[] { l + 1, r + 1 };
    }
}
