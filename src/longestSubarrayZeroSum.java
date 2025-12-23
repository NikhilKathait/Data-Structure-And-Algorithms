import java.util.*;

public class longestSubarrayZeroSum {
    public int solve(int[] A) {
        int n = A.length;
        long sum = 0;

        // prefixSum, first index
        HashMap<Long, Integer> map = new HashMap<>();

        int maxLength = 0;

        for (int i = 0; i < n; i++) {
            sum += A[i];

            // Case 1: prefixSum itself is zero
            if (sum == 0) {
                maxLength = i + 1;
            }

            // Case 2: prefix sum seen before
            if (map.containsKey(sum)) {
                int prevIndex = map.get(sum);
                maxLength = Math.max(maxLength, i - prevIndex);
            }
            // store only FIRST occurrence
            else {
                map.put(sum, i);
            }
        }

        return maxLength;
    }
}
