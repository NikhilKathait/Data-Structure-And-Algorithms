public class closestPairFromSortedArrays {
    public int[] solve(int[] A, int[] B, int C) {
        int n = A.length, m = B.length;
        int l = 0, r = m-1;
        long dif = (long)(2e9);
        int ans[] = new int[]{-1, -1};
        while(l < n && r >= 0) {
            if(Math.abs(A[l] + B[r] - C) < dif) {
                // update the ans
                dif = Math.abs(A[l] + B[r] - C);
                ans[0] = A[l];  ans[1] = B[r];
            }
            else if(Math.abs(A[l] + B[r] - C) == dif && ans[0] == A[l]){
                // check for the smallest index
                ans[1] = B[r];
            }
            if(A[l] + B[r] >= C)
                r--;
            else
                l++;
        }
        return ans;
    }
}
