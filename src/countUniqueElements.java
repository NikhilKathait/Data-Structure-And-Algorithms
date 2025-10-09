import java.util.*;

public class countUniqueElements {
    public int solve(int[] A) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Step 1: Count frequency of each element
        for (int num : A) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Count how many have frequency == 1
        int count = 0;
        for (int val : freq.values()) {
            if (val == 1) count++;
        }

        return count;
    }
}
