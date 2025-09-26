public class subArraysWithOR1 {
    public int subarraysWithOR1(int[] A) {
        int n = A.length;

        // total subarrays
        long total = (long) n * (n + 1) / 2;

        // count zero-only subarrays
        long zeroSubArrays = 0;
        long count = 0;

        for(int i = 0; i < n; i++) {
            if(A[i] == 0) {
                count++;
            } else {
                if (count > 0) {
                    zeroSubArrays += (long) count * (count + 1) / 2;
                    count = 0;
                }
            }
        }

        // if last block was zeros
        if (count > 0) {
            zeroSubArrays += (long) count * (count + 1) / 2;
        }

        return (int) (total - zeroSubArrays);
    }
}
