public class medianOfTwoSortedArrays {
    public int solve(int[] A, int[] B) {
        // Ensure A is always the smaller array to make binary search valid
        if (A.length > B.length) return solve(B, A);

        int M = A.length;
        int N = B.length;

        int low = 0;
        int high = M;

        while (low <= high) {
            int cut1 = (low + high)/2;

            int cut2 = (N+M+1)/2 - cut1;

            int l1 = (cut1 == 0) ? Integer.MIN_VALUE : A[cut1 - 1];
            int l2 = (cut2 == 0) ? Integer.MIN_VALUE : B[cut2 - 1];
            int r1 = (cut1 == M) ? Integer.MAX_VALUE : A[cut1];
            int r2 = (cut2 == N) ? Integer.MAX_VALUE : B[cut2];

            if (l1 <= r2 && l2 <= r1) {
                if ((N+M) % 2 == 0) {
                    return (Math.max(l1,l2) + Math.min(r1,r2)) / 2;
                }
                else {
                    return Math.max(l1,l2);
                }
            }
            else if (l1 > r2)
                high = cut1 - 1;
            else
                low = cut1 + 1;
        }

        return -1;
    }
}
