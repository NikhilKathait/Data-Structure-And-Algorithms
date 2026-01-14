import java.util.*;

public class minimumDistanceEqualPairHashMap {
    public int solve(int[] A) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int minDistance = Integer.MAX_VALUE;

        for (int i = 0; i< A.length;i++) {
            if (hm.containsKey(A[i])) {
                int distance = i - hm.get(A[i]);
                minDistance = Math.min(minDistance, distance);
            }
            hm.put(A[i], i);
        }

        return (minDistance == Integer.MAX_VALUE) ? -1 : minDistance;
    }
}
