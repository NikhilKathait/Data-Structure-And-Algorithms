import java.util.*;

public class maximumSubArraySumOptimized {
    public int maxSubarray(int A, int B, int[] C) {
        TreeSet<Long> set = new TreeSet<>();
        long prefixSum = 0, maxSum = 0;

        set.add(0L); // to handle subarrays starting from index 0

        for (int i = 0; i < A; i++) {
            prefixSum += C[i];

            // We want smallest prefix ≥ prefixSum - B
            Long ceil = set.ceiling(prefixSum - B);

            if (ceil != null) {
                maxSum = Math.max(maxSum, prefixSum - ceil);
            }

            set.add(prefixSum);
        }

        return (int) maxSum;
    }
}
