public class luckyNumbers {
    public int solve(int A) {
        int[] cnt = new int[A + 1];  // count of distinct prime factors

        // Sieve-like marking
        for (int p = 2; p <= A; p++) {
            if (cnt[p] == 0) {  // p is prime
                for (int multiple = p; multiple <= A; multiple += p) {
                    cnt[multiple]++;
                }
            }
        }

        int luckyCount = 0;
        for (int i = 1; i <= A; i++) {
            if (cnt[i] == 2) luckyCount++;
        }

        return luckyCount;
    }
}
