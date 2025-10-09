import java.util.*;

public class countPairSumHashMap {
    public int solve(int[] A, int B) {
        final int MOD = 1000000007;
        long ans = 0;

        HashMap<Long, Long> map = new HashMap<>();

        for (int num : A) {
            long x = num;
            long y = B - x;

            // Each occurrence of y forms a pair with current x
            if( map.containsKey(y)) {
                ans = (ans + map.get(y)) % MOD;
            }

            // Record current x for future pairs
            map.put(x, map.getOrDefault(x, 0L) + 1L);
        }

        return (int) ans;
    }
}
