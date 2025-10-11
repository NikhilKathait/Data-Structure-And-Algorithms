import java.util.*;

public class longestSubArrayWith0SumHashMap {
    public int solve(int[] A) {
        int N = A.length;
        int maxLen = 0;
        long prefixSum = 0;
        HashMap<Long, Integer> map = new HashMap<>();

        for(int i = 0; i< N; i++) {
            prefixSum += A[i];

            // Case 1: subarray from 0 to i sums to 0
            if (prefixSum == 0) {
                maxLen = i + 1;
            }

            // Case 2: if prefixSum seen before
            if (map.containsKey(prefixSum)) {
                int prevIndex = map.get(prefixSum);
                maxLen = Math.max(maxLen, i - prevIndex);
            } else {
                // Store only first occurrence of each prefix sum
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }
}
