public class AthMagicalNumberBinarySearch {
    static final int MOD = 1000000007;

    public int solve(int A, int B, int C) {
        long lcm = lcm(B, C);
        long low = Math.min(B, C);
        long high = (long) A * low;

        while (low < high) {
            long mid = low + (high - low) / 2;
            long count = mid / B + mid / C - mid / lcm;

            if (count < A)
                low = mid + 1;
            else
                high = mid;
        }

        return (int) (low % MOD);
    }

    // Euclidean GCD
    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // LCM using GCD
    private long lcm(long a, long b) {
        return (a / gcd(a, b)) * b;
    }
}
