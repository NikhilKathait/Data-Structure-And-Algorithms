import java.util.*;

public class checkPairSumHashSet {
    public int solve(int A, int[] B) {
        HashSet<Integer> hs = new HashSet<>();
        int N = B.length;

        for(int i = 0; i<N; i++) {
            int x = B[i];
            int y = A - x;

            if(hs.contains(y))
                return 1;
            else
                hs.add(x);
        }

        return 0;
    }
}
