public class sqrtOfIntegerBinarySearch {
    public int sqrt(int A) {
        if (A == 0 || A == 1) return A;
        int lo = 1;
        int hi = A;
        int ans = 0;

        while (lo <= hi) {
            int mid = lo + (hi - lo)/2;
            long sq = (long) mid*mid;

            if (sq == A) return mid;

            else if (sq > A) {
                hi = mid - 1;
            }
            else {
                ans = mid;
                lo = mid + 1;
            }
        }

        return ans;
    }
}
