public class KthSymbolHard {
    public int solve(int A, Long B) {
        if (A == 1) return 0;
        if ((B & 1L) == 0L) {
            // left child, same as parent at (A-1, B/2)
            return solve(A - 1, B >> 1);
        } else {
            // right child, flipped parent
            return 1 - solve(A - 1, B >> 1);
        }
    }
}
