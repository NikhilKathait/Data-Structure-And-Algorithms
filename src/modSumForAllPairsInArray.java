public class modSumForAllPairsInArray {
    public int solve(int[] A) {
        int MOD = 1000000007;
        int maxVal = 1000;
        int[] freq = new int[maxVal + 1];

        // Count frequency of each number
        for (int val : A) freq[val]++;

        long sum = 0;

        // Loop over possible divisors y = A[j]
        for (int y = 1; y <= maxVal; y++) {
            if (freq[y] == 0) continue;

            // Loop over numerators x = A[i]
            for (int x = 1; x <= maxVal; x++) {
                if (freq[x] == 0) continue;

                sum += ((long) (x % y) * freq[x] * freq[y]) % MOD;
                sum %= MOD;
            }
        }

        return (int) sum;
    }
}
