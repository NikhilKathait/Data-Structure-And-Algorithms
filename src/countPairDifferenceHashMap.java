import java.util.*;

public class countPairDifferenceHashMap {
    public int solve(int[] A, int B) {
        final int MOD = 1000000007;
        long ans = 0;

        HashMap<Long, Long> map = new HashMap<>();

        for (int num : A) {
            long x = num;

            // Count pairs where A[i] - A[j] = B
            if (map.containsKey(x - B)) {
                ans = (ans + map.get(x - B)) % MOD;
            }

            // Count pairs where A[j] - A[i] = B
            if (map.containsKey(x + B)) {
                ans = (ans + map.get(x + B)) % MOD;
            }

            // Record current element
            map.put(x, map.getOrDefault(x, 0L) + 1L);
        }

        if (ans < 0) ans += MOD;

        return (int) ans;
    }
}
