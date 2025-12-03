public class consecutiveNumbersSum {
    public int solve(int A) {
        int ways = 0;

        // k is the number of terms
        for (long k = 1; k * (k - 1) / 2 < A; k++) {
            long num = A - k * (k - 1) / 2;
            if (num % k == 0) {
                ways++;
            }
        }

        return ways;
    }
}
