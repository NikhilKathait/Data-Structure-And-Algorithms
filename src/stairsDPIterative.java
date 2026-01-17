public class stairsDPIterative {
    static final int MOD = 1000000007;

    public int climbStairs(int A) {
        if (A <= 1) {
            return 1;
        }

        long prev2 = 1;     // f(0)
        long prev1 = 1;     // f(1)
        long curr = 0;

        for (int i = 2; i <= A; i++) {
            curr = (prev1 + prev2) % MOD;
            prev2 = prev1;
            prev1 = curr;
        }

        return (int) curr;
    }
}
