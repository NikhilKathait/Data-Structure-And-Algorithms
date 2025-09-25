public class unsetbit {
    public int solve(int A, int B) {
        return A & ~(1 << B);
    }
}
