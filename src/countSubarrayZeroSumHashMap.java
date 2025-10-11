import java.util.*;

public class countSubarrayZeroSumHashMap {
    public int solve(int[] A) {
        int MOD = 1000000007;
        long sum = 0;
        HashMap<Long, Long> map = new HashMap<>();
        int count = 0;

        for (int num : A) {
            sum += num;

            // if sum itself is 0, we found one subarray
            if (sum == 0) count++;

            // if prefixSum appeared before, add its frequency
            if (map.containsKey(sum)) {
                count += map.get(sum);
            }

            // store frequency of prefix sum
            map.put(sum, map.getOrDefault(sum, 0L) + 1);
        }

        return (int) (count % MOD);
    }
}
