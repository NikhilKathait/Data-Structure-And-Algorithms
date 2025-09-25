public class unsetXbitsFromRight {
    public long solve(long A, int B) {
        long mask = ~((1L << B) - 1);
        return A & mask;
    }
}
