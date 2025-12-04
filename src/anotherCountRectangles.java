import java.util.*;

public class anotherCountRectangles {
    public int solve(ArrayList<Integer> A, int B) {
        long ans = 0, mod = (long)(1000000000 + 7);
        int l = 0, r = A.size() - 1;
        while (l < A.size() && r >= 0) {
            if ((long) A.get(l) * A.get(r) < B) {
                // A[l] can form rectangles with any of A[0..r]
                ans = (ans + r + 1) % mod;
                l++;
            } else r--;
        }
        return (int) ans;
    }
}
