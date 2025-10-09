public class divisorGame {
    public int solve(int A, int B, int C) {
        long lcm = (long) B * C / gcd(B, C);
        return (int) (A / lcm);
    }

    public int gcd(int A, int B) {
        if (B == 0) return A;

        return gcd(B, A % B);
    }
}
