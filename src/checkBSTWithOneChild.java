public class checkBSTWithOneChild {
    public String solve(int[] A) {
        int n = A.length;
        if (n <= 2) return "YES";

        int[] suffixMin = new int[n];
        int[] suffixMax = new int[n];

        suffixMin[n-1] = A[n-1];
        suffixMax[n-1] = A[n-1];

        for (int i = n - 2; i >= 0; --i) {
            suffixMin[i] = Math.min(A[i], suffixMin[i+1]);
            suffixMax[i] = Math.max(A[i], suffixMax[i+1]);
        }

        for (int i = 0; i < n - 1; ++i) {
            int minSuffix = suffixMin[i+1];
            int maxSuffix = suffixMax[i+1];
            // either every element in suffix is > A[i] OR every element in suffix is < A[i]
            if (!(minSuffix > A[i] || maxSuffix < A[i])) {
                return "NO";
            }
        }
        return "YES";
    }
}
