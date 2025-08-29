import java.util.*;

public class maxPossibleSumFromBothSides {
    public int solve(ArrayList<Integer> A, int B) {
        int n = A.size();

        // Prefix sums (from front)
        int[] prefix = new int[B + 1];
        prefix[0] = 0;
        for (int i = 1; i <= B; i++) {
            prefix[i] = prefix[i - 1] + A.get(i - 1);
        }

        // Suffix sums (from back)
        int[] suffix = new int[B + 1];
        suffix[0] = 0;
        for (int i = 1; i <= B; i++) {
            suffix[i] = suffix[i - 1] + A.get(n - i);
        }

        // Try all splits: i from front, (B-i) from back
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i <= B; i++) {
            int sum = prefix[i] + suffix[B - i];
            maxSum = Math.max(maxSum, sum);
        }

        return maxSum;
    }
}
