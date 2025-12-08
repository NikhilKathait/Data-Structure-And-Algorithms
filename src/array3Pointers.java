public class array3Pointers {
    public int minimize(final int[] A, final int[] B, final int[] C) {
        int i =0, j=0, k=0;
        int ans = Integer.MAX_VALUE;

        while (i < A.length && j < B.length && k < C.length) {
            int ai = A[i], bj = B[j], ck = C[k];

            // current max distance among the three pairs
            int cur = Math.max(
                    Math.max(Math.abs(ai - bj), Math.abs(bj - ck)),
                    Math.abs(ck - ai)
            );

            if (cur < ans) ans = cur;

            // move the pointer which points to the smallest value
            if (ai <= bj && ai <= ck) {
                i++;
            } else if (bj <= ai && bj <= ck) {
                j++;
            } else {
                k++;
            }
        }

        return ans;
    }
}
