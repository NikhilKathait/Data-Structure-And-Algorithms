public class containerWithMostWater {
    public int maxArea(int[] A) {
        int n = A.length;
        int l = 0, r = n - 1;

        long maxArea = 0;
        while (l < r) {
            int ht = Math.min(A[l], A[r]);
            int w = r - l;

            long area = (long) (ht * w);
            maxArea = Math.max(maxArea, area);

            if (A[l] <= A[r])
                l++;
            else
                r--;
        }

        return (int)maxArea;
    }
}
