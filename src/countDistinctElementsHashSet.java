import java.util.*;

public class countDistinctElementsHashSet {
    public int solve(int[] A) {
        HashSet<Integer> hs = new HashSet<>();
        int N = A.length;

        for(int i = 0; i<N; i++) {
            hs.add(A[i]);
        }

        return hs.size();
    }
}
