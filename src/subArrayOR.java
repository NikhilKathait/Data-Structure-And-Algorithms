public class subArrayOR {
    public int solve(int[] A) {
        int MOD = 1000000007;

        int n = A.length;
        long totalSubarrays = (1L * n * (n+1)) / 2;
        long ans = 0;

        for(int bit = 0; bit < 32; bit++) {
            long notSetCount = 0;
            int len = 0;

            for( int i = 0; i < n; i++) {
                if((A[i] & (1 << bit)) == 0) {
                    len++;
                } else {
                    notSetCount += (1L * len * (len + 1)) / 2;
                    len = 0;
                }
            }

            if(len > 0) {
                notSetCount += (1L * len * (len + 1)) / 2;
            }

            long setCount = totalSubarrays - notSetCount;
            ans = (ans + (setCount % MOD) * ((1L << bit) % MOD)) % MOD;
        }

        return (int) ans;
    }
}
