public class sortedPermutationRank {
    public int findRank(String A) {
        final int MOD = 1000003;
        int n = A.length();
        int[] fact = new int[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = (int) ((long) fact[i - 1] * i % MOD);
        }

        long rank = 0;
        char[] s = A.toCharArray();
        for (int i = 0; i < n; i++) {
            int smaller = 0;
            for (int j = i + 1; j < n; j++) {
                if (s[j] < s[i])
                    smaller++;
            }

            rank = (rank + (long) smaller * fact[n - i - 1]) % MOD;
        }

        return (int)((rank + 1) % MOD);
    }
}
