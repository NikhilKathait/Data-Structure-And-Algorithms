import java.util.*;

public class sortArrayInGivenOrder {
    public int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> freq = new HashMap<>();

        // Count frequency of A
        for (int num : A) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        ArrayList<Integer> result = new ArrayList<>();

        // Add elements according to B's order
        for (int num : B) {
            if (freq.containsKey(num)) {
                int count = freq.get(num);
                while (count-- > 0) {
                    result.add(num);
                }

                freq.remove(num);
            }
        }

        // Add remaining elements
        ArrayList<Integer> remaining = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int val = entry.getKey();
            int count = entry. getValue();
            while (count-- > 0) {
                remaining.add(val);
            }
        }

        // Sort remaining elements
        Collections.sort(remaining);

        // Append
        result.addAll(remaining);

        // Convert to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }
}
