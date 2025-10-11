import java.util.*;

public class subArraysWithGivenSumHashMap {
    public int[] solve(int[] A, int B) {
        int n = A.length;
        long sum = 0;
        HashMap<Long, Integer> map = new HashMap<>();

        for (int i=0; i<n; i++) {
            sum += A[i];

            // Case 1: If subarray starts at index 0
            if (sum == B) {
                return Arrays.copyOfRange(A, 0, i+1);
            }

            // Case 2: Subarray found using previous prefix sum
            if (map.containsKey(sum - B)) {
                int start = map.get(sum - B) + 1;
                return Arrays.copyOfRange(A, start, i+1);
            }

            // Store first occurrence of this prefix sum
            map.putIfAbsent(sum, i);
        }

        return new int[]{-1};
    }
}
