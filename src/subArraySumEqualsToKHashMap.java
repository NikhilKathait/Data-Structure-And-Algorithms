import java.util.*;

public class subArraySumEqualsToKHashMap {
    public int solve(int[] A, int B) {
        long sum = 0;
        HashMap<Long, Integer> map = new HashMap<>();
        int count = 0;

        // base case: prefix sum 0 has occurred once
        map.put(0L, 1);

        for (int num : A) {
            sum += num;

            // if there exists a prefix sum (sum - B), it contributes to count
            if (map.containsKey(sum - B)) {
                count += map.get(sum - B);
            }

            // record this prefix sum
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return count;
    }
}
