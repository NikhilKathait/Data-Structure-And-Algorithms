import java.util.*;

public class pairsWithGivenDifference {
    public int solve(int[] A, int B) {
        if (A == null || A.length == 0) return 0;
        int n = A.length;

        if (B > 0) {
            // Put distinct values in a set and count x where x + B exists
            HashSet<Integer> set = new HashSet<>();
            for (int x : A) set.add(x);

            int count = 0;
            for (int x : set) {
                if (set.contains(x + B)) count++;
            }
            return count;
        } else { // B = 0
            // Count values that appear at least twice
            HashMap<Integer, Integer> freq = new HashMap<>();
            for (int x : A)
                freq.put(x, freq.getOrDefault(x, 0) + 1);

            int count = 0;
            for (int v : freq.values()) {
                if (v > 1)
                    count++;
            }

            return count;
        }
    }
}
