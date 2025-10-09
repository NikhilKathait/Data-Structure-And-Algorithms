import java.util.*;

public class commonElementsHashMap {
    public int[] solve(int[] A, int[] B) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        for (int num : A) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Step 2: Find common elements using B
        ArrayList<Integer> common = new ArrayList<>();
        for (int num : B) {
            if (freq.containsKey(num) && freq.get(num) > 0) {
                common.add(num);
                freq.put(num, freq.get(num) - 1); // reduce frequency
            }
        }

        // Step 3: Convert ArrayList to int[]
        int[] result = new int[common.size()];
        for (int i = 0; i < common.size(); i++) {
            result[i] = common.get(i);
        }

        return result;
    }
}
