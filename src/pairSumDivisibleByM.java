public class pairSumDivisibleByM {
    public int solve(int[] A, int B) {
        int MOD = 1000000007;
        long[] count = new long[B];

        int N = A.length;

        for(int i = 0; i < N; i++) {
            int rem = ((A[i] % B) + B) % B;
            count[rem]++;
        }

        long ans = 0;

        // count of 0s
        long x = count[0];

        // pairs with remainder 0
        ans += (x * (x-1L) / 2) % MOD;

        // pairs with remainder B/2 if B is even
        if (B % 2 == 0) {
            long y = count[B/2];
            ans = (ans + (y * (y-1L) / 2) % MOD) % MOD;
        }

        int i = 1, j = B - 1;

        while(i < j) {
            ans = (ans + (count[i] * count[j]) % MOD) % MOD;
            i++;
            j--;
        }

        return (int) (ans % MOD);
    }
}
